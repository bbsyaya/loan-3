package com.tkach.loan.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by tkach on 15-Oct-17.
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity{

    @Basic(optional = false)
    private String firstName;

    @Basic(optional = false)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
