package model;

public class Task {
    private String name;
    private String description;
    private Status status;
    private Priority priority;

    public Task(String name,String description, Status status, Priority priority) {
        this.priority = priority;
        this.status = status;
        this.description = description;
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public enum Status{
        PENDING, COMPLETED
    }
    public enum Priority{
        LOW, MEDIUM, HIGH
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
