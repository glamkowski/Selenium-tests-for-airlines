import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strumienie {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jan", "Oskar", "Ola", "Anna");

        Stream<String> streamNames = names.stream();

        streamNames.map(e -> e + " [DODANO]");

for (String name : names) {
    System.out.println(name);
}

        // MAP - zmiana elementu na coś innego

        // Limit - Zwraca określona liczbe elementów

        // Pick - pozwala przeprowadzic operacje na kazdym elemencie

        // forEch - wykonanie akcji dla kazdego elementu ze strumienia
        // count - zwroci ilost elementow w struminiu
        // allMatch - Sprawdza czy elementy spelniaja jakis warunek
        // collect - zwrac anowy typ na podstawie strumienia ( zwraca liste np.)

        System.out.println();


        System.out.println(streamNames);


    }
}
