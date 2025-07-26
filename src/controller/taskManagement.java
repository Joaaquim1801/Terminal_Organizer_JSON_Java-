package controller;

import model.Task;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.Task.*;

public class taskManagement {
    private List<Task> tasksList = new ArrayList<>();

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public void addNewTask(Task task){
        this.tasksList.add(task);
    }

    public void printingList(){
        for (Task item: tasksList){
            System.out.println(item);
        }
    }

    private String ChooseTask(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------");
        for (Task item: tasksList){
            System.out.println(String.format("-> Name: %s", item.getName()));
        }
        System.out.println("----------------------------");

        System.out.println("Digit the task name:");
        String optionAnswer = scanner.nextLine();

        return optionAnswer;
    }

    public void markCompleted(){

        String optionAnswer = ChooseTask();


        Task task = searchObject(optionAnswer);

        if (task.getStatus().equals(Status.PENDING)){

            System.out.println("TESTE");

            task.setStatus(Status.COMPLETED);
            System.out.println("Task " + "( " + task.getName() + " )" + " marked as concluded");
        }
        else {
            System.out.println("This task is already concluded!");
        }
    }

    private Task searchObject(String name){
        for (Task item: tasksList){
            if (item.getName().equals(name)){
                return item;
            }
        }
        return new Task("NOT_FOUND", "NOT_FOUND", Status.PENDING, Priority.LOW);
    }

    public void removeObject(){

        String optionAnswer = ChooseTask();

        Task taskObject = searchObject(optionAnswer);
        tasksList.remove(taskObject);
        System.out.println("Task " + "( " + taskObject.getName() + " )" + " removed from the list");
    }

    public void editAttributes() throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        Task task = new Task("model", "model", Status.PENDING, Priority.LOW);
        Field[] declaredFields = task.getClass().getDeclaredFields();
        Field fieldSelected = null;


        String optionAnswer = ChooseTask();
        Task taskSelected = searchObject(optionAnswer);

        // Visualize the attributes names and them respect values
        System.out.println("----------------------------");
        for (Field field: declaredFields){
            if (!field.getName().equals("status")){
                field.setAccessible(true);
                try{
                    Object value = field.get(taskSelected);
                    System.out.println("-> " + field.getName() + ": " + value);
                } catch (IllegalAccessException e){
                    System.out.println("IllegalAccessException ERROR");
                }
            }
        }

        System.out.println("----------------------------");

        System.out.println("Which attribute you will choose?");
        String attributeSelected = scanner.nextLine();
        attributeSelected = attributeSelected.trim().toLowerCase();

        // Acessing the field
        for (Field field: declaredFields){
            if (field.getName().equals(attributeSelected)){
                fieldSelected = field;
            }
        }

        System.out.println("What will be the new attribute?");
        String newAttribute;

        // Choosing priority, beacause his type is different from other
        if(fieldSelected.getName().equals("priority")){

            while (true){
                System.out.println("""
                ----------------------------
                [ 1 ] -> LOW
                [ 2 ] -> MEDIUM
                [ 3 ] -> HIGH
                ----------------------------""");
                newAttribute = scanner.nextLine();
                newAttribute = newAttribute.trim().toUpperCase();

                if (newAttribute.equals("LOW") || newAttribute.equals("MEDIUM") || newAttribute.equals("HIGH")){

                    Class<Priority> enumType = (Class<Priority>) fieldSelected.getType();
                    Priority enumValue = Enum.valueOf(enumType, newAttribute);

                    fieldSelected.setAccessible(true);
                    fieldSelected.set(taskSelected,enumValue);
                    break;
                }
            }
        }
        else {
            newAttribute = scanner.nextLine();
            fieldSelected.setAccessible(true);
            fieldSelected.set(taskSelected,newAttribute);
        }

        System.out.println("The attribute" + " ( " + attributeSelected + " ) was changed");



    }
}
