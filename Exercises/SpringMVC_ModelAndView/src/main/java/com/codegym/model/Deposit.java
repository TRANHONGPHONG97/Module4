package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "deposit")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String created_at;
    private String created_by;
    private String deleted;
    private String updated_at;
    private String updated_by;
    private long customer_id;
    private String transaction_amount;

    public Deposit() {
    }

    public Deposit(long id, String created_at, String created_by, String deleted, String updated_at, String updated_by, long customer_id, String transaction_amount) {
        this.id = id;
        this.created_at = created_at;
        this.created_by = created_by;
        this.deleted = deleted;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.customer_id = customer_id;
        this.transaction_amount = transaction_amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", created_at='" + created_at + '\'' +
                ", created_by='" + created_by + '\'' +
                ", deleted='" + deleted + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", updated_by='" + updated_by + '\'' +
                ", customer_id=" + customer_id +
                ", transaction_amount='" + transaction_amount + '\'' +
                '}';
    }
}
