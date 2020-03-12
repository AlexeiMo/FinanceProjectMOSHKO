package by.javatr.bank.controller.command.implementation;

import by.javatr.bank.controller.command.Command;
import by.javatr.bank.controller.exception.ControllerException;
import by.javatr.bank.service.BankService;
import by.javatr.bank.service.exception.ServiceException;
import by.javatr.bank.service.factory.ServiceFactory;

public class ReadOperations implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BankService bankService = serviceFactory.getBankService();

        String response = null;

        try {
            bankService.readOperations();

            response = "Operations was updated and ready to show";
            return response;

        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage(), e);
        }

    }
}
