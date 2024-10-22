/*
문제
민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.

단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.

예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.

N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.

출력
첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.

예제 입력 1
2
AAA
AAA
예제 출력 1
1998
예제 입력 2
2
GCF
ACDEB
예제 출력 2
99437
예제 입력 3
10
A
B
C
D
E
F
G
H
I
J
예제 출력 3
45
예제 입력 4
2
AB
BA
예제 출력 4
187
 */
package baekjoon.intermediate_algorithm_1.bruteforce_permutation_prac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1339 {
    static int[] weights = new int[26]; // 각 알파벳의 가중치를 저장하는 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        // 각 단어를 입력받음
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            calculateWeights(words[i]); // 가중치 계산
        }

        // 가중치에 따른 알파벳 정렬
        List<Integer> weightList = new ArrayList<>();
        for (int weight : weights) {
            if (weight > 0) {
                weightList.add(weight);
            }
        }

        // 가중치 내림차순 정렬
        Collections.sort(weightList, Collections.reverseOrder());

        // 최대 합 계산
        int maxSum = 0;
        int num = 9; // 숫자 9부터 시작
        for (int weight : weightList) {
            maxSum += weight * num; // 가중치에 숫자를 곱함
            num--; // 다음 숫자 감소
        }

        System.out.println(maxSum);
    }

    // 단어의 각 알파벳에 대한 가중치를 계산하는 메서드
    private static void calculateWeights(String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            // 해당 알파벳의 가중치 계산
            int index = word.charAt(i) - 'A'; // A=0, B=1, ..., Z=25
            weights[index] += Math.pow(10, length - i - 1); // 자리수에 따른 가중치 추가
        }
    }
}