package ru.ematveev;

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
        return "User{" + "name='" + name + '\''  + ',' + "age='" + age + '\'' + '}';
    }
    @Override
    public int compareTo(Users o) {
        return Integer.compare(this.getAge(), o.getAge());
    }


}
