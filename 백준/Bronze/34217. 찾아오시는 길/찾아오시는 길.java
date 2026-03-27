import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫째 줄 읽기 (A와 B)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        // 둘째 줄 읽기 (C와 D)
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        // 각 경로의 총 소요 시간 계산
        int hanyang = A + C;
        int yongdap = B + D;
        
        // 결과 판별 및 출력
        if (hanyang < yongdap) {
            System.out.println("Hanyang Univ.");
        } else if (yongdap < hanyang) {
            System.out.println("Yongdap");
        } else {
            System.out.println("Either");
        }
    }
}