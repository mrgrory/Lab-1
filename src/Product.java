public class Product {
    private static long Id=1;
    private long id;
    private String name;
    private ProductCategory category;
    private double price;

    public Product(String name, ProductCategory category, double price) {
        if (name==null || name.isEmpty())
        {
            throw new IllegalArgumentException("name can not be null or empty");
        }
        if (category==null) {
            throw new IllegalArgumentException("category can not be null");
        }
        if (price<0) {
            throw new IllegalArgumentException("Price can not be negative");
        }
        id=Id++;
        this.name=name;
        this.category=category;
        this.price=price;
    }

    private Product() {}

    public double getPrice() {
        return price;
    }
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n\t\tProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
