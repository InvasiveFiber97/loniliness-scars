package com.legerito.practice.collections.sets.tasks;

import java.util.*;

public class Main {

    private static final String lineSeparator = "-".repeat(100);

    public static void main(String[] args) {

        Set<Task> bob = TaskData.getData("Bob");
        Set<Task> ann = TaskData.getData("Ann");
        Set<Task> carol = TaskData.getData("Carol");
        Set<Task> allTasks = TaskData.getData(null);
        List<Set<Task>> taskList = new ArrayList<>(List.of(bob, ann, carol));
//        printData("All Tasks", allTasks);
        getUnionOfTasks(taskList);
//        getSetIntersection(ann, allTasks);
//        getSetDifference(allTasks, ann);
    }

    public static <T> void printData(String header, Collection<T> collection) {
        printHeader();
        collection.forEach(System.out::println);
    }

    public static void getUnionOfTasks(List<Set<Task>> input) {
        printHeader();
        Set<Task> output = new HashSet<>();
        input.forEach(output::addAll);
        output.forEach(System.out::println);
    }

    public static void getSetIntersection(Set<Task> a, Set<Task> b) {
        printHeader();
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        intersect.forEach(System.out::println);
    }

    public static void getSetDifference(Set<Task> a, Set<Task> b) {
        printHeader();
        Set<Task> aMinusB = new HashSet<>(a);
        aMinusB.removeAll(b);
        aMinusB.forEach(System.out::println);
    }

    public static void printHeader() {
        System.out.println(lineSeparator);
        System.out.printf("%-25s %-25s %-15s %-15s %s%n", "Project", "Task Description", "Priority", "Assignee", "Status");
        System.out.println(lineSeparator);
    }
}
