package com.telran.addressbook.generator;

import com.telran.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = generatecontacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s\n",
                    contact.getName(),
                    contact.getLastname(),
                    contact.getEmail(),
                    contact.getPhone(),
                    contact.getGroup()));
        }
        writer.close();
    }

    private static List<ContactData> generatecontacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withName(String.format("name %s", i))
                    .withLastname(String.format("lastname %s", i))
                    .withEmail(String.format("email%s@mail.com", i))
                    .withPhone(String.format("8(909)123-45-6%s", i))
                    .withGroup(String.format("group %s", i)));
        }
        return contacts;
    }
}
