package colecoesMapExercicioFixacao.entities;

import java.util.Map;

interface actionsUrna {

    void readUrna(String path, String in, String out);
    void writeResult(String path, String out, Map<Candidate, Integer> election);


}
