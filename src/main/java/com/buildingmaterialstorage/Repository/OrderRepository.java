package com.buildingmaterialstorage.Repository;

import com.buildingmaterialstorage.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
