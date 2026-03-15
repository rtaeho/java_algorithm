import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 M 입력
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 최소 횟수는 (N * M) - 1
        System.out.println(n * m - 1);

        sc.close();
    }
}