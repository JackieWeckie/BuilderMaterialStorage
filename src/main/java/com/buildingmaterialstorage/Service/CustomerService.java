package com.buildingmaterialstorage.Service;

import com.buildingmaterialstorage.Model.Customer;
import com.buildingmaterialstorage.Repository.CustomerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor(force = true)
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        if (customerRepository == null) {
            throw new IllegalArgumentException("Ошибка: Добавьте параметры в поле <<Покупатели>>!");
        } else {
            return customerRepository.save(customer);
        }
    }

    public Optional<Customer> getCustomerByCustomerId(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Optional<Customer> updateCustomer(Long customerId, Customer updatedCustomer) {
        return customerRepository.findById(customerId).map(existingCustomer -> {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setSurname(updatedCustomer.getSurname());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPassword(updatedCustomer.getPassword());
            return customerRepository.save(existingCustomer);
        });
    }

    public void removeCustomer(Long customerId) {
        if (customerRepository != null && customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        } else {
            throw new IllegalArgumentException("Ошибка: Список покупателей пуст!");
        }
    }
}
