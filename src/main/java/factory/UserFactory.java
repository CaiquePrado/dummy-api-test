package factory;

import dto.User;
import net.datafaker.Faker;

public interface UserFactory {

    Faker faker = new Faker();

    static User createValidUserFactory() {
        return User.builder()
                .firstName("Emily")
                .lastName("Johnson")
                .maidenName("Smith")
                .age(28)
                .gender("female")
                .email("emily.johnson@x.dummyjson.com")
                .phone("+81 965-431-3024")
                .username("emilys")
                .password("emilyspass")
                .birthDate("1996-05-30")
                .build();
    }


    static User validUpdateUserFactory() {
        return User.builder()
                .firstName("John")
                .lastName("Smith")
                .age(20)
                .build();
    }

    static User idOneUserFactory() {
        return User.builder()
                .firstName("Emily")
                .lastName("Johnson")
                .maidenName("Smith")
                .age(28)
                .gender("female")
                .email("emily.johnson@x.dummyjson.com")
                .phone("+81 965-431-3024")
                .username("emilys")
                .password("emilyspass")
                .birthDate("1996-5-30")
                .build();
    }

    static User createUserWithFirstName() {
        return User.builder()
                .firstName(faker.name().firstName())
                .build();
    }

    static User createUserWithLastName() {
        return User.builder()
                .lastName(faker.name().lastName())
                .build();
    }

    static User createUserWithMaidenName() {
        return User.builder()
                .maidenName(faker.name().lastName())
                .build();
    }

    static User createUserWithAge() {
        return User.builder()
                .age(faker.number().numberBetween(18, 100))
                .build();
    }

    static User createUserWithGender() {
        return User.builder()
                .gender(faker.options().option("male", "female"))
                .build();
    }

    static User createUserWithEmail() {
        return User.builder()
                .email(faker.internet().emailAddress())
                .build();
    }

    static User createUserWithPhone() {
        return User.builder()
                .phone(faker.phoneNumber().phoneNumber())
                .build();
    }

    static User createUserWithUsername() {
        return User.builder()
                .username(faker.name().username())
                .build();
    }

    static User createUserWithPassword() {
        return User.builder()
                .password(faker.internet().password())
                .build();
    }

    static User createUserWithBirthDate() {
        return User.builder()
                .birthDate(faker.date().birthday(18, 100).toString())
                .build();
    }
}

