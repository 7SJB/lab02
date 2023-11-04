import data.*;

public class Main {

    public static void main(String[] args){
        String p = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\preferences.txt";
        String w = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\wykaz.txt";
        String z = "C:\\Users\\Ja\\IdeaProjects\\lab02\\src\\znizki.txt";

        AllData data = new AllData(p,w,z);
        data.readAllData();
        System.out.println(data);
    }

}
