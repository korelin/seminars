package ru.tinkoff.java.serminar;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommandHandler {

    private final TaskTracker taskTracker = new IndexedTaskTracker();

    public String addTask(String[] args) {
        Task task = new Task(args[1], Integer.parseInt(args[3]), args[2]);
        taskTracker.createTask(task);
        return task.toString();
    }

    public String getTask(String[] args) {
        UUID uuid = UUID.fromString(args[1]);
        return taskTracker.getTask(uuid).toString();
    }

    public String getAllTasks() {
        return taskTracker.getAllTasks().stream().map(task -> task.toString()).collect(Collectors.joining(",", "TaskList=[", "]"));
    }

    public String remove(String id) {
        UUID uuid = UUID.fromString(id);
        taskTracker.deleteTask(uuid);
        return String.format("Task id: %s successfully deleted", uuid);
    }


    public String getHistory(String[] args) {
        return taskTracker.getViewHistory().stream()
            .map(Task::toString)
            .collect(Collectors.joining("\n"));
    }
}
