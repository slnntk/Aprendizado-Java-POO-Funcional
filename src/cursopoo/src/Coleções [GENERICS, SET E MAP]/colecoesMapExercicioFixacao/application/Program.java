package colecoesMapExercicioFixacao.application;

import colecoesMapExercicioFixacao.entities.Urna;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\SLNNTK\\Documents\\T";
        String in = "\\INPUTVOTACAO.txt";
        String out = "\\OUTPUTVOTACAO.txt";

        Urna urna = new Urna();
        urna.readUrna(path, in, out);

    }

}
