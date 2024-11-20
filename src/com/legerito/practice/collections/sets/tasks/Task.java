package com.legerito.practice.collections.sets.tasks;


enum Status {
    ASSIGNED("Assigned"), IN_PROGRESS("In Progress"), NOT_YET_ASSIGNED("Not Yet Assigned");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
enum Priority {

    HIGH("High"),  MEDIUM("Medium"), LOW("Low");
    private final String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

public class Task implements Comparable<Task>{

    private String project;

    private String assignee;

    private String description;

    private Status status;

    private Priority priority;

    public Task() {
    }

    public Task(String project, String description, String assignee) {
        this(project, assignee == null ? "None" : assignee, description, Status.NOT_YET_ASSIGNED, Priority.LOW);
    }

    public Task(String project, String assignee, String description, Status status, Priority priority) {
        this.project = project;
        this.assignee = assignee;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        int compareProjectName = o.project.compareTo(this.project);
        return compareProjectName == 0 ? o.description.compareTo(this.description) : compareProjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!getProject().equals(task.getProject())) return false;
        return getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProject().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "%-25s %-25s %-15s %-15s %s".formatted(this.project, this.description, this.priority,
                this.assignee, this.status);
    }
}
