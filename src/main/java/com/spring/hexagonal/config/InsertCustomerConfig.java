package com.spring.hexagonal.config;

import com.spring.hexagonal.adapters.out.FindAddresByZipCodeAdapter;
import com.spring.hexagonal.adapters.out.InsertCustomerAdapter;
import com.spring.hexagonal.adapters.out.SendCpfValidationAdpater;
import com.spring.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddresByZipCodeAdapter findAddresByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter,
                                                       SendCpfValidationAdpater sendCpfValidationAdpater){
        return new InsertCustomerUseCase(findAddresByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdpater);
    }
}
