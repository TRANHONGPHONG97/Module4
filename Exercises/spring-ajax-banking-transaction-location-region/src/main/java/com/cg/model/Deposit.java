package com.cg.model;

import com.cg.model.BaseEntity;
import com.cg.model.Customer;
import com.cg.model.dto.DepositDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "deposits")
@Accessors(chain = true)
public class Deposit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin(value = "100", message = "Số tiền tối thiểu là 100")
    @DecimalMax(value = "10000", message = "Số tiền tối đa là 10.000")
    @Column(name = "transaction_amount", precision = 12, scale = 0)
    private BigDecimal transactionAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public DepositDTO toDepositDTO() {
        return new DepositDTO()
                .setId(String.valueOf(id))
                .setTransactionAmount(String.valueOf(transactionAmount));
    }
}