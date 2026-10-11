import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Customer c1=new Customer("Viktor","Viktor@gmail");
        Customer c2=new Customer("Boghdan","Boghdan@gmail");
        Customer c3=new Customer("Nastya","Nastya@gmail");
        Customer c4=new Customer("Katya","Katua@gmail");
        System.out.println(c1+" "+c2+" "+c3+" "+c4);

        Product p=new Product("INVINCIBLE",ProductCategory.BOOKS,500.05);
        Product p1=new Product("Sweater",ProductCategory.CLOTHING,75.99);
        Product p2=new Product("Microwave",ProductCategory.ELECTRONICS,999.99);
        Product p3=new Product("bed",ProductCategory.HOME,100.10);
        Product p4=new Product("Hrechka",ProductCategory.OTHER,67.0);
        System.out.println(p+" "+p1+" "+p2+" "+p3);

        List<Product> products1=new ArrayList<>();
        products1.add(p);
        products1.add(p1);
        products1.add(p2);
        products1.add(p3);
        products1.add(p4);

        List<Product> products2=new ArrayList<>();
        products2.add(p);
        products2.add(p1);
        products2.add(p4);

        List<Product> products3=new ArrayList<>();
        products3.add(p4);
        products3.add(p4);
        products3.add(p4);

        List<Product> products4=new ArrayList<>();
        products4.add(p3);

        Order o=new Order(c1,products1,OrderStatus.SHIPPED);
        Order o1=new Order(c1,products1,OrderStatus.CANCELLED);
        Order o2=new Order(c2,products2,OrderStatus.NEW);
        Order o3=new Order(c3,products3,OrderStatus.DELIVERED);
        Order o4=new Order(c4,products4,OrderStatus.PROCESSING);

        OrderService program=new OrderService();

        program.addOrder(o);
        program.addOrder(o1);
        program.addOrder(o2);
        program.addOrder(o3);
        program.addOrder(o4);

        Order searchOrder=program.findOrderById(o1.getId());
        System.out.println(searchOrder!=null ? "Order found: "+searchOrder: "Order with this id not found");

        System.out.println("\nLooking for orders of the customer with id=3");
        for(Order order:program.findOrdersByCustomer(c3.getId()))
            System.out.println(order);

        System.out.println("\nLooking for orders with status=DELIVERED");
        for(Order order:program.findOrdersByStatus(OrderStatus.DELIVERED))
            System.out.println(order);

        System.out.println("\nLooking for orders with product=p");
        for(Order order:program.findOrdersContainingProduct(p.getId()))
            System.out.println(order);

        System.out.println("\nLooking for total price of the first order");
        System.out.println(program.calculateOrderTotal(o.getId()));

        System.out.println("\nLooking for customers with orders");
        Set<Customer> customersWithOrders=program.findCustomersWithOrders();
        for(Customer customer:customersWithOrders)
            System.out.println(customer);

        System.out.println("\nSorting orders by total price");
        List<Order> sorted=program.sortOrdersByTotalPrice();
        for(Order order:sorted)
            System.out.println("Price="+ order.getTotalPrice() +" "+ order);

        System.out.println("\nCount order by status");
        Map<OrderStatus,Long> map=program.countOrdersByStatus();
        map.forEach((status,count)->System.out.println("Status="+status+": count="+count));

        System.out.println("\nRemoving order");
        program.removeOrder(o1.getId());
        System.out.println(program.findOrderById(o1.getId()) + "null means order was not found");
    }
}
