package com.spring.hexagonal.adapters.in.controler.mapper;

import com.spring.hexagonal.adapters.in.controler.request.CustomerRequest;
import com.spring.hexagonal.adapters.in.controler.response.CustomerResponse;
import com.spring.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "address",ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
