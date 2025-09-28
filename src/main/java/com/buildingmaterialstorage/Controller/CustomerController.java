package com.buildingmaterialstorage.Controller;

import com.buildingmaterialstorage.Model.Customer;
import com.buildingmaterialstorage.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/registration")
    public Customer customerRegistration(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/update-customer-data")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @PathVariable Customer customer) {
        Optional<Customer> updatedCustomer = customerService.updateCustomer(customerId, customer);
        return updatedCustomer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/find-customer-by-id")
    public String getCustomerByCustomerId(Long customerId) {
        customerService.getCustomerByCustomerId(customerId);
        return "redirect:/main";
    }

    @DeleteMapping("/remove-customer-by-id")
    public String deleteCustomer(Long customerId) {
        customerService.removeCustomer(customerId);
        return "redirect:/main";
    }
}
