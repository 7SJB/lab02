import algorithms.BruteForce;
import data.*;
import structure.Preferences;
import structure.Ski;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        String preferences = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\preferences.txt";
        String wykaz = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\wykaz.txt";
        String znizki = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\znizki.txt";

        AllData data = new AllData(preferences,wykaz,znizki);
        data.readAllData();
        System.out.println(data);

        BruteForce bruteForce = new BruteForce();
        Map<Preferences, Ski> emptyDistribution = new HashMap<>();
        bruteForce.findSolution(data.getAllPreferences(), data.getRegister(), emptyDistribution);

        System.out.println(bruteForce.getBestValue());
        System.out.println(bruteForce.getBestDistribution());
    }

}
