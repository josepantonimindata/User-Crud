package me.team.usercrud.shared.infrastructure.bus.command;

import me.team.usercrud.shared.domain.bus.command.Command;
import me.team.usercrud.shared.domain.bus.command.CommandHandler;
import me.team.usercrud.shared.domain.bus.command.CommandNotRegisteredError;
import org.springframework.stereotype.Service;
import org.reflections.Reflections;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * need a method that receives a command class and returns the class of the Handler
 */
@Service
public final class CommandHandlerInformation {
    Map<Class<? extends Command>, Class<? extends CommandHandler>> commandtoHandlerMap;

    public CommandHandlerInformation() {
        Reflections reflections = new Reflections("me.usercrud");
        var classes = reflections.getSubTypesOf(CommandHandler.class);
        commandtoHandlerMap = initializeCommandtoHandlerMap(classes);
    }

    public Class<? extends CommandHandler> getHandlerClassOfCommandClass(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        final var commandHandlerClass = commandtoHandlerMap.get(commandClass);
        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    public Map<Class<? extends Command>, Class<? extends CommandHandler>> initializeCommandtoHandlerMap( Set<Class<? extends CommandHandler>> classes) {
        Map<Class<? extends Command>, Class<? extends CommandHandler>> commandToHandlerMap = new HashMap<>();
        for (Class<? extends CommandHandler> handler : classes) {
            ParameterizedType        paramType    = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            commandToHandlerMap.put(commandClass, handler);
        }

        return commandToHandlerMap;
    }
}
