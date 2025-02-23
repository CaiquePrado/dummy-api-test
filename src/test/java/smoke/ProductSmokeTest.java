package smoke;

import base.BaseTest;
import dto.Product;
import factory.ProductFactory;
import org.testng.annotations.Test;

import static factory.ProductFactory.validUpdateProductFactory;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.ApplicationConstants.VALID_ID;

public class ProductSmokeTest extends BaseTest {

    @Test(description = "CT003.001")
    public void shouldCreateProductTest() {
        var expectedProduct = productClient
                .createValidProduct()
                .statusCode(SC_CREATED)
                .extract()
                .as(Product.class);

        assertThat(expectedProduct, is(ProductFactory.validProductFactory()));
    }

    @Test(description = "CT004.001")
    public void shouldDeleteProductTest() {
        productClient
                .deleteProductById(VALID_ID)
                .statusCode(SC_OK)
                .body("isDeleted", equalTo(true))
                .body("deletedOn", notNullValue());
    }

    @Test(description = "CT004.001")
    public void shouldListProductsTest() {
        productClient
                .listAllProducts()
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }

    @Test(description = "CT006.002")
    public void shouldListProductByIdTest() {
        var expectedProduct = productClient
                .listProductById(VALID_ID)
                .statusCode(SC_OK)
                .extract()
                .as(Product.class);

        assertThat(expectedProduct, is(ProductFactory.idOneProductFactory()));
    }

    @Test(description = "CT006.002")
    public void updateValidProductTest() {
        var expectedProduct = productClient
                .updateProductById()
                .statusCode(SC_OK)
                .extract()
                .as(Product.class);

        assertThat(expectedProduct.title(), is(validUpdateProductFactory().title()));
        assertThat(expectedProduct.description(), is(validUpdateProductFactory().description()));
    }
}
