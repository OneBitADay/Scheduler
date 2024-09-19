package runner.response;

public final class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

    public UserResponse(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.userId = builder.userId;
    }


    public static class Builder {

        private String firstName;
        private String lastName;
        private String email;
        private String userId;

        public static Builder newInstance()
        {
            return new Builder();
        }

        private Builder() {}

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserResponse build() {
            return new UserResponse(this);
        }
    }
}
