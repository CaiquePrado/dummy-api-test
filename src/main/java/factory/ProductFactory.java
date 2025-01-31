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
}
