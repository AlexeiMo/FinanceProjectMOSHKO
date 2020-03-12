package by.javatr.bank.controller.command.implementation;

import by.javatr.bank.controller.command.Command;
import by.javatr.bank.controller.exception.ControllerException;
import by.javatr.bank.service.BankService;
import by.javatr.bank.service.exception.ServiceException;
import by.javatr.bank.service.factory.ServiceFactory;

public class DeleteOperation implements Command {
    public String execute(String request) throws ControllerException {
        if(request == null) {
            throw new ControllerException("Request is empty!", new NullPointerException());
        }

        String response = null;

        try {
            int id = Integer.parseInt(request);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BankService bankService = serviceFactory.getBankService();

            bankService.deleteOperation(id);

            response = "Selected operation was successfully removed from your account!";
            return response;

        } catch (NumberFormatException e) {
            throw new ControllerException("Incorrect request was entered", e);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage(), e.getInnerException());
        }
    }
}
