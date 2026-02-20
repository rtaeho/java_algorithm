import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        int F = sc.nextInt();
        
        // 1. 뒤 두 자리를 00으로 변경
        N = (N / 100) * 100;
        
        // 2. 00부터 99까지 더하며 탐색
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            if ((N + i) % F == 0) {
                answer = i;
                break; // 가장 작은 값을 찾아야 하므로 찾자마자 종료
            }
        }
        
        // 3. 두 자리 형식으로 출력 (%02d는 두 자리 미만일 때 앞에 0을 채움)
        System.out.printf("%02d\n", answer);
    }
}