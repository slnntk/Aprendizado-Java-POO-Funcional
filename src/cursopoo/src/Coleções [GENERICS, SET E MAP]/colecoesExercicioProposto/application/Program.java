package colecoesExercicioProposto.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int alunos;

        Set<Integer> aCourse = new HashSet<>();
        Set<Integer> bCourse = new HashSet<>();
        Set<Integer> cCourse = new HashSet<>();

        System.out.print("How many students for course A?");
        alunos = sc.nextInt();
        for (int i = 0;i < alunos;i++){
            aCourse.add(sc.nextInt());
        }

        System.out.print("How many students for course B?");
        alunos = sc.nextInt();
        for (int i = 0;i < alunos;i++){
            bCourse.add(sc.nextInt());
        }

        System.out.print("How many students for course C?");
        alunos = sc.nextInt();
        for (int i = 0;i < alunos;i++){
            cCourse.add(sc.nextInt());
        }

        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(aCourse);
        intersection.addAll(bCourse);
        intersection.addAll(cCourse);
        System.out.println("Total de alunos do professor: " + intersection.size());



    }
}
