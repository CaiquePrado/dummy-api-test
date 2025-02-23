package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("maidenName") String maidenName,
        @JsonProperty("age") Integer age,
        @JsonProperty("gender") String gender,
        @JsonProperty("email") String email,
        @JsonProperty("phone") String phone,
        @JsonProperty("username") String username,
        @JsonProperty("password") String password,
        @JsonProperty("birthDate") String birthDate
) {
}

