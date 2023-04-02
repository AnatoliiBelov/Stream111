package org.example;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<? extends Integer> stream = Stream.of(14,15,888,424,678,11,57,8,9,141);
        Comparator<? super Integer> order = Comparator.naturalOrder();
        BiConsumer<? super Optional, ? super Optional> minMaxConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };


        findMinMax(stream, order, minMaxConsumer);
        printEvenIntFromList(List.of(8, 6, 7, 2, 88, 44, 66, 11, 99));
    }

    public static void findMinMax(
            Stream<? extends Integer> stream,
            Comparator<? super Integer> order,
            BiConsumer<? super Optional, ? super Optional> minMaxConsumer
    ) {
        List<? extends Integer> collect = stream.toList();
        if (collect.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        Optional<? extends Integer> min1 = collect.stream().min(order);
        Optional<? extends Integer> max = collect.stream().max(order);
        minMaxConsumer.accept(min1, max);


    }


    public static void printEvenIntFromList(List<Integer> list) {
        list.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }
}
