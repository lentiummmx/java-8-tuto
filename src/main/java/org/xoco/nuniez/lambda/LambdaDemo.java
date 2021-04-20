package org.xoco.nuniez.lambda;

import org.xoco.nuniez.funct_intfc.GreetingFunction;

import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        GreetingFunction greetingFunction = message -> System.out.println("Hello " + message + "!");
        greetingFunction.hello();
        greetingFunction.speak("Tom");
        greetingFunction.speak("Marry");
        greetingFunction.bye();

        implementComparator_anonymous();
        implementComparator_lambda();
    }

    private static void implementComparator_lambda() {
        Comparator<Integer> compareInt = (o1, o2) -> o1.compareTo(o2);
        System.out.println(compareInt.compare(3, 4));
    }

    private static void implementComparator_anonymous() {
        Comparator<Integer> compareInt = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(compareInt.compare(3, 4));
    }
}
