import java.util.*;

public class students {
	public static void main(String[] args) {
        
    }

    private String name;
    private String ID;
    private ArrayList<ArrayList<String>> grades;

    public students(String name, String ID){
        this.name = name;
        this.ID = ID;
        this.grades = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return ID;
    }

    public ArrayList<ArrayList<String>> getGrades(){
        return grades;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setId(String newID){
        this.ID = newID;
    }

    public void setGrades(String subject, String grade){
        for (int i = 0; i < grades.size(); i++){
            if (grades.get(i).get(0) == subject){
                grades.get(i).set(1, grade);
            }
        }
        
    }

}
