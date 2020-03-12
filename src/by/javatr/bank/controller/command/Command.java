package by.javatr.bank.controller.command;

import by.javatr.bank.controller.exception.ControllerException;

public interface Command {
    public String execute(String request) throws ControllerException;
}
