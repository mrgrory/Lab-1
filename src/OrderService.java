import java.util.*;

public class OrderService implements OrderStorage, PriceCalculator, CustomerStatistics {
    private List<Order> orders=new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(long orderId) {
        for(int i=0;i<orders.size();i++) {
            if (orderId==orders.get(i).getId()) {
                orders.remove(i);
                break;
            }
        }
    }
    @Override
    public Order findOrderById(long orderId) {
        for(int i=0;i<orders.size();i++) {
            if (orderId==orders.get(i).getId()) {
                return orders.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Order> findOrdersByCustomer(long customerId) {
        List<Order> customerOrders=new ArrayList<>();
        for (Order order:orders) {
            if (order.getCustomer().getId()==customerId) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    @Override
    public List<Order> findOrdersByStatus(OrderStatus status) {
        List<Order> statusOrders=new ArrayList<>();
        for (Order order:orders) {
            if (order.getStatus()==status) {
                statusOrders.add(order);
            }
        }
        return statusOrders;
    }

    @Override
    public List<Order> findOrdersContainingProduct(long productId) {
        List<Order> productOrders=new ArrayList<>();
        for (Order order:orders) {
            for (Product product:order.getProducts()) {
                if (product.getId()==productId) {
                    productOrders.add(order);
                    break;
                }
            }
        }
        return productOrders;
    }

    @Override
    public Set<Customer> findCustomersWithOrders() {
        Set<Customer> customersWithOrders=new HashSet<>();
        for (Order order:orders) {
            customersWithOrders.add(order.getCustomer());
        }
        return customersWithOrders;
    }

    @Override
    public double calculateOrderTotal(long orderId) {
        Order order=(findOrderById(orderId));
        if (order==null)
            throw new IllegalArgumentException("Order not found");
        return order.getTotalPrice();
    }

    @Override
    public List<Order> sortOrdersByTotalPrice() {
        List<Order> sortedOrders = new ArrayList<>(orders);
        sortedOrders.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Double.compare(o1.getTotalPrice(), o2.getTotalPrice());
            }
        });
        return sortedOrders;
    }

    @Override
    public Map<OrderStatus, Long> countOrdersByStatus() {
        Map<OrderStatus, Long> statusCount = new HashMap<>();
        for (Order order:orders) {
            OrderStatus status=order.getStatus();
            if (statusCount.containsKey(status)) {
                statusCount.put(status,statusCount.get(status)+1);
            }
            else {
                statusCount.put(status,1L);
            }
        }
        return statusCount;
    }
}