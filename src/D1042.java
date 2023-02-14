import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1042 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Ordenacao(sc.nextInt(), sc.nextInt(), sc.nextInt());
        sc.close();
    }

    public static void Ordenacao(int n1, int n2, int n3){

        int vetor[] = {n1, n2, n3};
        int temp;

        /*

        1. Algoritmo de Bubble Sort em ordem crescente, para mudar para decrescente basta alterar o sinal no if.
        2. Para deixar ele adaptavel para qualquer tamanho basta mudar onde tem "2" no primeiro for para uma variavel que diga o tanto de itens a serem verificados, e
        mudar no segundo for de "j < 2-1" para "j < tamanho-1-i";

         */

        //O primeiro for é usado para percorrer todos os elementos do vetor, se ele não existisse não iam ser todos testados.//
        for (int i = 0; i < 2; i++){
            //O segundo loop (for) é usado para comparar os elementos adjacentes.//
            for (int j = 0; j < 2-i; j++){
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

        for (int i = 2;i >= 0;i--){
            System.out.printf("%d%n", vetor[i]);
        }
        System.out.println("");
        System.out.printf("%d%n%d%n%d%n", n1, n2, n3);
    }
}
