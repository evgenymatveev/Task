package ru.ematveev.generic;

import java.util.Objects;

/**
 * @author Matveev Evgeny.
 */
public abstract class Base {
    private String id;

    /**
     * Constructor the class.
     * @param id unic id for every the Base element.
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Get the element.
     * @return id of the element.
     */
    public String getId() {
        return id;
    }

    /**
     * Write id of the element.
     * @param id id of the element.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Redefinition the method equals.
     * @param o Object to compare.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return Objects.equals(id, base.id);
    }

    /**
     * Get the hashcode of the object.
     * @return int value of the hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
