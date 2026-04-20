package com.spring.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {

    void delete(String id);
}
