package com.spring.hexagonal.application.core.usecase;

import com.spring.hexagonal.application.core.domain.Customer;
import com.spring.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.spring.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;


    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);
    }
}
