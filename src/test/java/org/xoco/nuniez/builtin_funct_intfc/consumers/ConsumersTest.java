package org.xoco.nuniez.builtin_funct_intfc.consumers;

import org.junit.Test;
import org.xoco.nuniez.mthd_cnstr_ref.Person;

import java.util.function.Consumer;

public class ConsumersTest {
    @Test
    public void consumersTest() {
        Consumer<Person> greeter = person -> System.out.println("Hello, " + person.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
