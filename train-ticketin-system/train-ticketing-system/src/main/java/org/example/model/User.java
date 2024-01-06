package org.example.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;

    private User() {}

    public static UserBuilder newBuilder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;

        public UserBuilder() {}

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            User user = new User();
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.email = this.email;
            return user;
        }
    }

    // Getters and setters for User class fields...
}
