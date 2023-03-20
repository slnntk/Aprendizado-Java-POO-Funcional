package estruturadedados;

import java.util.Scanner;

public class Aula1e2_buscaLinear {
    public static void main(String[] args) {
        //AULA1 - https://www.youtube.com/watch?v=8zVdz6TyV_c&list=PLTLAlheiUm5FRR5BNn4iBFwzYHiNq2Iv2&index=2
        Scanner sc = new Scanner(System.in);

        int [] vetorNumeros = new int[10];
        vetorNumeros[0] = 3;
        vetorNumeros[1] = 4;
        vetorNumeros[2] = 8;
        vetorNumeros[3] = 13;
        vetorNumeros[4] = 22;
        vetorNumeros[5] = 51;
        vetorNumeros[6] = 33;

        System.out.print("Qual numero deseja buscar? ");
        int numeroBuscar = sc.nextInt();
        boolean isNumeroExiste = false;
        for (int i = 0;i < vetorNumeros.length;i++){
            if (vetorNumeros[i] == numeroBuscar){
                isNumeroExiste = true;
                break;
            }
        }

        if (isNumeroExiste){
            System.out.println("Achou o numero");
        }
        else{
            System.out.println("Não achou o numero");
        }


        //AULA 2 - https://www.youtube.com/watch?v=XtiZbDtqc84&list=PLTLAlheiUm5FRR5BNn4iBFwzYHiNq2Iv2&index=2

        String [] vetorEstados = new String[10];
        vetorEstados[0] = "AC";
        vetorEstados[1] = "BA";
        vetorEstados[2] = "CE";
        vetorEstados[3] = "DF";
        vetorEstados[4] = "AM";
        vetorEstados[5] = "AP";
        vetorEstados[6] = "PB";
        vetorEstados[7] = "RN";
        vetorEstados[8] = "MS";
        vetorEstados[9] = "SP";

        System.out.print("Qual estado deseja buscar? ");
        String estadoBuscar = sc.next();
        boolean isEstadoExiste = false;
        for (int i = 0;i < vetorEstados.length;i++){
            if(vetorEstados[i].equalsIgnoreCase(estadoBuscar)){
                isEstadoExiste = true;
            }
        }

        if (isEstadoExiste){
            System.out.println("Achou o estado");
        }
        else{
            System.out.println("Não achou o estado");
        }

    }
}