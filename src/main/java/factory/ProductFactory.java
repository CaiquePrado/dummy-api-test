package factory;

import java.math.BigDecimal;

import dto.Product;

public interface ProductFactory {

    static Product validProductFactory(){
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

    static Product validUpdateProductFactory(){
        return Product.builder()
        .title("Perfume Oil")
        .description("Mega Discount, Impression of A...")
        .build();
    }

    static Product createProductWithTitleFactory() {
        return Product.builder()
        .title("Perfume Oil")
        .build();
    }

    static Product createProductWithDescriptionFactory() {
        return Product.builder()
        .description("Mega Discount, Impression of A...")
        .build();
    }

    static Product createProductWithPriceFactory() {
        return Product.builder()
        .price(BigDecimal.valueOf(13))
        .build();
    }

    static Product createProductWithDiscountPercentageFactory() {
        return Product.builder()
        .discountPercentage(8.4)
        .build();
    }

    static Product createProductWithRatingFactory() {
        return Product.builder()
        .rating(4.26)
        .build();
    }

    static Product createProductWithStockFactory() {
        return Product.builder()
        .stock(65)
        .build();
    }

    static Product createProductWithBrandFactory() {
        return Product.builder()
        .brand("Impression of Acqua Di Gio")
        .build();
    }

    static Product createProductWithCategoryFactory() {
        return Product.builder()
        .category("fragrances")
        .build();
    }

    static Product createProductWithThumbnailFactory() {
        return Product.builder()
        .thumbnail("https://i.dummyjson.com/data/products/11/thumnail.jpg")
        .build();
    }

}
