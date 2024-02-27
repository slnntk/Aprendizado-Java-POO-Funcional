package CANA.src;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] array = new int[]{2, 3, 10, 9, 4, 7, 5, 20};
        Arrays.stream(array)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        for (int j = 1;j < array.length;j++){
            int key = array[j];
            int i = j - 1;
            while (i > 0 && array[i] > key){
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }

        Arrays.stream(array)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

    }
}

