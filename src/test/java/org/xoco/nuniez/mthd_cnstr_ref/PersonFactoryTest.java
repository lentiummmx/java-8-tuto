package org.xoco.nuniez.mthd_cnstr_ref;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonFactoryTest {

    @Test
    public void create() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        assertEquals(new Person("Peter", "Parker").getFirstName(), person.getFirstName());
    }
}