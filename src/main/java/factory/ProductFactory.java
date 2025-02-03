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

    public static Product createProductWithTitleFactory() {
        return Product.builder()
        .title("Perfume Oil")
        .build();
    }

    public static Product createProductWithDescriptionFactory() {
        return Product.builder()
        .description("Mega Discount, Impression of A...")
        .build();
    }

    public static Product createProductWithPriceFactory() {
        return Product.builder()
        .price(BigDecimal.valueOf(13))
        .build();
    }

    public static Product createProductWithDiscountPercentageFactory() {
        return Product.builder()
        .discountPercentage(8.4)
        .build();
    }

    public static Product createProductWithRatingFactory() {
        return Product.builder()
        .rating(4.26)
        .build();
    }

    public static Product createProductWithStockFactory() {
        return Product.builder()
        .stock(65)
        .build();
    }

    public static Product createProductWithBrandFactory() {
        return Product.builder()
        .brand("Impression of Acqua Di Gio")
        .build();
    }

    public static Product createProductWithCategoryFactory() {
        return Product.builder()
        .category("fragrances")
        .build();
    }

    public static Product createProductWithThumbnailFactory() {
        return Product.builder()
        .thumbnail("https://i.dummyjson.com/data/products/11/thumnail.jpg")
        .build();
    }

}
