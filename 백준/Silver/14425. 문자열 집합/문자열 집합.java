/*
문제
총 N개의 문자열로 이루어진 집합 S가 주어진다.

입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.

다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.

다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.

입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.

출력
첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.

예제 입력 1
5 11
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh
baekjoon
codeplus
codeminus
startlink
starlink
sundaycoding
codingsh
codinghs
sondaycoding
startrink
icerink
예제 출력 1
4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =Integer.parseInt(st.nextToken()); //집합 S의 개수
        int M =Integer.parseInt(st.nextToken()); //비교할 대상의 문자열 개수

        //집합 S 문자열들의 중복을 제거 해당 집합 S에 같은 값이 있으면 집합에 하나로 속하는 것으로 해야함
        Set<String> array = new HashSet<>();

        for(int i = 0; i < N; i++) {
            array.add(br.readLine()); //중복 제거해서 넣고
        }

        int count = 0; //집합 S의 문자열에 비교할 대상의 문자열이 몇개가 속하는지 저장하는 변수

        for(int i = 0; i < M; i++) {
            String str = br.readLine();

            if(array.contains(str)) { //비교할 대상의 문자열이 해당 HashSet 안에 집합 S에 있는 문자열에 포함된다면
                count++; //집합에 속하기 때문에 count를 한다. => 중복을 제거했기 때문에 그냥 증가시켜도 됨.
            }
        }

        System.out.println(count);
        br.close();
    }
}
