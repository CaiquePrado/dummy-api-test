package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Product(
        @JsonProperty("title") String title,
        @JsonProperty("description") String description,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("discountPercentage") Double discountPercentage,
        @JsonProperty("rating") Double rating,
        @JsonProperty("stock") Integer stock,
        @JsonProperty("brand") String brand,
        @JsonProperty("category") String category,
        @JsonProperty("thumbnail") String thumbnail,
        @JsonProperty("images") List<String> images
) {
}

