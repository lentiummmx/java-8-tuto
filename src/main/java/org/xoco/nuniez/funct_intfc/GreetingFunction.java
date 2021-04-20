package org.xoco.nuniez.funct_intfc;

@FunctionalInterface
public interface GreetingFunction {
    void speak(String message);

    default void hello() {
        System.out.println("Hello!");
    }

    default void bye() {
        System.out.println("Bye!");
    }
}
