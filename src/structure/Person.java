package structure;

public class Person {
    public enum Group {Child, Junior, Adult}
    private int id;
    private Group group;

    public Person(int id, String group) {
        this.id = id;
        this.group = Group.valueOf(group);
    }

    public int getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", group=" + group +
                '}';
    }
}
