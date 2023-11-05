package algorithms;

import structure.Preferences;
import structure.Ski;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BruteForce {

    private int bestValue;
    private Map<Preferences, Ski> bestDistribution;


    public BruteForce() {
        this.bestValue = Integer.MAX_VALUE;
        this.bestDistribution = new HashMap<>();
    }

    public boolean checkRegister(Map<Ski, Integer> register) {
        for (Ski s : register.keySet()) {
            if (register.get(s) > 0) {
                return true;
            }
        }
        return false;
    }

    public void findSolution(ArrayList<Preferences> prefs, Map<Ski, Integer> register, Map<Preferences, Ski> currentDistribution) {
        if (!prefs.isEmpty()) {
            for (Preferences p : prefs) {

                if (checkRegister(register)) {
                    for (Ski s : register.keySet()) {

                        Map<Preferences, Ski> newDistribution = new HashMap<>(currentDistribution);

                        ArrayList<Preferences> newPrefs = new ArrayList<>(prefs);
                        newPrefs.remove(p);

                        if (register.get(s) > 0) {
                            Map<Ski, Integer> newRegister = new HashMap<>(register);
                            newRegister.replace(s, register.get(s) - 1);

                            newDistribution.put(p, s);
                            findSolution(newPrefs, newRegister, newDistribution);
                        }
                    }
                } else {
                    Map<Preferences, Ski> newDistribution = new HashMap<>(currentDistribution);

                    ArrayList<Preferences> newPrefs = new ArrayList<>(prefs);
                    newPrefs.remove(p);

                    newDistribution.put(p, null);
                    findSolution(newPrefs, register, newDistribution);
                }
            }
        } else {
            Criteria criteria = new Criteria(2, 2, 5, 10);
            int val = criteria.getValue(currentDistribution);

            if (val < this.bestValue) {
                this.bestValue = val;
                this.bestDistribution = new HashMap<>(currentDistribution);
            }
        }
    }

    public int getBestValue() {
        return bestValue;
    }

    public Map<Preferences, Ski> getBestDistribution() {
        return bestDistribution;
    }

    private String toStringBestDistribution(){
        StringBuilder formatted = new StringBuilder();
        for(Preferences p : bestDistribution.keySet()){
            formatted.append(p);
            formatted.append(" - przydzeielono - ");
            formatted.append(bestDistribution.get(p));
            formatted.append("\n");
        }

        return formatted.toString();
    }

    @Override
    public String toString() {
        return "BruteForce" +
                "\nbestValue=" + bestValue +
                "\nbestDistribution=\n" + toStringBestDistribution();
    }
}
