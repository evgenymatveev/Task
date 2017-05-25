package ru.ematveev;

import java.util.Objects;

/**
 * Model Users.
 */
public class Users implements Comparable<Users> {
    private final String name;
    private final int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "User{" + "name='" + name + '\''
                + ',' + "age='" + age + '\'' + '}';
    }
    @Override
    public int compareTo(Users o) {
        return Integer.compare(this.getAge(), o.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Users users = (Users) o;
        return age == users.age
                && Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
