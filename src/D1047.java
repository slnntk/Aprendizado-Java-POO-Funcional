import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1047 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //0 - horainicial , 1 - minutoinicial, 2 horafinal, 3 - minuto final;
        int[] vetor;
        vetor = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
        int[] horaseminutos = new int[2];

        /*
         1. Subtrair o valor final - o inicial, já que se for maior que 0 significa que o valor está facilmente encontrado,
         exemplo 10:10 - 20:20 = 10 horas e 10 minutos, o resultado já sai de cara sem ter que testar várias condições.
         2. Se o valor for menor que 0 em alguma das condições significa que : No caso das horas se a hora final for menor que a inicial
         é por que as horas finais passaram pela meia noite e foram para o outro dia. Já se for os minutos é mais facilmente entendido já que
         passou uma hora e ele deve decrescer 1H já que se continuar assim vai ter sempre uma hora a mais na conta.
         */
        horaseminutos[0] = vetor[2] - vetor[0];
        horaseminutos[1] = vetor[3] - vetor[1];

        if (horaseminutos[0] < 0){
            horaseminutos[0] = 24 + horaseminutos[0];
        }

        if (horaseminutos[1] < 0){
            horaseminutos[1] = 60 + horaseminutos[1];
            horaseminutos[0]--;
        }

        if (vetor[0] == vetor[2] & vetor[1] == vetor[3]){
            System.out.printf("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)%n");
        }
        else if (vetor[0] == vetor[2] & vetor[3] < vetor[1]){
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", 23, horaseminutos[1]);
        }
        else  {
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", horaseminutos[0], horaseminutos[1]);
        }
        sc.close();
    }
}

