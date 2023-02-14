import java.util.Locale;
import java.util.Scanner;

public class D1049 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        String[] vetor = new String[3];

        for (int i = 0;i< 3;i++){
            vetor[i] = sc.next();
        }

        if (vetor[0].equalsIgnoreCase("vertebrado")){
            if (vetor[1].equalsIgnoreCase("ave")){
                if (vetor[2].equalsIgnoreCase("carnivoro")){
                    System.out.println("aguia");
                }
                else{
                    System.out.println("pomba");
                }
            }
            else {
                if (vetor[2].equalsIgnoreCase("onivoro")){
                    System.out.println("homem");
                }
                else {
                    System.out.println("vaca");
                }

            }

        }

        else {
            if (vetor[1].equalsIgnoreCase("inseto")){
                if (vetor[2].equalsIgnoreCase("hematofago")){
                    System.out.println("pulga");
                }
                else {
                    System.out.println("lagarta");
                }
            }
            else {
                if (vetor[2].equalsIgnoreCase("onivoro")){
                    System.out.println("minhoca");
                }
                else {
                    System.out.println("sanguessuga");
                }

            }

        }
        sc.close();
    }
}