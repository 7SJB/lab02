import structure.Person;
import structure.Preferences;
import structure.Ski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Person p1 = new Person(1, "C");
        Person p2 = new Person(2, "J");
        Person p3 = new Person(1, "A");

        Ski s1 = new Ski("slalom", 150);
        Ski s2 = new Ski("gigant", 170);
        Ski s3 = new Ski("race", 155);
        Ski s4 = new Ski("allmountain", 160);
        Ski s5 = new Ski("carving", 130);

        Preferences pref1 = new Preferences(new ArrayList<Ski>(Arrays.asList(s1, s2)), p1);
        Preferences pref2 = new Preferences(new ArrayList<Ski>(List.of(s3)), p2);
        Preferences pref3 = new Preferences(new ArrayList<Ski>(Arrays.asList(s4, s5)), p3);

        System.out.println(pref1);
        System.out.println(pref2);
        System.out.println(pref3);
    }
}
