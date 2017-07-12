package ru.ematveev.map;


import java.util.Calendar;

/**
 * The model users.
 */
public class User2 {
    private String name;
    private int children;
    private Calendar birthday;

    public User2(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getName().hashCode();
            result = prime * result + getChildren();
            result = prime * result + getBirthday().hashCode();
            return result;
    }
}