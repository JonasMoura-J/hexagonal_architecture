package com.spring.hexagonal.application.ports.out;

import com.spring.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
