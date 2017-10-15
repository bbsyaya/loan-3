package com.tkach.loan.model;

import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "loan_request")
public class LoanRequest extends AbstractEntity {
    @Basic(optional = false)
    private BigDecimal amount;

    @Basic(optional = false)
    private LocalDate term;

    @Basic(optional = false)
    private LocalDate applicationDate;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = {CascadeType.MERGE})
    private User user;

    public LoanRequest(User user, BigDecimal amount, LocalDate term, LocalDate applicationDate) {
        this.amount = amount;
        this.term = term;
        this.applicationDate = applicationDate;
        this.user = user;
    }

    public LoanRequest() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequest that = (LoanRequest) o;
        //Given that for some reason hibernate (or h2) returns BigDecimal with different scale (.00 vs .0 in Java)
        //we compare amounts with compareTo
        return amount.compareTo(that.amount) == 0 &&
                Objects.equals(term, that.term) &&
                Objects.equals(applicationDate, that.applicationDate) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, term, applicationDate, user);
    }
}
