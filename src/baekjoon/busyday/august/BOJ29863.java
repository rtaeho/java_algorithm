/*
문제
Arno wants to arrive at school before the start of classes. He sets an alarm clock to ring in the morning. Now he's curious how many hours of sleep he will get. Write a program that would calculate the length of Arno's sleep time.

입력
There are two lines in the input, containing one number each. The first line contains an integer in the range from
$20$ to
$23$ or in the range from
$0$ to
$3$: the time at which Arno goes to sleep. The second line contains an integer in the range from
$5$ to
$10$: the time for which Arno set his alarm to ring and wake him up. All times are given as integer numbers and in the 24-hour format.

출력
Output a single integer: the number of hours from the time when Arno goes to sleep to the time when he wakes up. You may assume that Arno sleeps from the time of going to sleep to the time of the alarm without waking up and that he does not sleep for more than
$24$ hours in a row.

NB! The output may not contain any other words or symbols (i.e. the output should contain exactly one integer).

예제 입력 1
23
7
예제 출력 1
8
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ29863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (20 <= a && a <= 23) {
            System.out.println(24 - a + b);
        } else {
            System.out.println(b - a);
        }
    }
}
