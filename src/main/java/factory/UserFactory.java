package factory;

import dto.User;
import net.datafaker.Faker;

public interface UserFactory {

    Faker faker = new Faker();

    static User createValidUserFactory() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .maidenName(faker.name().lastName())
                .age(faker.number().numberBetween(18, 80))
                .gender(faker.options().option("male", "female"))
                .email(faker.internet().emailAddress())
                .phone(faker.phoneNumber().phoneNumber())
                .username(faker.name().username())
                .password(faker.internet().password())
                .birthDate(faker.date().birthday(18, 30).toString())
                .build();
    }

    static User validUpdateUserFactory() {
        return User.builder()
                .firstName("John")
                .lastName("Smith")
                .age(20)
                .build();
    }
}

