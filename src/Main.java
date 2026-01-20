import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Shopping Cart (File Actions) ===");

        ShoppingCart cart = new ShoppingCart();

        Path input = Path.of("cart-actions.txt");     // put next to your project when running
        Path output = Path.of("cart-actions.log");

        CartActionReader reader = new CartActionReader();
        CartActionParser parser = new CartActionParser();
        CartActionLogger logger = new CartActionLogger();

        try {
            List<String> lines = reader.readAllLines(input);

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                try {
                    CartTransaction action = parser.parseLine(line);

                    // Convert action -> domain object
                    Product product = new Product(action.getName(), action.getPrice());

                    if (action.getType() == ActionType.ADD) {
                        cart.addProduct(product);
                        logger.append(output, "OK: ADD " + product + " -> total=" + String.format("%.2f", cart.getTotalPrice()));
                    } else if (action.getType() == ActionType.REMOVE) {
                        cart.removeProduct(product);
                        logger.append(output, "OK: REMOVE " + product + " -> total=" + String.format("%.2f", cart.getTotalPrice()));
                    }

                } catch (IllegalArgumentException e) {
                    // Parser or Product validation failure
                    logger.append(output, "FAILED: " + line + " -> " + e.getMessage());
                } catch (ProductNotFoundException e) {
                    logger.append(output, "FAILED: " + line + " -> " + e.getMessage());
                }
            }

            System.out.println("Done. Final cart contents:");
            cart.listProducts();
            System.out.println("Log written to: " + output.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
