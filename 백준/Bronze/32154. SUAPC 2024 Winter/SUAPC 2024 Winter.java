/*
문제


[그림] SUAPC 2024 Winter 스코어보드 (링크)

SUAPC는 신촌지역 5개 대학(서강, 숙명, 연세, 이화, 홍익)의 학부생 및 대학원 1년 차를 대상으로 하는 프로그래밍 대회다. 대회 문제는 서울 리저널의 문제 출제 경향을 따르며 제한 시간 동안 얼마나 많은 문제를 정확하게 풀 수 있는지를 평가하여 순위를 결정한다. 위의 사진은 SUAPC 2024 Winter의 스코어보드다.

문제를 많이 푼 팀이 고순위로 결정되며, 동일 수의 문제를 푼 팀이 다수 있는 경우 푼 문제들의 페널티(
$=$ (첫 정답을 제출한 시간)
$+$ (첫 정답을 받기 전까지 오답을 제출한 횟수)
$\times$
$20$)의 합이 작은 순으로 순위가 결정된다. 위 사진의 스코어보드 상에서 가장 오른쪽에 적힌 수가 각 팀이 푼 문제들의 페널티의 합을 의미한다.

양의 정수
$N$이 주어졌을 때, SUAPC 2024 Winter에서
$N$등을 한 팀이 푼 문제 수와 푼 문제 번호들을 구하여라.

입력
첫 번째 줄에 양의 정수
$N$이 주어진다. (
$1 \le N \le 10$)

출력
첫 번째 줄에는 SUAPC 2024 Winter에서
$N$등을 한 팀이 푼 문제 수를 출력한다.

두 번째 줄에는
$N$등을 한 팀이 푼 문제 번호를 사전 순으로 공백으로 구분하여 출력한다. 이때, 문제 번호의 알파벳은 대문자로 출력한다.

예제 입력 1
1
예제 출력 1
11
A B C D E F G H J L M
예제 입력 2
2
예제 출력 2
9
A C E F G H I L M
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<String>> rankData = new HashMap<>();
        rankData.put(1, List.of("A", "B", "C", "D", "E", "F", "G", "H", "J", "L", "M"));
        rankData.put(2, List.of("A", "C", "E", "F", "G", "H", "I", "L", "M"));
        rankData.put(3, List.of("A", "C", "E", "F", "G", "H", "I", "L", "M"));
        rankData.put(4, List.of("A", "B", "C", "E", "F", "G", "H", "L", "M"));
        rankData.put(5, List.of("A", "C", "E", "F", "G", "H", "L", "M"));
        rankData.put(6, List.of("A", "C", "E", "F", "G", "H", "L", "M"));
        rankData.put(7, List.of("A", "C", "E", "F", "G", "H", "L", "M"));
        rankData.put(8, List.of("A", "C", "E", "F", "G", "H", "L", "M"));
        rankData.put(9, List.of("A", "C", "E", "F", "G", "H", "L", "M"));
        rankData.put(10, List.of("A", "B", "C", "F", "G", "H", "L", "M"));

        List<String> problems = rankData.get(N);
        System.out.println(problems.size());
        System.out.println(String.join(" ", problems));
    }
}
