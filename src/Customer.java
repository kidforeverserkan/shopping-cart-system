public class Customer {

    private final String name;
    private final int id;

    public Customer(String name, int id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive");
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}

