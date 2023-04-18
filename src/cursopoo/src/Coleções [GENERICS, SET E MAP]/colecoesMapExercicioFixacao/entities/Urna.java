package colecoesMapExercicioFixacao.entities;

import java.io.*;
import java.util.*;

public class Urna implements actionsUrna{

    @Override
    public void readUrna(String path, String in, String out) {
        Map<Candidate, Integer> electionMap = new HashMap<>();
        electionMap.put(new Candidate("Alex Blue"), 0);
        electionMap.put(new Candidate("Maria Green"), 0);
        electionMap.put(new Candidate("Bob Brown"), 0);
        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){

            String line = br.readLine();
            while (line != null){
                String[] candidateString = line.split(",");
                Candidate c = new Candidate(candidateString[0]);
                int valor = electionMap.get(c) + Integer.parseInt(candidateString[1]);
                electionMap.put(c, valor);
                System.out.println(c.getName() + "," + valor);
                line = br.readLine();
            }
        } catch (IOException | FileException e){
            System.out.println("Error in read the file");
        }
        writeResult(path, out, electionMap);
    }

    @Override
    public void writeResult(String path, String out, Map<Candidate, Integer> election) {

        Map<Candidate, Integer> sortedElection = new TreeMap<>(new Comparator<Candidate>() {
            @Override
            public int compare(Candidate candidate, Candidate t1) {
                return Integer.compare(election.get(candidate), election.get(t1));
            }
        });

        sortedElection.putAll(election);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){
            for (Map.Entry<Candidate, Integer> entry : sortedElection.entrySet()){
                bw.write(entry.getKey().getName() + ": " + entry.getValue());
                bw.newLine();
            }
        } catch (IOException | FileException e){
            System.out.println("Error in write the file");
        }

    }
}
