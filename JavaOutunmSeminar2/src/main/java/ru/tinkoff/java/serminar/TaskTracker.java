package ru.tinkoff.java.serminar;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TaskTracker {

    Task createTask(Task task);

    Task getTask(UUID uuid);

    void deleteTask(UUID uuid);

    List<Task> getAllTasks();

    List<Task> getTodayTasks();

    List<Task> getPriorityTasks();

    List<Task> getViewHistory();

    Map<TaskStatus, List<Task>> getStatusBoard();

}
