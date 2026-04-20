package com.spring.hexagonal.adapters.in.controler.response;

import com.spring.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private AddressResponse address;
    private String cpf;
    private boolean isValidCpf;
}
