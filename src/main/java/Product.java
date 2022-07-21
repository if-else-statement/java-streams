import java.util.Map;

public class Product {

    private String name;
    private double price;
    private double discount;
    private Map<String, String> attributes;

    public Product(String name, double price, double discount, Map<String, String> attributes) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", attributes=" + attributes +
                '}';
    }
}
