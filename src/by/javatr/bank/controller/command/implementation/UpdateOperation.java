package by.javatr.bank.controller.command.implementation;

import by.javatr.bank.bean.FinanceType;
import by.javatr.bank.bean.Operation;
import by.javatr.bank.controller.command.Command;
import by.javatr.bank.controller.exception.ControllerException;
import by.javatr.bank.service.BankService;
import by.javatr.bank.service.exception.ServiceException;
import by.javatr.bank.service.factory.ServiceFactory;

public class UpdateOperation implements Command {
    private final char PARAM_DELIMETER = ' ';

    public String execute(String request) throws ControllerException {
        if(request == null) {
            throw new ControllerException("Request is empty!", new NullPointerException());
        }

        String response = null;

        try{
            int currentIndex;
            int id;
            double sum;
            FinanceType type;


            currentIndex = request.indexOf(PARAM_DELIMETER);
            if(currentIndex == -1) {
                throw new ControllerException("Incorrect request was entered", new IllegalArgumentException());
            }
            id = Integer.parseInt(request.substring(0, currentIndex));
            request = request.substring(currentIndex + 1);

            currentIndex = request.indexOf(PARAM_DELIMETER);
            if(currentIndex == -1) {
                throw new ControllerException("Incorrect request was entered", new IllegalArgumentException());
            }
            sum = Double.parseDouble(request.substring(0, currentIndex));
            request = request.substring(currentIndex + 1);

            type = FinanceType.valueOf(request.substring(0));

            Operation updOperation = new Operation(id, sum, type);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BankService bankService = serviceFactory.getBankService();

            bankService.updateOperation(id, updOperation);

            response = "Selected operation was successfully updated!";
            return response;

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new ControllerException("Incorrect request was entered" , e);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage(), e.getInnerException());
        }
    }
}
