import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;

public class Testes {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int tamanho;
        System.out.println("Quantos numeros?: ");
        tamanho = sc.nextInt();
        int vetor[] = new  int[tamanho];

        for (int i = 0;i < tamanho;i++){
            vetor[i] = sc.nextInt();
        }

        int[] vetorclone = vetor.clone();

        Ordenacao(vetor);

        System.out.println("Vetor desorganizado");
        for (int i = 0;i < vetorclone.length;i++){
            System.out.printf("%d ", vetorclone[i]);
        }

    }



    public static void Ordenacao(int vetor[]){

        int temp;

        /*

        1. Algoritmo de Bubble Sort em ordem crescente, para mudar para decrescente basta alterar o sinal no if.
        2. Para deixar ele adaptavel para qualquer tamanho basta mudar onde tem "2" no primeiro for para uma variavel que diga o tanto de itens a serem verificados, e
        mudar no segundo for de "j < 2-1" para "j < tamanho-1";

         */

        //O primeiro for é usado para percorrer todos os elementos do vetor, se ele não existisse não iam ser todos testados.//
        for (int i = 0; i < vetor.length; i++){
            //O segundo loop (for) é usado para comparar os elementos adjacentes.//
            for (int j = 0; j < vetor.length - 1; j++){
                //O if verifica se o elemento atual é menor que o próximo elemento.//
                if (vetor[j] < vetor[j+1]){
                    //Se o if for verdadeiro, o elemento atual é armazenado em uma variável temporária, para o valor não ser perdido//
                    temp = vetor[j];
                    // O elemento atual é trocado com o próximo elemento, já que ele é menor que o anterior então ele deve ficar antes.//
                    vetor[j] = vetor[j+1];
                    // O elemento armazenado na variável temporária é armazenado no próximo elemento, já que ele é maior que o anterior e a ordem é crescente.
                    vetor[j+1] = temp;
                }
            }
        }

        System.out.println("Vetor organizado");
        for (int i = vetor.length-1;i >= 0;i--){
            System.out.printf("%d ", vetor[i]);
        }
        System.out.println("");
    }
}

