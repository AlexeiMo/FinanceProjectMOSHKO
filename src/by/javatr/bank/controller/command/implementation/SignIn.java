package by.javatr.bank.controller.command.implementation;

import by.javatr.bank.controller.command.Command;
import by.javatr.bank.controller.exception.ControllerException;
import by.javatr.bank.service.ClientService;
import by.javatr.bank.service.exception.ServiceException;
import by.javatr.bank.service.factory.ServiceFactory;

public class SignIn implements Command {
    private final char PARAM_DELIMETER = ' ';

    public String execute(String request) throws ControllerException{
        if(request == null) {
            throw new ControllerException("Request is empty!", new NullPointerException());
        }
        String login = null;
        String password = null;

        String response = null;

        int delimIndex = request.indexOf(PARAM_DELIMETER);

        if(delimIndex == -1) { // если в строке нет пробела
            throw new ControllerException("Incorrect request was entered", new IllegalArgumentException());
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try{
            login = request.substring(0, delimIndex);
            password = request.substring(delimIndex + 1);

            clientService.signIn(login, password);
            response = "Welcome";
            return response;

        } catch(ServiceException e) {
            throw new ControllerException(e.getMessage(), e.getInnerException());
        } catch(IndexOutOfBoundsException e) { // если в запросе нет логина или пароля
            throw new ControllerException("Incorrect request was entered", e);
        }

    }
}
