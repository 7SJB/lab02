package structure;

public class SkiRecord {
    private int quantity;
    private Ski ski;

    public SkiRecord(int quantity, Ski ski) {
        this.quantity = quantity;
        this.ski = ski;
    }

    public int getQuantity() {
        return quantity;
    }

    public Ski getSki() {
        return ski;
    }
}
