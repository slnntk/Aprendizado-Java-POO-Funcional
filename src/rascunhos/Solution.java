package rascunhos;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int nu = sc.nextInt();
            int result = a;
            for (int j = 0;j < nu;j++){
                result += Math.pow(2, j)*b;
                System.out.printf("%d ", result);
            }
            System.out.println();
        }
    }
}
