import java.util.*;
import java.io.*;

public class todo{
    public static void main(String[] args){
        runTime();
    }

    private static ArrayList<String> tasks = new ArrayList<String>();
    private static boolean running = true;
    private static String SAVEFILENAME = "list.txt";

    private static String optionMenu(){
        Scanner option = new Scanner(System.in);
        System.out.println("To Do List");
        System.out.println("Press the corresponding key for the options below.");
        System.out.println("1. View Tasks");
        System.out.println("2. Add Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Quit");
        return option.nextLine();
    }


    private static void viewTasks(){
        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("---------------------------");
    }

    private static void addTask(){
        Scanner taskToAdd = new Scanner(System.in);
        System.out.println("What task would you like to add? ");
        tasks.add(taskToAdd.nextLine());
    }

    private static void deleteTask(){
        Scanner taskToDelete = new Scanner(System.in);
        System.out.println("What task would you like to remove? ");
        tasks.remove(taskToDelete.nextLine());

    }

    private static void quit(){
        save();
        running = false;
    }

    private static void save(){
        try {
            FileWriter writer = new FileWriter(SAVEFILENAME);
            for(int i = 0; i < tasks.size(); i++){
                writer.write(tasks.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void load(){
        tasks.clear();
        try {
            File file = new File(SAVEFILENAME);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String item = reader.nextLine();
                tasks.add(item);
        }} catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        
        
    }

    private static void selector(String optionSelected){
        switch(optionSelected){
            case("1") -> viewTasks();
            case("2") -> addTask();
            case("3") -> deleteTask();
            case("4") -> quit();
        }
    }

    private static void runTime(){
        running = true;
        load();
        while(running){
            String option = optionMenu();
            selector(option);
        }
    }


}