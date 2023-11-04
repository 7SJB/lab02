package structure;

public class Ski {
    public enum Type {slalom, gigant, race, allmountain, carving}

    private Type type;
    private int length;

    public Ski(String type, int length) {
        this.type = Type.valueOf(type);
        this.length = length;
    }

    public Type getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Ski{" +
                "type=" + type +
                ", length=" + length +
                '}';
    }
}
