/*
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1
55-50+40
예제 출력 1
-35
예제 입력 2
10+20+30+40
예제 출력 2
100
예제 입력 3
00009-00009
예제 출력 3
0
 */
package baekjoon.busyday.december;

import java.io.*;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // '-' 연산자를 기준으로 문자열 나누기
        String[] splitByMinus = input.split("-");

        int result = 0;

        // 첫 번째 그룹은 더해줍니다.
        result += sumOfString(splitByMinus[0]);

        // 나머지 그룹은 모두 빼줍니다.
        for (int i = 1; i < splitByMinus.length; i++) {
            result -= sumOfString(splitByMinus[i]);
        }

        System.out.println(result);
    }

    // 문자열을 '+' 기준으로 나눈 뒤, 숫자를 더하는 함수
    private static int sumOfString(String str) {
        String[] splitByPlus = str.split("\\+"); // '+'는 정규 표현식에서 특별한 의미가 있어 \\로 이스케이프
        int sum = 0;
        for (String s : splitByPlus) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
