import algorithms.BruteForce;
import data.AllData;
import structure.Preferences;
import structure.Ski;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Podaj sciezke do pliku preferences.txt");
        String preferences = scanner.nextLine();

        System.out.println("Podaj sciezke do pliku wykaz.txt");
        String wykaz = scanner.nextLine();

        System.out.println("Podaj sciezke do pliku znizki.txt");
        String znizki = scanner.nextLine();

        /*
        String preferences = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\preferences.txt";
        String znizki = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\znizki.txt";
        String wykaz = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\wykaz.txt";
        */

        AllData data = new AllData(preferences, wykaz, znizki);
        data.readAllData();

        BruteForce bruteForce = new BruteForce();
        Map<Preferences, Ski> emptyDistribution = new HashMap<>();
        bruteForce.findSolution(data.getAllPreferences(), data.getRegister(), emptyDistribution);

        System.out.println("Najlepsze przydzielenie nart");
        System.out.println(bruteForce);
    }

}
