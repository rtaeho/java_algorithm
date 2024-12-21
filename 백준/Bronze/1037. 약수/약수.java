import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 진짜 약수의 개수 입력
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 진짜 약수 배열 생성
        int[] divisors = new int[count];
        for (int i = 0; i < count; i++) {
            divisors[i] = Integer.parseInt(st.nextToken());
        }

        // 약수 정렬
        Arrays.sort(divisors);

        // N 계산: 가장 작은 값 * 가장 큰 값
        int N = divisors[0] * divisors[count - 1];

        // 결과 출력
        System.out.println(N);
    }
}