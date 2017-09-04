package org.nutmegsoccer.nutmeg.player;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public class PlayerSearchCriteria {

    private final String firstName;

    private final String lastName;

    private final String gender;

    private final LocalDate birthdayStartsWith;

    private final LocalDate birthdayEndsWith;

    private final Pageable pageable;

    private PlayerSearchCriteria(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        gender = builder.gender;
        birthdayStartsWith = builder.birthdayStartsWith;
        birthdayEndsWith = builder.birthdayEndsWith;
        pageable = builder.pageable;
    }
    public static Builder newBuilder() {
        return new Builder();
    }

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Optional<String> getGender() {
        return Optional.ofNullable(gender);
    }

    public Optional<LocalDate> getBirthdayStartsWith() {
        return Optional.ofNullable(birthdayStartsWith);
    }

    public Optional<LocalDate> getBirthdayEndsWith() {
        return Optional.ofNullable(birthdayEndsWith);
    }

    public Pageable getPageable() {
        return pageable;
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String gender;
        private LocalDate birthdayStartsWith;
        private LocalDate birthdayEndsWith;
        private Pageable pageable;

        private Builder() {
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withGender(String val) {
            gender = val;
            return this;
        }

        public Builder withBirthdayStartsWith(LocalDate val) {
            birthdayStartsWith = val;
            return this;
        }

        public Builder withBirthdayEndsWith(LocalDate val) {
            birthdayEndsWith = val;
            return this;
        }

        public Builder withPageable(Pageable val) {
            pageable = val;
            return this;
        }

        public PlayerSearchCriteria build() {
            return new PlayerSearchCriteria(this);
        }
    }
}