package org.xoco.nuniez.builtin_funct_intfc.suppliers;

import org.junit.Test;
import org.xoco.nuniez.mthd_cnstr_ref.Person;

import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;

public class SuppliersTest {
    @Test
    public void suppliersTest() {
        Supplier<Person> personSupplier = Person::new;

        assertNotNull(personSupplier.get());
    }
}
