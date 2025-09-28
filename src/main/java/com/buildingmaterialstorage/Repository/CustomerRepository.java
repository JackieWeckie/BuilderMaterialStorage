package com.buildingmaterialstorage.Repository;

import com.buildingmaterialstorage.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
