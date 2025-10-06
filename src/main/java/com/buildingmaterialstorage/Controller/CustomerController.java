package com.buildingmaterialstorage.Controller;

import com.buildingmaterialstorage.Categories.CustomerCategory;
import com.buildingmaterialstorage.Model.Customer;
import com.buildingmaterialstorage.Service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private final CustomerService customerService;
    @Autowired
    private Customer customer;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Customer customer) {
        customerService.addCustomer(customer);
        return "registration";
    }

    @PostMapping("/registration")
    public String RegisteredCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                     BindingResult registrationResult) {
        if (registrationResult.hasErrors()) {
            return "registration";
        }

        try {
            customerService.addCustomer(customer);
            return "redirect:/login?registered";
        } catch (Exception e) {
            return "registration";
        }
    }

    @PutMapping("/update-customer-data")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @PathVariable Customer customer) {
        Optional<Customer> updatedCustomer = customerService.updateCustomer(customerId, customer);
        return updatedCustomer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/customer/set-customer-category")
    public String setCustomerCategory(Long customerId, CustomerCategory customerCategory) {
        customerService.setCustomerCategory(customerId, customerCategory);
        return "redirect:/main";
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
