package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String created_at;
    private String created_by;
    private String deleted;
    private String updated_at;
    private String updated_by;
    private String fees;
    private String fees_amount;
    private String transaction_amount;
    private String transfer_amount;
    private int recipient_id;
    private int sender_id;

    public Transfer() {
    }

    public Transfer(long id, String created_at, String created_by, String deleted, String updated_at, String updated_by, String fees, String fees_amount, String transaction_amount, String transfer_amount, int recipient_id, int sender_id) {
        this.id = id;
        this.created_at = created_at;
        this.created_by = created_by;
        this.deleted = deleted;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.fees = fees;
        this.fees_amount = fees_amount;
        this.transaction_amount = transaction_amount;
        this.transfer_amount = transfer_amount;
        this.recipient_id = recipient_id;
        this.sender_id = sender_id;
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

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getFees_amount() {
        return fees_amount;
    }

    public void setFees_amount(String fees_amount) {
        this.fees_amount = fees_amount;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(String transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public int getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(int recipient_id) {
        this.recipient_id = recipient_id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", created_at='" + created_at + '\'' +
                ", created_by='" + created_by + '\'' +
                ", deleted='" + deleted + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", updated_by='" + updated_by + '\'' +
                ", fees='" + fees + '\'' +
                ", fees_amount='" + fees_amount + '\'' +
                ", transaction_amount='" + transaction_amount + '\'' +
                ", transfer_amount='" + transfer_amount + '\'' +
                ", recipient_id=" + recipient_id +
                ", sender_id=" + sender_id +
                '}';
    }
}
