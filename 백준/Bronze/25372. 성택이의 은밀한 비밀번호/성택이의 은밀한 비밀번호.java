/*
문제
부산사이버대학교 학생 성택이는 엄마의 의뢰를 받아 주어진 문자열이 현관문 비밀번호에 사용 가능한지 알아내야 한다. 성택이는 공부해야 하므로 우리가 도와주자!

사용할 수 있는 비밀번호의 규칙은 다음과 같다.

비밀번호는 6자리 이상 9자리 이하여야 한다.
예를 들어, 123124는 올바른 비밀번호이고, 1202727161은 잘못된 비밀번호이다. 문자열이 주어졌을 때 현관문 비밀번호로 사용할 수 있는지 판단하자.

입력
첫째 줄에 문자열의 총개수
$N$이 주어진다.

둘째 줄부터
$N$개의 줄에 걸쳐 숫자, 영어 대소문자로만 구성된 문자열이 주어진다.

출력
줄마다 사용할 수 있는 비밀번호면 yes, 그렇지 않으면 no를 출력한다.

제한
 
$1\leq N \leq 1\,000$ 
문자열의 길이는 1자리 이상 20자리 이하이다.
예제 입력 1
3
1245125
asdij
120318739721
예제 출력 1
yes
no
no
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            int len = s.length();
            if (len >= 6 && len <= 9) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
