package com.spring.hexagonal.adapters.in.controler;

import com.spring.hexagonal.adapters.in.controler.mapper.CustomerMapper;
import com.spring.hexagonal.adapters.in.controler.request.CustomerRequest;
import com.spring.hexagonal.adapters.in.controler.response.CustomerResponse;
import com.spring.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.spring.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.spring.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.spring.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.spring.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);

        updateCustomerInputPort.update(customer, customerRequest.getZipCode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
