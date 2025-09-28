package com.buildingmaterialstorage.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "customer_name", nullable = false)
    @Size(max = 64)
    private String name;

    @Column(name = "customer_surname", nullable = false)
    @Size(max = 128)
    private String surname;

    @Column(name = "customer_email", nullable = false)
    private String email;

    @Column(name = "customer_password", nullable = false)
    @Size(min = 8)
    private String password;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public @Size(max = 64) String getName() {
        return name;
    }

    public void setName(@Size(max = 64) String name) {
        this.name = name;
    }

    public @Size(max = 128) String getSurname() {
        return surname;
    }

    public void setSurname(@Size(max = 128) String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @Size(min = 8) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8) String password) {
        this.password = password;
    }
}
