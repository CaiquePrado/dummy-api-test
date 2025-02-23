package factory;

import dto.Product;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.List;

public interface ProductFactory {

    Faker faker = new Faker();

    static Product validProductFactory() {
        return Product.builder()
                .title("Perfume Oil")
                .description("Mega Discount, Impression of A...")
                .price(BigDecimal.valueOf(13))
                .discountPercentage(8.4)
                .rating(4.26)
                .stock(65)
                .brand("Impression of Acqua Di Gio")
                .category("fragrances")
                .thumbnail("https://i.dummyjson.com/data/products/11/thumnail.jpg")
                .build();
    }


    static Product validUpdateProductFactory() {
        return Product.builder()
                .title("iPhone Galaxy +1")
                .description("Good smartphone")
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

    static Product idOneProductFactory() {
        return Product.builder()
                .title("Essence Mascara Lash Princess")
                .description("The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.")
                .price(BigDecimal.valueOf(9.99))
                .discountPercentage(7.17)
                .rating(4.94)
                .stock(5)
                .brand("Essence")
                .category("beauty")
                .thumbnail("https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png")
                .images(List.of("https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/1.png"))
                .build();
    }
}
