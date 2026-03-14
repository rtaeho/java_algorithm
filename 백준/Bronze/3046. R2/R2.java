import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // R1과 S를 입력받음
        int r1 = sc.nextInt();
        int s = sc.nextInt();

        // R2 = 2 * S - R1
        int r2 = (2 * s) - r1;

        // 결과 출력
        System.out.println(r2);
        
        sc.close();
    }
}