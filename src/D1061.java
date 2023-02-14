import java.io.IOException;
import java.util.Scanner;

public class D1061 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] dias, horario;
        dias = new int[2];
        horario = new int[6];
        int totalDias = 0 , totalHoras , totalMinutos , totalSegundos;

        /* Quero que tenha um espaço entre um caractere e outro. */
        String[] diainicial = sc.nextLine().split(" ");
        /* Quero que pegue uma string digitada pela usuario e que tudo que tiver "   " agora vai ficar "". */
        String[] horainicial = sc.nextLine().replaceAll(" ","").split(":");

        /* Quero que tenha um espaço entre um caractere e outro. */
        String[] diafinal = sc.nextLine().split(" ");
        /* Quero que pegue uma string digitada pela usuario e que tudo que tiver "   " agora vai ficar "" e as string serão divididas por : ficando assim juntas e separadas por 2 pontos. */
        String[] horafinal = sc.nextLine().replaceAll(" ","").split(":");

        dias[0] = Integer.parseInt(diainicial[1]); // Dia ! Dia = 0 e DiaInicial = 1 ;
        dias[1] = Integer.parseInt(diafinal[1]);// Dia ! Dia = X e DiaFinal = 1 ;

        for (int i = 0;i <= 2;i++){
            horario[i] = Integer.parseInt(horainicial[i]);
        }

        for (int j = 0;j <= 2;j++){
            horario[j+3] = Integer.parseInt(horafinal[j]);
        }

        if (horario[5] >= horario[2]) {
            totalSegundos = horario[5] - horario[2];
        } else {
            totalSegundos = horario[5] - horario[2] + 60;
            horario[4] = horario[4] - 1;
        }
        if (horario[4] >= horario[1]) {
            totalMinutos = horario[4] - horario[1];
        } else {
            totalMinutos = horario[4] - horario[1] + 60;
            horario[3] = horario[3] - 1;
        }
        if (horario[3] >= horario[0]) {
            totalHoras = horario[3] - horario[0];
        } else {
            totalHoras = horario[3] - horario[0] + 24;
            dias[1] = dias[1] - 1;
        }
        if (dias[1] >= dias[0]) {
            totalDias = dias[1] - dias[0];
        }

        System.out.printf("%d dia(s)%n%d hora(s)%n%d minuto(s)%n%d segundo(s)%n", totalDias, totalHoras,totalMinutos,totalSegundos);

        sc.close();
    }
}
