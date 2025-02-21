package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
        Long id,
        String firstName,
        String lastName,
        String maidenName,
        Integer age,
        String gender,
        String email,
        String phone,
        String username,
        String password,
        String birthDate
) {
}

