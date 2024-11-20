package com.legerito.practice.collections.sets.treeset;

import com.legerito.practice.collections.sets.Contact;
import com.legerito.practice.collections.sets.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
    }
}
