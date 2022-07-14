package com.codegym.model;


import com.codegym.model.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(length = 50)
    private String fullName;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(precision = 12)
    private BigDecimal balance;

    @Column
    private boolean deleted = false;

    @OneToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    private Location location;

    public Customer(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public Customer(Long id, String fullName, String email, String phone, BigDecimal balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public Customer(Long id, String fullName, String email, String phone, Location location, BigDecimal balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.location = location;
    }

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO()
                .setId(this.id)
                .setFullName(this.fullName)
                .setBalance(this.balance)
                .setEmail(this.email)
                .setPhone(this.phone)
                .setLocationDTO(this.location.toLocationDTO());
    }
}
