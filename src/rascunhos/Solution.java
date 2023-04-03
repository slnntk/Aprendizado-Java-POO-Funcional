package rascunhos;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        int i1 = sc.nextInt();
        String s2 = sc.next();
        int i2 = sc.nextInt();
        String s3 = sc.next();
        int i3 = sc.nextInt();

        System.out.printf("================================%n" +
                          "%s               %03d%n" +
                          "%s               %03d%n" +
                          "%s               %03d%n" +
                          "================================%n", s1,i1,s2,i2,s3,i3);
    }
}