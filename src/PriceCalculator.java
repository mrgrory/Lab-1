import java.util.List;

public interface PriceCalculator {
    double calculateOrderTotal(long orderId);
    List<Order> sortOrdersByTotalPrice();
}

