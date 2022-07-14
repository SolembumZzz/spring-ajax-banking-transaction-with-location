package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT NEW com.codegym.model.dto.CustomerDTO (c.id, c.fullName, c.email, c.phone, c.location, c.balance) " +
            "FROM Customer AS c WHERE c.id=:id")
    CustomerDTO selectCustomerDTO(@Param("id") Long id);

    @Query("SELECT NEW com.codegym.model.dto.CustomerDTO (c.id, c.fullName, c.email, c.phone, c.location, c.balance) " +
            "FROM Customer AS c " +
            "WHERE c.deleted = false")
    List<CustomerDTO> selectAllCustomersDTO();

    @Query("SELECT NEW com.codegym.model.dto.CustomerDTO (c.id, c.fullName) " +
            "FROM Customer AS c " +
            "WHERE c.deleted = false AND c.id<>?1")
    List<CustomerDTO> selectAllRecipientsDTO(Long id);
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdIsNot(String email, Long id);

    boolean existsByPhone(String phone);

    boolean existsByPhoneAndIdIsNot(String phone, Long id);

    boolean existsByIdAndDeletedTrue(Long id);

    @Modifying
    @Procedure("sp_deposit")
    boolean deposit(Long id, BigDecimal transactionAmount);

    @Modifying
    @Procedure("sp_withdraw")
    boolean withdraw(Long id, BigDecimal transactionAmount);

    @Modifying
    @Procedure("sp_transfer")
    boolean transfer(Long senderId, Long recipientId, BigDecimal fee, BigDecimal transactionAmount);

    @Modifying
    @Procedure("sp_transfer")
    boolean transferByDTO(Long senderId, Long recipientId, BigDecimal fee, BigDecimal transactionAmount);
}
