public class D1098 {
    public static void main(String[] args) {
        for (double i = 0; i <= 2; i += 0.2) {
            for (int j = 1; j <= 3; j++) {
                if (Math.floor(i + j) == i + j) {
                    System.out.printf("I=%.0f J=%.0f\n", i, i + j);
                } else {
                    System.out.printf("I=%.1f J=%.1f\n", i, i + j);
                }
            }
        }
    }
}
