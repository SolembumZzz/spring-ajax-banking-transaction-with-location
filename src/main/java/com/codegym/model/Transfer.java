package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transfers")
public class Transfer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id = 0L;

    @NotNull(message = "Transaction amount cannot be left empty")
    @Range(min = 50, max = 1000000000, message = "Transaction amount must be between 50 and 1.000.000.000")
    @Column(precision = 12)
    private BigDecimal transactionAmount;

    @Range(min = 0, max = 100)
    @Column(precision = 3)
    private BigDecimal fee = new BigDecimal(10);

    @Column(precision = 12)
    private BigDecimal feeAmount = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "senderId", referencedColumnName = "id")
    private Customer sender;

    @ManyToOne
    @JoinColumn(name = "recipientId", referencedColumnName = "id")
    private Customer recipient;

    public Transfer(Customer sender, Customer recipient, BigDecimal fee, BigDecimal transactionAmount) {
        this.sender = sender;
        this.recipient = recipient;
        this.fee = fee;
        this.transactionAmount = transactionAmount;
    }
}
