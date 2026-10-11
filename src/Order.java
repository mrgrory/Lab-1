import java.util.List;

public class Order{
    private static long Id=1;
    private long id;
    private Customer customer;
    private List<Product> products;
    private OrderStatus status;
    private double totalPrice=0.0;

    public Order(Customer customer, List<Product> products, OrderStatus status) {
        if (customer==null) {
            throw new IllegalArgumentException("customer can not be null");
        }
        if (products==null) {
            throw new IllegalArgumentException("products can not be null");
        }
        if (status==null) {
            throw new IllegalArgumentException("status can not be null");
        }
        this.customer=customer;
        this.products=products;
        this.status=status;
        id=Id++;
        this.totalPrice=0.0;
        for(Product product:this.getProducts()) {
            totalPrice+=product.getPrice();
        }
    }

    public long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private Order() {}

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public void setCustomer(Customer customer) {
        if (customer==null) {
            throw new IllegalArgumentException("customer can not be null");
        }
        this.customer = customer;
    }

    public void setProducts(List<Product> products) {
        if (products==null) {
            throw new IllegalArgumentException("products can not be null");
        }
        this.products = products;
        for(Product product:this.getProducts()) {
            totalPrice+=product.getPrice();
        }
    }

    public void setStatus(OrderStatus status) {
        if (status==null) {
            throw new IllegalArgumentException("status can not be null");
        }
        this.status = status;
    }
}
