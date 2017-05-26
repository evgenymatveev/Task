package ru.ematveev.Bank;

import java.util.Objects;

/**
 * Class accounts of users.
 */
public class Account {
    private int value;
    private int requisites;

    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites=" + requisites
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return value == account.value
                && requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }
}
