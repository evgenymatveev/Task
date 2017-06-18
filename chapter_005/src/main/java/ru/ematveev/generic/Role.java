package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public class Role extends Base {
    /**
     * Constructor the class.
     * @param id unic id for every the Base element.
     */
    public Role(String id) {
        super(id);
    }
    /**
     * Get the element.
     * @return id of the element.
     */
    @Override
    public String getId() {
        return super.getId();
    }
    /**
     * Write id of the element.
     * @param id id of the element.
     */
    @Override
    public void setId(String id) {
        super.setId(id);
    }
    /**
     * Redefinition the method equals.
     * @param o Object to compare.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    /**
     * Get the hashcode of the object.
     * @return int value of the hashcode.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
