package me.team.usercrud.shared.infrastructure.bus.command;

import me.team.usercrud.shared.domain.bus.command.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public final class InMemorySyncCommandBus implements CommandBus {
    private final CommandHandlerInformation commandHandlerInformation;
    private final ApplicationContext context;

    public InMemorySyncCommandBus(CommandHandlerInformation commandHandlerInformation, ApplicationContext context) {
        this.commandHandlerInformation = commandHandlerInformation;
        this.context = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            final var commandHandlerClass =
                    commandHandlerInformation.getHandlerClassOfCommandClass(command.getClass());

            final var handler = context.getBean(commandHandlerClass);
            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
