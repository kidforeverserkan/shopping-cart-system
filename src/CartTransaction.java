public class CartTransaction {
    private final ActionType type;
    private final String name;
    private final double price;

    public CartTransaction(ActionType type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public ActionType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
