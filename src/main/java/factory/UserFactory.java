package factory;

import dto.User;

public interface UserFactory {


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
}

