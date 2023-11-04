package data;

import structure.Person;
import structure.Preferences;
import structure.SkiRecord;

import java.util.ArrayList;
import java.util.Dictionary;

public class AllData {
    public String pathPreferences;
    public String pathWykaz;
    public String pathZnizki;
    private ArrayList<Preferences> allPreferences;
    private ArrayList<SkiRecord> register;
    private Dictionary<Person.Group, Integer> discount;

    public AllData(String pathPreferences, String pathWykaz, String pathZnizki) {
        this.pathPreferences = pathPreferences;
        this.pathWykaz = pathWykaz;
        this.pathZnizki = pathZnizki;
    }
    public void readAllData(){
        Read readData = new Read();
        this.allPreferences = readData.readAllPreferences(pathPreferences);
        this.register = readData.readRegister(pathWykaz);
        this.discount = readData.readDiscount(pathZnizki);
    }

    @Override
    public String toString() {
        return "AllData{" +
                "\nallPreferences=" + allPreferences +
                ", \nregister=" + register +
                ", \ndiscount=" + discount +
                '}';
    }

    public ArrayList<Preferences> getAllPreferences() {
        return allPreferences;
    }

    public ArrayList<SkiRecord> getRegister() {
        return register;
    }

    public Dictionary<Person.Group, Integer> getDiscount() {
        return discount;
    }
}