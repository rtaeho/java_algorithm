/*
문제
Недавно Мистер Бин возвращался домой c конференции посвященной 2015 году --- году света и обнаружил, что хулиганы исписали его дверь разными числами.

Мистер Бин любит искать во всем позитив, и в этой ситуации он не растерялся. Дело в том, что Бин очень любит четные числа, но при этом ненавидит нечетные. Поэтому он очень обрадуется, если четных чисел на двери написано больше чем нечетных. Иначе Мистер Бин расстроится.

Ваша задача определить настроение Мистера Бина, если вам известно какие числа напсаны на его двери.

입력
В первой строке входного файла содержится одно целое число
$n$ (
$1 \le n \le 1000$) --- количество чисел на двери Мистера Бина. Во второй строке входного файла даны
$n$ чисел
$a_i$ (
$1 \le a \le 10^9$) --- числа, написанные на двери.

출력
В единственной строке выходного файла выведите Happy, если Мистер Бин будет рад, и Sad в противном случае.

예제 입력 1
3
1 2 1
예제 출력 1
Sad
예제 입력 2
2
2 2
예제 출력 2
Happy
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int even = 0;
        int odd = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        if (even > odd) {
            System.out.println("Happy");
        } else {
            System.out.println("Sad");
        }

        br.close();
    }
}
