package ayslan;

public class Main {
    public static void main(String[] args) {
        int somaPares = 0;                         // somaPares = 0
        int somaTotalPares = 0;                    // somaTotalPares = 0
        for (int c = 1;c <= 100;c = c + 1){        // for c in range(1, 101)
            if (c % 2 == 0){
                somaPares = somaPares + 1;             // somaPares = somaPares + 1
                somaTotalPares = somaTotalPares + c;   // somaTotalPares = somaTotalPares + c;
            }
        }
        System.out.println("A soma dos números pares é: " + somaTotalPares);
        System.out.println("A quantida de de números pares é de : " + somaPares);
    }
}
