package ru.tinkoff.java.serminar;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommandHandler {

    private final TaskTracker taskTracker = new IndexedTaskTracker();

    public String addTask(String[] args) {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setSummary(args[1]);
        task.setUser(args[2]);
        task.setPriority(Integer.parseInt(args[3]));
        task.setStatus(TaskStatus.TODO);
        task.setDateCreated(LocalDateTime.now());
        taskTracker.createTask(task);
        return task.toString();
    }

    public String getTask(String[] args) {
        UUID uuid = UUID.fromString(args[1]);
        return taskTracker.getTask(uuid).toString();
    }

    public String getHistory(String[] args) {
        return taskTracker.getViewHistory().stream()
            .map(Task::toString)
            .collect(Collectors.joining("\n"));
    }
}
