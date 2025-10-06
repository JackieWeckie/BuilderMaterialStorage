package com.buildingmaterialstorage.Categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerCategoryId;

    private String customerCategoryName;
}
