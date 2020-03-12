package by.javatr.bank.controller;

import by.javatr.bank.controller.command.Command;
import by.javatr.bank.controller.exception.ControllerException;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final char PARAM_DELIMETER = ' ';

    public String executeTask(String request) throws ControllerException {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(PARAM_DELIMETER));
        executionCommand = provider.getCommand(commandName);

        String response;
        request = request.substring(request.indexOf(PARAM_DELIMETER) + 1);

        response = executionCommand.execute(request);

        return response;
    }
}
