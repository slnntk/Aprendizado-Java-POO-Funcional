package rascunhos.leitorDeTxt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* Criar um objeto do tipo File, que é uma classe importada do java.io, que vai ser instanciada
        pelo caminho até o arquivo que deve ser lido */

        File file = new File("D:\\Users\\cassi\\Downloads\\SEMAFORO\\CODIGO.txt");

        /* Tento declarar o scanner como vazio, para poder o finally fechar o Scanner apenas quando ele
        tiver sido instanciado e o codigo tiver acabado */

        Scanner sc = null;

        /* Agora o programa vai tentar(try) fazer o que está dentro dele */
        try {
            /* Tentar instanciar o Scanner apontando para o arquivo (file) */
            sc = new Scanner(file);
                /* Se o Scanner apontar para um arquivo que NÃO EXISTE, vai ser lançada a Exceção FileNotFoundException,
                que vai ser capturada pelo catch e tratada.*/
                /* Se o Scanner apontar para um arquivo que EXISTE, vai rodar o while*/

            /* Enquanto sc.haxNextLine == true, ou seja enquanto tiver uma proxima linha no Scanner*/
            while(sc.hasNextLine()){
                /* Imprima a linha e pule para a proxima.*/
                System.out.println(sc.nextLine());
            }
        }
        /* Só vai passar aqui se o Scanner apontar para um arquivo que não existe. */
        catch (FileNotFoundException e) {
            /*Se está passando por aqui é por que realmente foi lançada a Exceção, e vai ser impresso a mensagem dentro do
            print e onde o programa tentou procurar e não conseguiu.*/
            System.out.println("Error opening file: " + e.getMessage());
        }
        /* Por fim, se o sc for diferente de null, ou seja ele tiver instanciado, fechar o scanner.*/
        finally {
            if (sc != null){
                /*Fechar o scanner significa fechar o arquivo*/
                sc.close();
            }
            System.out.println();
            System.out.println("Finally Block executed");
        }

    }
}
