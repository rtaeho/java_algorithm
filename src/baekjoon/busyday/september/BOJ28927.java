/*
문제
Макс и Мел --- заядлые киноманы. Они оба посмотрели все топ-100 фильмов по версиям большинства популярных сайтов, могут перечислить фильмографию любого известного актера, и редкий их диалог не заканчивается спором, стрелял ли Хан Соло первым.

Одним прекрасным октябрьским утром Макс и Мел решили выяснить, кто же из них больше времени уделяет своему хобби. Макс подсчитал, что за последний год он посмотрел
$t_1$ трейлеров,
$e_1$ сериалов и
$f_1$ фильмов. Мел же посмотрел
$t_2$ трейлеров,
$e_2$ сериалов,
$f_2$ фильмов. Каждый трейлер идет три минуты, сериал 20 минут, а фильм два часа. Помогите им разрешить спор и определить, кто же за последний год посмотрел больше минут видео.

입력
В первой строке входного файла даны 3 целых числа
$t_1, e_1, f_1$ --- количество трейлеров, сериалов и фильмов, которые посмотрел Макс (
$0 \le t_1, e_1, f_1 \le 1000$).

В первой строке входного файла даны 3 целых числа
$t_2, e_2, f_2$ --- количество трейлеров, сериалов и фильмов, которые посмотрел Мел (
$0 \le t_2, e_2, f_2 \le 1000$).

출력
Если Макс суммарно провел больше времени за просмотром видео, чем Мел, выведите Max.

Если Мел суммарно провел больше времени за просмотром видео, чем Макс, выведите Mel.

Если же они оба суммарно просмотрели одинаковое количество минут видео, выведите Draw.

예제 입력 1
15 1 3
1 3 3
예제 출력 1
Max
예제 입력 2
20 3 0
0 0 1
예제 출력 2
Draw
예제 입력 3
1 2 3
3 2 1
예제 출력 3
Max
 */
package baekjoon.busyday.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());
        int f1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        int f2 = Integer.parseInt(st.nextToken());

        int total1 = t1 * 3 + e1 * 20 + f1 * 120;
        int total2 = t2 * 3 + e2 * 20 + f2 * 120;

        if (total1 > total2) {
            System.out.println("Max");
        } else if (total1 < total2) {
            System.out.println("Mel");
        } else {
            System.out.println("Draw");
        }
    }
}
