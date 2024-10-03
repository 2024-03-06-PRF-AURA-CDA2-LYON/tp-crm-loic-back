package org.example.tpcrm2i.controllers;

import org.example.tpcrm2i.entities.Customer;
import org.example.tpcrm2i.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.sql.Types.NULL;

@SpringBootApplication
@RestController
@RequestMapping(value = "/customers", produces = "application/json")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return this.customerRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        this.customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        this.customerRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerPut = this.customerRepository.findById(id);
        customerPut.get().setCompany_name(customer.getCompany_name() != null ? customer.getCompany_name() : customerPut.get().getCompany_name());;
        customerPut.get().setFirst_name(customer.getFirst_name() != null ? customer.getFirst_name() : customerPut.get().getFirst_name());
        customerPut.get().setLast_name(customer.getLast_name() != null ? customer.getLast_name() : customerPut.get().getLast_name());
        customerPut.get().setEmail(customer.getEmail() != null ? customer.getEmail() : customerPut.get().getEmail());
        customerPut.get().setPhone_number(customer.getPhone_number() != null ? customer.getPhone_number() : customerPut.get().getPhone_number());
        customerPut.get().setAddress(customer.getAddress() != null ? customer.getAddress() : customerPut.get().getAddress());
        customerPut.get().setZip_code(customer.getZip_code() != null ? customer.getZip_code() : customerPut.get().getZip_code());
        customerPut.get().setCountry(customer.getCountry() != null ? customer.getCountry() : customerPut.get().getCountry());
        customerPut.get().setCity(customer.getCity() != null ? customer.getCity() : customerPut.get().getCity());
        customerPut.get().setState(customer.getState() != NULL ? customer.getState() : customerPut.get().getState());
        return this.customerRepository.save(customerPut.get());
    }

}