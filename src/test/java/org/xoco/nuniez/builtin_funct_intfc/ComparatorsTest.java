package org.xoco.nuniez.builtin_funct_intfc;

import org.junit.Test;
import org.xoco.nuniez.mthd_cnstr_ref.Person;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class ComparatorsTest {
    @Test
    public void comparatorsTest() {
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        assertTrue(comparator.compare(p1, p2) > 0);
        assertTrue(comparator.reversed().compare(p1, p2) < 0);
    }
}
