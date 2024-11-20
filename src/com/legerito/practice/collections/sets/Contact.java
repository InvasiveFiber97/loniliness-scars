package com.legerito.practice.collections.sets;

import java.util.HashSet;
import java.util.Set;

public class Contact {

    private final String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if(email != null) emails.add(email);
        if(phone > 0){
            String ph = String.valueOf(phone);
            ph = "(%s) %s-%s".formatted(ph.substring(0,3), ph.substring(3, 6),ph.substring(6));
            phones.add(ph);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%s : %s, %s".formatted(this.name, this.emails, this.phones);
    }

    public Contact mergeContactData(Contact contact) {
        Contact newContact = new Contact(this.name);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails = new HashSet<>(this.emails);

        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);

        return newContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return 33 * getName().hashCode();
    }

    public void addEmail(String companyName) {

        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length - 1],
                companyName.replaceAll(" ", "").toLowerCase());
        if (!emails.add(email)) {
            System.out.println(name + " already has email " + email);
        } else {
            System.out.println(name + " now has email " + email);
        }
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {

        if (emails.contains(oldEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }
    }
}
