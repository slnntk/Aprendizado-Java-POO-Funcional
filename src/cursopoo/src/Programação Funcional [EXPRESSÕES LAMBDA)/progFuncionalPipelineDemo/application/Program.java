package progFuncionalPipelineDemo.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        //vai pegar qlq x da minha lista e vai transformar em x * 10 por exemplo;
        Stream<Integer> st1 = list.stream().map(x -> x*10);
        System.out.println(Arrays.toString(st1.toArray()));


        //pega o elemento inicial, e dps uma função que recebe 2 argumentos
        //x, y resultando na operação x+y;
        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
