import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solutions {

    // Before scrolling down, try your best to do the exercises yourself



    // Exercises are very similar to what we have covered in the video



    // I know, you can solve them without looking here!



    // Show your power and try to do it yourself!



    // I believe in you, my little coder!!!!

















    public List<Product> nonIPhoneProducts(List<Product> products) {
        return products.stream().filter(p -> !p.getName().toLowerCase().contains("iphone")).collect(Collectors.toList());
    }

    public List<Product> sixPointOneInchesScreenSizeProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getAttributes().get("screen size").equals("6.1 inches"))
                .collect(Collectors.toList());
    }

    public double sixPointOneInchesScreenSizeIPhoneAveragePriceExcludingDiscount(List<Product> products) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains("iphone"))
                .filter(iPhone -> iPhone.getAttributes().get("screen size").equals("6.1 inches"))
                .mapToDouble(iphone -> iphone.getPrice()).average().orElse(-1);
    }

    public double sixPointOneInchesScreenSizeIPhoneAveragePriceIncludingDiscount(List<Product> products) {
        return products.stream()
                .filter(p -> p.getName().contains("IPhone"))
                .filter(iPhone -> iPhone.getAttributes().get("screen size").equals("6.1 inches"))
                .mapToDouble(iphone -> iphone.getPrice() - (iphone.getPrice() * iphone.getDiscount())).average().orElse(-1);
    }

    public Product productWithMaxDiscountInDollars(List<Product> products) {
        return products.stream().max(Comparator.comparing(p -> p.getPrice() * p.getDiscount())).get();
    }
}
