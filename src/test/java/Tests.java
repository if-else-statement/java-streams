import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {

    private List<Product> products;

    private Exercises exercises;

    @BeforeAll
    public void initialize() {
        products = getProducts();
        exercises = new Exercises();
    }

    @Test
    void testNonIPhoneProducts() {
        List<Product> actual = exercises.nonIPhoneProducts(products);
        List<Product> expected = Arrays.asList(products.get(3), products.get(4));
        assertEquals(expected, actual);
    }

    @Test
    void testSixPointOneInchesScreenSizeProducts() {
        List<Product> actual = exercises.sixPointOneInchesScreenSizeProducts(products);
        List<Product> expected = Arrays.asList(products.get(1), products.get(2));
        assertEquals(expected, actual);
    }

    @Test
    void testSixPointOneInchesScreenSizeIPhoneAveragePriceExcludingDiscount() {
        double actual = exercises.sixPointOneInchesScreenSizeIPhoneAveragePriceExcludingDiscount(products);
        double expected = 685;
        assertEquals(expected, actual);
    }

    @Test
    void testSixPointOneInchesScreenSizeIPhoneAveragePriceIncludingDiscount() {
        double actual = exercises.sixPointOneInchesScreenSizeIPhoneAveragePriceIncludingDiscount(products);
        double expected = 679.45;
        assertEquals(expected, actual);
    }

    @Test
    void testProductWithMaxDiscountInDollars() {
        Product actual = exercises.productWithMaxDiscountInDollars(products);
        Product expected = products.get(4);
        assertEquals(expected, actual);
    }

    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Map<String, String> productAttributes1 = new HashMap<String, String>() {{
            put("colour", "black");
            put("screen size", "4.7 inches");
        }};
        products.add(new Product("IPhone 8 64GB Black", 280, 0.05, productAttributes1));

        Map<String, String> productAttributes2 = new HashMap<String, String>() {{
            put("colour", "red");
            put("screen size", "6.1 inches");
        }};
        products.add(new Product("IPhone XR 64GB Red", 370, 0.03, productAttributes2));

        Map<String, String> productAttributes3 = new HashMap<String, String>() {{
            put("colour", "green");
            put("screen size", "6.1 inches");
        }};
        products.add(new Product("IPhone 13 128GB Green", 1000, 0, productAttributes3));

        Map<String, String> productAttributes4 = new HashMap<String, String>() {{
            put("colour", "black");
            put("screen size", "6.7 inches");
        }};
        products.add(new Product("Google Pixel 6 Pro 128 GB", 800, 0, productAttributes4));

        Map<String, String> productAttributes5 = new HashMap<String, String>() {{
            put("colour", "white");
            put("screen size", "6.3 inches");
        }};
        products.add(new Product("Samsung Galaxy Note10 Plus 256GB", 410, 0.04, productAttributes5));

        return products;
    }
}
