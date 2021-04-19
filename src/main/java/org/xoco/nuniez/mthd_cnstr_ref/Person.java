package org.xoco.nuniez.mthd_cnstr_ref;

import lombok.Data;

@Data
public class Person {
    String firstName;
    String lastName;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
