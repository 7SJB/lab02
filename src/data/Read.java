package data;

import structure.Person;
import structure.Preferences;
import structure.Ski;
import structure.Person.Group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Read {
    public ArrayList<Preferences> readAllPreferences(String path) {
        ArrayList<Preferences> allPref = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",");
                Person p = new Person(Integer.parseInt(data[0]), data[1]);

                ArrayList<Ski> skis = new ArrayList<>();
                for (String ski : data[2].split(";")){
                    String[] components = ski.split(":");
                    skis.add(new Ski(Ski.Type.valueOf(components[0]), Integer.parseInt(components[1])));
                }

                allPref.add(new Preferences(skis, p));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found.");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return allPref;
    }

    public Map<Ski, Integer> readRegister(String path) {
        Map<Ski, Integer> register = new HashMap<>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",");
                int q = Integer.parseInt(data[0]);
                String[] components = data[1].split(":");
                Ski s = new Ski(Ski.Type.valueOf(components[0]), Integer.parseInt(components[1]));

                register.put(s, q);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return register;
    }

    public Map<Person.Group, Integer> readDiscount(String path){
        Map<Person.Group, Integer> discount = new HashMap<>();
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                discount.put(Group.valueOf(data[0]), Integer.valueOf(data[1]));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found.");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return discount;
    }

}
