package by.javatr.bank.controller;

import by.javatr.bank.controller.command.Command;
import by.javatr.bank.controller.command.CommandName;
import by.javatr.bank.controller.command.implementation.*;
import by.javatr.bank.controller.exception.ControllerException;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.ADD_OPERATION, new AddOperation());
        repository.put(CommandName.READ_OPERATIONS, new ReadOperations());
        repository.put(CommandName.UPDATE_OPERATION, new UpdateOperation());
        repository.put(CommandName.DELETE_OPERATION, new DeleteOperation());
    }

    Command getCommand(String name) throws ControllerException{
        CommandName commandName = null;
        Command command = null;

        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch(IllegalArgumentException | NullPointerException e) {
            throw new ControllerException("Invalid command name was entered", new IllegalArgumentException());
        }
        return command;
    }
}
