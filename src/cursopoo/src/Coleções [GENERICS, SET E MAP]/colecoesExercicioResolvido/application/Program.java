package colecoesExercicioResolvido.application;

import colecoesExercicioResolvido.entities.User;
import colecoesSetExercicioAula.application.FileException;

import java.io.*;
import java.time.Instant;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\SLNNTK\\Documents\\T";
        String in = "\\TESTEINPUT.txt";
        String out = "\\TESTEOUT.txt";
        Set<User> set = readFile(path, in);
        writeFile(path,out, set);


    }

    public static Set<User> readFile(String path, String in){

        Set<User> set = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path+in))){
            String line = br.readLine();
            while (line != null){
                String[] parameters = line.split(" ");
                set.add(new User(parameters[0], Instant.parse(parameters[1])));
                line = br.readLine();
            }

        } catch (IOException | FileException e){
            throw new FileException("Error in read the archive");
        }
        return set;
    }

    public static void writeFile(String path, String out, Set<User> userSet){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+out))){

            for (User user : userSet){
                bw.write(user.toString());
                System.out.println(user);
                bw.newLine();
            }
            System.out.println("Total users: " + userSet.size());
        } catch (IOException | FileException e){
            throw new FileException("Error in write the archive");
        }

    }

}
