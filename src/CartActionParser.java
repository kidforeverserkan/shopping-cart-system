public class CartActionParser {

    // Expected format: TYPE;NAME;PRICE
    public CartTransaction parseLine(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Line cannot be null");
        }

        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Line cannot be empty");
        }

        String[] parts = trimmed.split(";");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid format. Expected: TYPE;NAME;PRICE. Got: " + trimmed);
        }

        ActionType type;
        try {
            type = ActionType.valueOf(parts[0].trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid action type: " + parts[0]);
        }

        String name = parts[1].trim();

        double price;
        try {
            price = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price: " + parts[2]);
        }

        return new CartTransaction(type, name, price);
    }
}
