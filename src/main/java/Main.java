import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> products = getProducts();

        // Example 1. List of all iPhones
        List<Product> ex1 = products.stream().filter(product -> product.getName().toLowerCase().contains("iphone")).collect(Collectors.toList());
        //ex1.forEach(System.out::println);

        // Example 2. List of all colours of iPhones
        List<String> ex2 = products.stream()
                .filter(product -> product.getName().toLowerCase().contains("iphone"))
                .map(iPhone -> iPhone.getAttributes().get("colour"))
                .distinct()
                .collect(Collectors.toList());
        //ex2.forEach(System.out::println);

        // Example 3. Average price of iPhone
        Double ex3 = products.stream()
                .filter(product -> product.getName().toLowerCase().contains("iphone"))
                .mapToDouble(iPhone -> iPhone.getPrice() - (iPhone.getPrice()) * iPhone.getDiscount())
                .average()
                .orElse(-1);
        //System.out.println(ex3);

        // Example 4. Sort by price
        List<Product> ex4 = products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        //ex4.forEach(System.out::println);

        // Example 5. Max/Min price
        Product ex5 = products.stream().min(Comparator.comparing(Product::getPrice)).get();
        //System.out.println(ex5.toString());

        //Example 6. Group by colour
        Map<String, List<String>> ex6 = products.stream()
                .collect(
                        Collectors.groupingBy(p -> p.getAttributes().getOrDefault("colour", "No colour"),
                                Collectors.mapping(Product::getName, Collectors.toList()))
                );
        //ex6.forEach((k, v) -> System.out.println(k + ": " + v));

        products.parallelStream().forEach(p -> System.out.println(p.getName() + " " + Thread.currentThread().getName()));
        System.out.println(("------"));
        products.stream().forEach(p -> System.out.println(p.getName() + " " + Thread.currentThread().getName()));
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
        products.add(new Product("Samsung Galaxy Note10 Plus 256GB", 410, 0.07, productAttributes5));

        return products;
    }
}
