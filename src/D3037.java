import java.util.Scanner;

public class D3037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int joaoScore = 0;
            int mariaScore = 0;
            for (int j = 0; j < 3; j++) {
                int x = sc.nextInt();
                int d = sc.nextInt();
                joaoScore += x * d;
            }
            for (int j = 0; j < 3; j++) {
                int x = sc.nextInt();
                int d = sc.nextInt();
                mariaScore += x * d;
            }
            if (joaoScore >= mariaScore) {
                System.out.printf("JOAO\n");
            } else {
                System.out.printf("MARIA\n");
            }
        }
    }
}
