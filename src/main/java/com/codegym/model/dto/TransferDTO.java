package com.codegym.model.dto;

import com.codegym.model.Customer;
import com.codegym.model.Transfer;
import com.codegym.utility.ValidationUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransferDTO {
    @Length(min = 1, message = "Transaction amount invalid")
    @Pattern(regexp = ValidationUtils.NUMBERONLY_REGEX, message = "transactionAmount invalid")
    private String transactionAmount;
    private String fee;
    private String senderId;

    @NotEmpty(message = "Recipient id empty")
    @Length(min = 1, message = "Id invalid")
    @Pattern(regexp = ValidationUtils.NUMBERONLY_REGEX, message = "Id invalid")
    private String recipientId;

    public Transfer toTransfer(TransferDTO transferDTO, Customer sender, Customer recipient) {
        Transfer transfer = new Transfer();
        transfer.setSender(sender);
        transfer.setRecipient(recipient);
        transfer.setFee(new BigDecimal(transferDTO.getFee()));
        transfer.setTransactionAmount(new BigDecimal(transferDTO.getTransactionAmount()));
        return transfer;
    }
}
