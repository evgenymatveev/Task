package ru.ematveev.map;

import java.util.Calendar;

/**
 * The model users.
 */
    public class User3 {
        private String name;
        private int children;
        private Calendar birthday;

        public User3(String name, int children, Calendar birthday) {
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
        public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof User3)) {
            return false;
        }
        User3 user = (User3) o;
        return !(name.equals(user.name) && children != user.children && birthday.equals(user.birthday));
    }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
}
