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
    public void ReadAllData(){
        Read readData = new Read();
        allPreferences = readData.readAllPreferences(pathPreferences);
        register = readData.readRegister(pathWykaz);

    }
}