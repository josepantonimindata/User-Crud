package me.team.usercrud.shared.infrastructure.bus;

import me.team.usercrud.shared.domain.bus.command.Command;
import me.team.usercrud.shared.domain.bus.command.CommandBus;
import me.team.usercrud.shared.domain.bus.command.CommandHandlerExecutionError;

public final class InMemorySyncCommandBus implements CommandBus {
    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        //
    }
}
