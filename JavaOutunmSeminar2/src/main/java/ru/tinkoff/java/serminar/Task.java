package ru.tinkoff.java.serminar;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private UUID id;
    private String summary;
    private Integer priority;
    private TaskStatus status;
    private String user;
    private LocalDateTime dateCreated;
    private LocalDateTime deadline;

    public Task() {
        this.id = UUID.randomUUID();
        this.dateCreated = LocalDateTime.now();
    }

    public Task(String summary, Integer priority, String user) {
        this();
        this.summary = summary;
        this.priority = priority;
        this.user = user;
        this.status = TaskStatus.TODO;
    }

    public Task(String summary, String user) {
        this(summary, 0, user);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
               "id=" + id +
               ", summary='" + summary + '\'' +
               ", priority=" + priority +
               ", status=" + status +
               ", user='" + user + '\'' +
               ", dateCreated=" + dateCreated +
               ", deadline=" + deadline +
               '}';
    }
}
