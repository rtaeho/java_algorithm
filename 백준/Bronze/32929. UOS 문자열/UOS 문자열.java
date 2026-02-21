import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // x의 최대값이 10^9이므로 long 타입을 권장합니다.
        long x = sc.nextLong();
        
        // 3으로 나눈 나머지 계산
        if (x % 3 == 1) {
            System.out.println("U");
        } else if (x % 3 == 2) {
            System.out.println("O");
        } else {
            System.out.println("S");
        }
    }
}