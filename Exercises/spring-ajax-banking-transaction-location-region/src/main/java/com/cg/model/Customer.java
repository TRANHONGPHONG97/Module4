package com.cg.model;

import com.cg.model.BaseEntity;
import com.cg.model.Deposit;
import com.cg.model.Transfer;
import com.cg.model.Withdraw;
import com.cg.model.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
@Accessors(chain = true)
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Email(message = "Nhập đúng kiểu email")
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 50, message = "Email dài từ 5-50 kí tự")
    @Column(nullable = false, unique = true)
    private String email;

    private String phone;
//    private String address;

    @Column(precision = 12, scale = 0, updatable = false)
    //undatable = false : khi cập nhật customer thì trường balace không bị mất
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", nullable = false)
    private LocationRegion locationRegion;


    @OneToMany(mappedBy = "customer")
    private List<Deposit> deposits;

    @OneToMany(mappedBy = "customer")
    private List<Withdraw> withdraws;

    @OneToMany(mappedBy = "sender")
    private List<Transfer> senders;

    @OneToMany(mappedBy = "recipient")
    private List<Transfer> recipients;

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setBalance(balance)
                .setLocationRegion(locationRegion.toLocationRegionDTO());
    }

}