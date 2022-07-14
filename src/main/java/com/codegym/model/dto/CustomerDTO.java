package com.codegym.model.dto;

import com.codegym.model.Customer;
import com.codegym.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CustomerDTO implements Serializable {
    private Long id;

    @NotBlank(message = "Customer name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-z]*([ ][A-Z][a-z]*)*$", message = "Name has to begin with capital letters")
    @Length(min = 1, max = 50, message = "Customer name has to be between 5 and 50 characters")
    private String fullName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email invalid")
    @Length(min = 5, max = 50, message = "Email has to be between 5 and 50 characters")
    private String email;

    @Pattern(regexp = "^(\\+0?1\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", message = "Please use a valid number following this pattern: +91 (123) 456 7890")
    @Length(min = 5, max = 20, message = "Phone number has to be between 5 and 20 characters")
    private String phone;

    @Valid
    private LocationDTO locationDTO;

    private BigDecimal balance;

    public CustomerDTO(Long id, String fullName, String email,
                       String phone, Location locationDTO, BigDecimal balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.locationDTO = locationDTO.toLocationDTO();
        this.balance = balance;
    }

    public CustomerDTO(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Customer toCustomer() {
        return new Customer()
                .setId(this.id)
                .setFullName(this.fullName)
                .setEmail(this.email)
                .setPhone(this.phone)
                .setBalance(this.balance)
                .setLocation(this.locationDTO.toLocation());
    }
}
