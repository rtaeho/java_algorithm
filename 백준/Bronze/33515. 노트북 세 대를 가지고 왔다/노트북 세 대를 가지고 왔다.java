import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 두 팀원의 기록 입력
        int T1 = Integer.parseInt(st.nextToken());
        int T2 = Integer.parseInt(st.nextToken());

        // 형진이가 자신의 노트북을 쓰기 위한 최대 시간은 두 기록 중 최솟값
        // Math.min을 사용하면 간결하게 처리 가능합니다.
        int result = Math.min(T1, T2);

        System.out.println(result);
    }
}