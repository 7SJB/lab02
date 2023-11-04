package structure;

import java.util.ArrayList;

public class Preferences {
    private ArrayList<Ski> list;
    private Person person;
    public Preferences(ArrayList<Ski> list, Person person){
        this.list = list;
        this.person = person;
    }

    public ArrayList<Ski> getList() {
        return list;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Preferences{" +
                "list=" + list +
                ", person=" + person +
                '}';
    }
}
