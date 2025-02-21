package factory;

import dto.Category;

import java.util.List;

public interface CategoryFactory {

    static List<Category> validCategoryResponse() {
        return List.of(
                Category.builder().category("beauty").build(),
                Category.builder().category("fragrances").build(),
                Category.builder().category("furniture").build(),
                Category.builder().category("groceries").build(),
                Category.builder().category("home-decoration").build(),
                Category.builder().category("kitchen-accessories").build(),
                Category.builder().category("laptops").build(),
                Category.builder().category("mens-shirts").build(),
                Category.builder().category("mens-shoes").build(),
                Category.builder().category("mens-watches").build(),
                Category.builder().category("mobile-accessories").build(),
                Category.builder().category("motorcycle").build(),
                Category.builder().category("skin-care").build(),
                Category.builder().category("smartphones").build(),
                Category.builder().category("sports-accessories").build(),
                Category.builder().category("sunglasses").build(),
                Category.builder().category("tablets").build(),
                Category.builder().category("tops").build(),
                Category.builder().category("vehicle").build(),
                Category.builder().category("womens-bags").build(),
                Category.builder().category("womens-dresses").build(),
                Category.builder().category("womens-jewellery").build(),
                Category.builder().category("womens-shoes").build(),
                Category.builder().category("womens-watches").build()
        );
    }
}
