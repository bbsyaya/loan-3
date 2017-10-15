package com.tkach.loan.model;

import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loan_request")
public class LoanRequest extends AbstractEntity {
    @Basic(optional = false)
    private BigDecimal amount;

    @Basic(optional = false)
    private LocalDate term;

    @Basic(optional = false)
    private LocalDate applicationDate;

    @JoinColumn(name = "message_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = {CascadeType.MERGE})
    private User user;

    public LoanRequest(User user, BigDecimal amount, LocalDate term, LocalDate applicationDate) {
        this.amount = amount;
        this.term = term;
        this.applicationDate = applicationDate;
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTerm() {
        return term;
    }

    public void setTerm(LocalDate term) {
        this.term = term;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
