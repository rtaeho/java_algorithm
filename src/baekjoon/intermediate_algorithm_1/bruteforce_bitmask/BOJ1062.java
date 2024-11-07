/*
문제
남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다. 그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다. 김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다. 김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.

남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다. 남극언어에 단어는 N개 밖에 없다고 가정한다. 학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N과 K가 주어진다. N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0이다. 둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다. 단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다. 모든 단어는 중복되지 않는다.

출력
첫째 줄에 김지민이 K개의 글자를 가르칠 때, 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.

예제 입력 1
3 6
antarctica
antahellotica
antacartica
예제 출력 1
2
예제 입력 2
2 3
antaxxxxxxxtica
antarctica
예제 출력 2
0
예제 입력 3
9 8
antabtica
antaxtica
antadtica
antaetica
antaftica
antagtica
antahtica
antajtica
antaktica
예제 출력 3
3
 */
package baekjoon.intermediate_algorithm_1.bruteforce_bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1062 {
    static int N, K;
    static String[] words;
    static Set<Character> essentialChars = Set.of('a', 'n', 't', 'i', 'c');
    static List<Character> additionalChars = new ArrayList<>();
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!essentialChars.contains(c)) {
                additionalChars.add(c);
            }
        }

        chooseAdditionalChars(new HashSet<>(essentialChars), 0, K - 5);
        System.out.println(maxCount);
    }
    
    // K-5개의 추가 문자를 선택하는 백트래킹 메서드
    static void chooseAdditionalChars(Set<Character> learnedChars, int idx, int remaining) {
        // K-5개의 문자를 모두 선택한 경우
        if (remaining == 0) {
            // 선택한 문자들로 읽을 수 있는 단어 개수 세기
            int readableWords = countReadableWords(learnedChars);
            maxCount = Math.max(maxCount, readableWords);
            return;
        }

        // 추가 문자 후보에서 선택할 수 있는 문자가 없거나 인덱스가 범위를 벗어난 경우
        if (idx >= additionalChars.size()) {
            return;
        }

        // 현재 문자 선택
        learnedChars.add(additionalChars.get(idx));
        chooseAdditionalChars(learnedChars, idx + 1, remaining - 1);

        // 현재 문자 선택하지 않고 다음 문자로 진행
        learnedChars.remove(additionalChars.get(idx));
        chooseAdditionalChars(learnedChars, idx + 1, remaining);
    }

    // 선택한 문자 집합으로 읽을 수 있는 단어 수를 계산하는 메서드
    static int countReadableWords(Set<Character> learnedChars) {
        int count = 0;
        for (String word : words) {
            boolean readable = true;
            for (char c : word.toCharArray()) {
                // 읽을 수 없는 문자가 포함된 경우
                if (!learnedChars.contains(c)) {
                    readable = false;
                    break;
                }
            }
            if (readable) {
                count++;
            }
        }
        return count;
    }
}
