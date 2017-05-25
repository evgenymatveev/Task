package ru.ematveev.Bank;

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
}
