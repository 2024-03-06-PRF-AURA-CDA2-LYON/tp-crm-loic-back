package org.example.tpcrm2i.controllers;

import org.example.tpcrm2i.entities.Customer;
import org.example.tpcrm2i.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "/customers", produces = "application/json")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    // TODO: WIP
    @GetMapping
    public String getAllCustomers() {
        return "La liste des customers";
    }

    @PostMapping("/create")
    public void addCustomer(@RequestBody Customer customer) {
        this.customerRepository.save(customer);
    }

}