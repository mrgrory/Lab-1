import java.util.Objects;

public class Customer
{
    private static long Id=1;
    private long id;
    private String name;
    private String email;

    public Customer(String name, String email) {
        if (email==null || email.isEmpty())
        {
            throw new IllegalArgumentException("email can not be null or empty");
        }
        if (name==null || name.isEmpty())
        {
            throw new IllegalArgumentException("name can not be null or empty");
        }
        this.email=email;
        this.name=name;
        id=Id++;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    private Customer() {}

    @Override
    public String toString() {
        return "\n\tCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
