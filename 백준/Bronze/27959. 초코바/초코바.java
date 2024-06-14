/*
문제
밤고는
$100$원 동전을
$N$개 갖고 있고, 그 돈으로 가격이
$M$원인 초코바를 사 먹으려고 한다. 밤고는 갖고 있는 돈으로 초코바를 사 먹을 수 있는지 알고 싶어 한다.

밤고가 가진 돈이 초코바의 가격 이상이면 밤고는 초코바를 살 수 있다. 밤고가 가진 돈이 초코바를 사기에 충분한지 판단해주자.

입력
첫 번째 줄에 두 정수
$N$과
$M$이 공백을 사이에 두고 주어진다. (
$1 \le N \le 100$,
$1 \le M \le 10\ 000$)

출력
밤고가 초코바를 살 수 있으면 Yes를, 없으면 No를 출력한다.

예제 입력 1
30 300
예제 출력 1
Yes
예제 입력 2
5 10000
예제 출력 2
No
예제 입력 3
7 785
예제 출력 3
No
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(a * 100 < b ? "No" : "Yes");
    }
}
