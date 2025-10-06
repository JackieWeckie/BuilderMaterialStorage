package com.buildingmaterialstorage.Categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;

    private String productCategoryName;

    @ManyToOne
    @JoinColumn(name = "parent_product_category")
    private ProductCategory parentProductCategory;

    @OneToMany(mappedBy = "parentProductCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCategory> subProductCategories = new ArrayList<>();

//    @OneToOne(mappedBy = "parent_product_category", cascade = CascadeType.ALL)
//    private ProductCategory setProductCategory;
}