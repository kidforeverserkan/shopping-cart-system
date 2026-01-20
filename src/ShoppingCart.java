import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public void removeProduct(Product product) throws ProductNotFoundException {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (!products.remove(product)) {
            throw new ProductNotFoundException("Product not found in the cart: " + product.getName());
        }
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("(cart is empty)");
            return;
        }
        for (Product p : products) {
            System.out.println("- " + p);
        }
        System.out.printf("Total: %.2f%n", getTotalPrice());
    }
}

