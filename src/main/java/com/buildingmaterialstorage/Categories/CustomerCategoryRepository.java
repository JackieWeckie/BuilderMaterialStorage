package com.buildingmaterialstorage.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerCategoryRepository extends JpaRepository<CustomerCategory, Long> {
}
