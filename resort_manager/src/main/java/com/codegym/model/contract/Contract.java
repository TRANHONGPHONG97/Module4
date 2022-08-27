package com.codegym.model.contract;

import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.model.customer.Customer;

import javax.persistence.*;

@Entity(name="contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", columnDefinition = "INT")
    private int contractId;

    @Column(name = "contract_start_date", columnDefinition = "DATE")
    private String startDate;

    @Column(name = "contract_end_date", columnDefinition = "DATE")
    private String endDate;

    @Column(name = "status_delete", columnDefinition = "BIT(1)")
    private Integer statusDelete=0;

    @Column(name = "contract_deposit", columnDefinition = "DOUBLE")
    private String deposit;


    @ManyToOne
    @JoinColumn(name = "employee_id", columnDefinition = "INT", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", columnDefinition = "VARCHAR(45)", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id", columnDefinition = "INT", referencedColumnName = "id")
    private Facility facility;



    public Contract() {
    }

    public Contract(int contractId,
                    String startDate,
                    String endDate,
                    Integer statusDelete,
                    String deposit,
                    Employee employee,
                    Customer customer,
                    Facility facility) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statusDelete = statusDelete;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;

    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
