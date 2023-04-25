package progFuncionalStreamAula.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        // .map percorre a lista inteira aplicando uma função.

        List<Integer> integerList = Arrays.asList(3, 4, 5, 10, 7);


        Stream<Integer> st1 = integerList.stream().map(x -> x*10);
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<Integer> st2 = integerList.stream().filter(x -> x % 2 == 0).map(x -> x*1000);
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<String> st3 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st3.toArray()));

        // começando com 0, interate para todo x faça x+2, com limite de 100 elementos;
        Stream<Integer> st4 = Stream.iterate(0, x -> x + 2).limit(100);
        System.out.println(Arrays.toString(st4.toArray()));
    }
}
