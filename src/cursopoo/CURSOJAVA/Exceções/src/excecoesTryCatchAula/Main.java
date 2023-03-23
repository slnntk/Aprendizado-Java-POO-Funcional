package excecoesTryCatchAula;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //CODIGO INICIAL
        /*
        Scanner sc = new Scanner(System.in);
        String[] vect = sc.nextLine().split(" ");
        int position = sc.nextInt();
        System.out.println(vect[position]);
        System.out.println("Fim do programa");
        */

        method1();

    }

    public static void method1(){
        System.out.println("***METHOD1 START***");
        method2();
        System.out.println("***METHOD1 END***");
    }

    public static void method2() {
        System.out.println("***METHOD2 START***");
        Scanner sc = new Scanner(System.in);

        try{
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        //Se a ArrayIndexOutOfBoundsException for capturada, rode as linhas dentro do catch.
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position!");
            e.printStackTrace();
            sc.next();
        }
        //Se a InputMismatchException for capturada, rode as linhas dentro do catch.
        catch (InputMismatchException e){
            System.out.println("Input error");
            e.printStackTrace();
            sc.next();
        }
        System.out.println("***METHOD2 END***");

        sc.close();
    }

}