package dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Product(
        String title,
        String description,
        BigDecimal price,
        Double discountPercentage,
        Double rating,
        Integer stock,
        String brand,
        String category,
        String thumbnail,
        List<String> images
) {}
