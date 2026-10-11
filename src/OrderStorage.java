import java.util.List;
import java.util.Map;

public interface OrderStorage {
    void addOrder(Order order);
    void removeOrder(long orderId);
    Order findOrderById(long orderId);
    List<Order> findOrdersByCustomer(long customerId);
    List<Order> findOrdersByStatus(OrderStatus status);
    List<Order> findOrdersContainingProduct(long productId);
    Map<OrderStatus, Long> countOrdersByStatus();
}
