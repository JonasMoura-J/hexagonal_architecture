package com.spring.hexagonal.application.ports.out;

import com.spring.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
