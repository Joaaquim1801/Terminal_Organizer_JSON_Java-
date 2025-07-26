package main;

import com.google.gson.Gson;
import controller.taskManagement;
import model.Task;
import util.JsonHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static Gson gson = new Gson();
    public static String filePath = "src/jsonFile/task.json";
    public static taskManagement taskManagement = new taskManagement();

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean permission = true;

        Path path = Paths.get(filePath); // Paths create a path object, which encapsulate some information
        // about the provided path

        // Creating .json archive if it does not exist
        if (!Files.exists(path)){
            FileWriter writer = new FileWriter(filePath);
        }

        // Deserialize update the class Task list
        JsonHelper.Deserialize();
        while ( permission ){
            System.out.println("""
                    OPTIONS
                    ----------------------------
                    [ 1 ] - Add new task;
                    [ 2 ] - List all taks;
                    [ 3 ] - Edit task;
                    [ 4 ] - Mark as concluded;
                    [ 5 ] - Remove task.
                    ----------------------------
                    """);

            // User input options
            System.out.println("Which option you will choose?");
            int option = scanner.nextInt();
            scanner.nextLine();


            switch (option) {
                case 1:
                    //Creating the object

                    System.out.println("Task name:");
                    String taskName = scanner.nextLine();
                    System.out.println("Task description:");
                    String taskDescription = scanner.nextLine();
                    System.out.println("Task priority [ LOW, MEDIUM or HIGH ]:");
                    String taskPriorityString = scanner.nextLine();

                    // Converting String to enum
                    taskPriorityString.trim().toUpperCase();

                    Task.Priority taskPriorityEnum = Task.Priority.valueOf(taskPriorityString);

                    // Adding to .json
                    Task task = new Task(taskName,taskDescription, Task.Status.PENDING,taskPriorityEnum);
                    taskManagement.addNewTask(task);
                    JsonHelper.Serialize(taskManagement.getTasksList());
                    break;
                case 2:
                    taskManagement.printingList();
                    break;
                case 3:
                    try {
                        taskManagement.editAttributes();
                        // Serialize update the .json file
                        JsonHelper.Serialize(taskManagement.getTasksList());
                    } catch (IllegalAccessException e) {
                        System.out.println("IllegalArgumentException ERROR");
                    }
                    break;
                case 4:
                    taskManagement.markCompleted();
                    JsonHelper.Serialize(taskManagement.getTasksList());
                    break;
                case 5:
                    taskManagement.removeObject();
                    JsonHelper.Serialize(taskManagement.getTasksList());
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }

            // Exit question
            System.out.println("""
                    ----------------------------
                    Do you want to continue?
                    ----------------------------""");
            String answerExit = scanner.nextLine();
            if (answerExit.trim().toLowerCase().equals("no")){ permission = false; }

        }
        scanner.close();
    }
}
