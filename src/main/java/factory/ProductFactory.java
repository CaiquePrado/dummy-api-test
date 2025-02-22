package factory;

import dto.Product;
import net.datafaker.Faker;

import java.math.BigDecimal;

public interface ProductFactory {

    Faker faker = new Faker();

    static Product validProductFactory() {
        return Product.builder()
                .title(faker.commerce().productName())
                .description(faker.commerce().material() + " - " + faker.commerce().promotionCode())
                .price(BigDecimal.valueOf(Double.parseDouble(faker.commerce().price())))
                .discountPercentage(faker.number().randomDouble(2, 5, 20))
                .rating(faker.number().randomDouble(2, 3, 5))
                .stock(faker.number().numberBetween(1, 100))
                .brand(faker.company().name())
                .category(faker.commerce().department())
                .thumbnail(faker.internet().image())
                .build();
    }

    static Product validUpdateProductFactory() {
        return Product.builder()
                .title(faker.commerce().productName())
                .description(faker.lorem().sentence())
                .build();
    }

    static Product createProductWithTitleFactory() {
        return Product.builder()
                .title(faker.commerce().productName())
                .build();
    }

    static Product createProductWithDescriptionFactory() {
        return Product.builder()
                .description(faker.lorem().sentence())
                .build();
    }

    static Product createProductWithPriceFactory() {
        return Product.builder()
                .price(BigDecimal.valueOf(Double.parseDouble(faker.commerce().price())))
                .build();
    }

    static Product createProductWithDiscountPercentageFactory() {
        return Product.builder()
                .discountPercentage(faker.number().randomDouble(2, 5, 20))
                .build();
    }

    static Product createProductWithRatingFactory() {
        return Product.builder()
                .rating(faker.number().randomDouble(2, 1, 5))
                .build();
    }

    static Product createProductWithStockFactory() {
        return Product.builder()
                .stock(faker.number().numberBetween(1, 100))
                .build();
    }

    static Product createProductWithBrandFactory() {
        return Product.builder()
                .brand(faker.company().name())
                .build();
    }

    static Product createProductWithCategoryFactory() {
        return Product.builder()
                .category(faker.commerce().department())
                .build();
    }

    static Product createProductWithThumbnailFactory() {
        return Product.builder()
                .thumbnail(faker.internet().image())
                .build();
    }
}
