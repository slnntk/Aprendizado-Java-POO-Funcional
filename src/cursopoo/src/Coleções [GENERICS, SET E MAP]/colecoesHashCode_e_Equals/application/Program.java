package colecoesHashCode_e_Equals.application;

public class Program {
    public static void main(String[] args) {

        String a = "Maria";
        String b = "Maria";

        System.out.println(a.equals(b));

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }
}
