package by.javatr.bank.service.factory;

import by.javatr.bank.service.BankService;
import by.javatr.bank.service.ClientService;
import by.javatr.bank.service.implementation.BankServiceImpl;
import by.javatr.bank.service.implementation.ClientServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();
    private final BankService bankService = new BankServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public BankService getBankService() {
        return bankService;
    }
}
