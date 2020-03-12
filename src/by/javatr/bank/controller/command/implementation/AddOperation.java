package by.javatr.bank.controller.command.implementation;

import by.javatr.bank.bean.FinanceType;
import by.javatr.bank.controller.command.Command;
import by.javatr.bank.controller.exception.ControllerException;
import by.javatr.bank.service.BankService;
import by.javatr.bank.service.exception.ServiceException;
import by.javatr.bank.service.factory.ServiceFactory;

public class AddOperation implements Command {
    private final char PARAM_DELIMETER = ' ';

    @Override
    public String execute(String request) throws ControllerException {
        if(request == null) {
            throw new ControllerException("Request is empty!", new NullPointerException());
        }
        double sum = 0;
        FinanceType type = null;

        String response = null;

        int delimIndex = request.indexOf(PARAM_DELIMETER);

        if(delimIndex == -1) { // если в строке нет пробела
            throw new ControllerException("Incorrect request was entered", new IllegalArgumentException());
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BankService bankService = serviceFactory.getBankService();

        try{
            sum = Double.parseDouble(request.substring(0, delimIndex));
            type = FinanceType.valueOf(request.substring(delimIndex + 1));

            bankService.addOperation(type, sum);
            response = "Operation successfully added to your bank account!";
            return response;
        } catch(ServiceException e) {
            throw new ControllerException(e.getMessage(), e.getInnerException());
        } catch(IllegalArgumentException e) {
            throw new ControllerException("No such finance type was found", e);
        }
    }
}
