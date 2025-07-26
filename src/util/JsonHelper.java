package util;

import com.google.gson.reflect.TypeToken;
import model.Task;

import java.io.*;

import main.Main;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    public static void Serialize(List<Task> tasks) throws IOException {

        FileWriter writer = new FileWriter(Main.filePath);

        Main.gson.toJson(tasks, writer);

        writer.close();
    }

    public static void Deserialize() throws IOException {

        FileReader fileReader = new FileReader(Main.filePath);

        Type taskListType = new TypeToken<ArrayList<Task>>(){}.getType();
        List<Task> tasksList = Main.gson.fromJson(fileReader, taskListType);

        Main.taskManagement.setTasksList(tasksList);

        fileReader.close();
    }
}
