# 📁 Task Manager · Java 🧠📅

A simple but flexible **Java-based Task Manager** application that supports creating, editing, listing, and saving tasks. It uses **Gson** for JSON storage and **Java Reflection** to allow dynamic attribute editing – including enums like priority and status.

---

## 🚀 Features

- ✅ Create new tasks
- 📝 Edit task attributes (even `enum` fields!)
- 📋 List all tasks
- 💾 Save/load tasks to/from a `.json` file
- 🔄 Dynamic editing via reflection (`Field`)

---

## 🛠️ Technologies Used

- ☕ Java 17+
- 📦 [Gson](https://github.com/google/gson) (for JSON serialization)
- 🔍 Java Reflection API

---

## 📁 Project Structure
```
📂 project-root/
├── 📂 lib/
│ └── gson-2.10.1.jar
├── 📂 src/
│ ├── 📂 main/
│ │ └── Main.java
│ ├── 📂 controller/
│ │ └── TaskManagement.java
│ ├── 📂 model/
│ │ └── Task.java
│ └── 📂 jsonFile/
│ └── .json created by the program
```

## ▶️ How to Run

1. **Compile** the source files:
   ```bash
   javac -cp lib/gson-2.10.1.jar -d bin src/**/*.java
   ```
2. Run the application:
  ```bash
  java -cp lib/gson-2.10.1.jar;bin main.Main
  ```
  🐧 On Linux/macOS, use : instead of ; in the classpath.

3. Intellij Users ( OPTIONAL )
  ```
  File -> Project Structure -> Libraries -> New Project Library -> From Maven Repository -> Search: com.google.code.gson:gson:2.10.1
  ```

##  🧪 Sample Interaction
  ```
  OPTIONS
  ----------------------------
  [ 1 ] - Add new task;
  [ 2 ] - List all taks;
  [ 3 ] - Edit task;
  [ 4 ] - Mark as concluded;
  [ 5 ] - Remove task.
  ----------------------------
  
  Which option you will choose?
  1
  Task name:
  Study physics
  Task description:
  Eletromagnetism chapter 1
  Task priority [ LOW, MEDIUM or HIGH ]:
  MEDIUM
  ----------------------------
  Do you want to continue?
  ----------------------------
  no


  ```

# 📞 Contact
* Joaquim Maia - joaquimaiafilho2018@gmail.com
* Project Link: [https://github.com/Joaaquim1801/Eletro-Musical---Django-/](https://github.com/Joaaquim1801/Terminal_Organizer_JSON_Java-)

⭐ If this project helps you, consider give project a star!
