package com.finalYearProject.enterPot.controller;

import com.finalYearProject.enterPot.domain.Customer;
import com.finalYearProject.enterPot.domain.Login;
import com.finalYearProject.enterPot.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @CrossOrigin
    @PostMapping("/")
    public Long createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer).getId();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new ResourceNotFoundException("Customer not found");
        }
        return customer;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new ResourceNotFoundException("Customer not found");
        }
        customerRepository.delete(customer.get());
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Long updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new ResourceNotFoundException("Customer not found");
        }
        customer.get().setAddressLineOne(updatedCustomer.getAddressLineOne());
        customer.get().setAddressLineTwo(updatedCustomer.getAddressLineTwo());
        customer.get().setBirthday(updatedCustomer.getBirthday());
        customer.get().setCardExpDate(updatedCustomer.getCardExpDate());
        customer.get().setCardNumber(updatedCustomer.getCardNumber());
        customer.get().setCity(updatedCustomer.getCity());
        customer.get().setCountry(updatedCustomer.getCountry());
        customer.get().setFirstName(updatedCustomer.getFirstName());
        customer.get().setLastName(updatedCustomer.getLastName());
        customer.get().setPassword(updatedCustomer.getPassword());
        customer.get().setPostalCode(updatedCustomer.getPostalCode());
        return customerRepository.save(customer.get()).getId();
    }

    @CrossOrigin
    @PostMapping("/login")
    public Object login(@RequestBody Login login) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmail(login.getEmail());
        if(!customer.isPresent()){
            throw new ResourceNotFoundException("Customer Not Registered");
        }
        if(customer.get().getPassword().equals(login.getPassoword())){
            return customer.get();
        }
        return -1;
    }
}
