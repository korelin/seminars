package ru.tinkoff.java.serminar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class SimpleTaskTracker implements TaskTracker {

    private final Map<UUID, Task> tasks = new HashMap<>();
    private final HistoryViewManager<UUID> historyViewManager = new InMemoryHistoryViewManager<>();

    @Override
    public Task createTask(Task task) {
        task.setId(UUID.randomUUID());
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Task getTask(UUID uuid) {
        historyViewManager.addView(uuid);
        return tasks.get(uuid);
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public List<Task> getTodayTasks() {
        return tasks.values().stream()
                .filter(task -> DateUtil.isSameDay(task.getDeadline(), LocalDateTime.now())).collect(Collectors.toList());
    }

    @Override
    public void deleteTask(UUID uuid) {
        tasks.remove(uuid);
    }

    @Override
    public List<Task> getPriorityTasks() {
        return tasks.values()
            .stream()
            .sorted(Comparator.comparing(Task::getPriority)).collect(Collectors.toList());
    }

    @Override
    public List<Task> getViewHistory() {
        return historyViewManager.getViewHistory().stream()
            .map(tasks::get)
            .toList();
    }

    @Override
    public Map<TaskStatus, List<Task>> getStatusBoard() {
        Map<TaskStatus, List<Task>> groupedTasks = tasks.values()
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        return groupedTasks.keySet().stream()
                .collect(Collectors.toMap(k -> k, v -> groupedTasks.get(v).stream().sorted().collect(Collectors.toList())));

    }
}
