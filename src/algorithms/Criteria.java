package algorithms;

import data.AllData;
import structure.Preferences;
import structure.Ski;

import java.util.Map;

public class Criteria {
    private final int lengthDiff;
    private final int typeDiff;
    private final int notAssigned;
    private final int skiCost;

    public Criteria(int lengthDiff, int typeDiff, int notAssigned, int skiCost) {
        this.lengthDiff = lengthDiff;
        this.typeDiff = typeDiff;
        this.notAssigned = notAssigned;
        this.skiCost = skiCost;
    }
    public int compareSkiLength(int l1, int l2){
        return (int) Math.pow(l1-l2, lengthDiff);
    }
    public int compareSkiType(Ski.Type t1, Ski.Type t2){
        return (int) Math.pow(t1.ordinal() - t2.ordinal(), typeDiff);
    }
    public int compareSkis(Ski s1, Ski s2){
        int lengthVal = compareSkiLength(s1.length(), s2.length());
        int typeVal = compareSkiType(s1.type(), s2.type());
        return lengthVal + typeVal;
    }
    public int getValue(Map<Preferences, Ski> distribution){
        int val = 0;
        for ( Map.Entry<Preferences, Ski> entry : distribution.entrySet() ) {
            Preferences prefs = entry.getKey();
            Ski skiAssigned = entry.getValue();

            if(skiAssigned == null){
                val += notAssigned;
            }else {
                int skiValue = Integer.MAX_VALUE;
                for (Ski skiPreferred : prefs.getList()) {
                    int temp = compareSkis(skiPreferred, skiAssigned);
                    if (temp < skiValue) {
                        skiValue = temp;
                    }
                }
                val += skiValue;

                val += ((AllData.discount.get(prefs.getPerson().getGroup()))/100)*skiCost;
            }
        }
        return val;
    }
}
