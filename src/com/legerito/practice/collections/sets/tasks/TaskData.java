package com.legerito.practice.collections.sets.tasks;

import java.util.*;

public class TaskData {

    private static final String allTasks = """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low
            """;

    public static final String annsTask = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy,Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views,Low, In Progress
            """;

    public static final String bobsTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress
            """;

    public static final String carolsTask = """
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Access, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Access, Write Views, Low
            """;

    public static Set<Task> getData(String assginee) {
        Set<Task> taskList = new HashSet<>();
        String tasks = allTasks;
        if(assginee != null) {
            tasks = switch (assginee.toLowerCase()) {
                case "ann" -> annsTask;
                case "bob" -> bobsTasks;
                case "carol" -> carolsTask;
                default -> allTasks;
            };
        }
        Scanner scanner = new Scanner(tasks);
        while(scanner.hasNext()) {
            String[] taskDetails = scanner.nextLine().split(",");
            Arrays.asList(taskDetails).replaceAll(String::trim);
            Task task = new Task(taskDetails[0], taskDetails[1], assginee);
            if(taskDetails.length > 3) {
                task.setPriority(extractPriority(taskDetails[2]));
                task.setStatus(extractStatus(taskDetails[3]));
            } else {
                task.setPriority(extractPriority(taskDetails[2]));
            }
            taskList.add(task);
        }
        return taskList;
    }

    private static Priority extractPriority(String priority) {
        if(priority.equalsIgnoreCase(Priority.HIGH.getValue())) return Priority.HIGH;
        if(priority.equalsIgnoreCase(Priority.MEDIUM.getValue())) return Priority.MEDIUM;
        else return Priority.LOW;
    }

    private static Status extractStatus(String status) {
        if(status.equalsIgnoreCase(Status.ASSIGNED.getValue())) return Status.ASSIGNED;
        if(status.equalsIgnoreCase(Status.IN_PROGRESS.getValue()))return Status.IN_PROGRESS;
        else return Status.NOT_YET_ASSIGNED;
    }
}
