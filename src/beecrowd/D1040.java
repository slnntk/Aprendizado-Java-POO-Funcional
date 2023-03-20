package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

    public class D1040 {
        public static void main(String[] args) throws IOException {


            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            float notas[] = new float[4];

            for (int i = 0;i< 4;i++){
                notas[i] = sc.nextFloat();
            }
            System.out.printf("Media: %.1f%n", mediafuncao(notas));
            if (mediafuncao(notas) >= 7){
                System.out.printf("Aluno aprovado.%n");
            }
            else if (mediafuncao(notas) < 5){
                System.out.printf("Aluno reprovado.%n");
            }
            else if (mediafuncao(notas) >= 5 && mediafuncao(notas) <= 6.9){
                System.out.printf("Aluno em exame.%n");
                float exame = sc.nextFloat();
                System.out.printf("Nota do exame: %.1f%n", exame);
                if ( mediafuncao(notas, exame) >= 5.0){
                    System.out.printf("Aluno aprovado.%n");
                    System.out.printf("Media final: %.1f%n", mediafuncao(notas, exame));
                }
                else{
                    System.out.printf("Aluno reprovado.%n");
                    System.out.printf("Media: %.1f%n", mediafuncao(notas,exame));
                }
            }
        }

        public static float mediafuncao(float notas[]){
            return ((notas[0] * 2) + (notas[1] * 3) + (notas[2] * 4) + (notas[3] * 1))/10 ;
        }

        public static float mediafuncao(float[] notas, float exame){
            return (mediafuncao(notas) + exame)/2;
        }
}

