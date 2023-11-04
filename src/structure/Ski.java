package structure;

public record Ski(Type type, int length) {
    public enum Type {slalom, gigant, race, allmountain, carving}
}
