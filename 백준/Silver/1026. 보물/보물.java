import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int N = sc.nextInt();
        int[] A = new int[N];
        Integer[] B = new Integer[N]; // 내림차순 정렬을 위해 Integer 객체 배열 사용

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // 2. 정렬하기
        // A는 오름차순 정렬
        Arrays.sort(A);
        // B는 내림차순 정렬 (Collections.reverseOrder() 사용)
        Arrays.sort(B, Collections.reverseOrder());

        // 3. 합산 계산하기
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        // 4. 결과 출력
        System.out.println(S);

        sc.close();
    }
}