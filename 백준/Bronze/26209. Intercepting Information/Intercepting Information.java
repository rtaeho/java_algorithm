/*
Intercepting Information 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	1024 MB	2972	2245	2095	76.516%
문제
Spies Breaching Computers (SBC) is a private digital spy agency that is developing a new device for intercepting information using electromagnetic waves, which allows spying even without physical contact with the target.

The device tries to collect information one byte at a time, this is, a sequence of
$8$ bits where each of them, naturally, can have a value of
$0$ or
$1$. In certain situations, due to interference from other devices, the reading cannot be done successfully. In this case, the device returns the value
$9$ for the corresponding bit, informing that the reading could not be performed.

In order to automate the recognition of the information the device reads, a request was made for a program that, based on the information read by the device, informs whether all bits were read successfully or not. Your task is to write this program.

입력
The input consists of a single line, containing
$8$ integers
$N_1$,
$N_2$,
$N_3$,
$N_4$,
$N_5$,
$N_6$,
$N_7$ and
$N_8$, indicating the values read by the device (
$N_i$ is 0, 1 or 9 for
$1 ≤ i ≤ 8$).

출력
Print a single line containing the capital letter “S” if all bits are read successfully; otherwise print a single line containing the capital letter “F”, corresponding to a failure.

예제 입력 1
0 0 1 1 0 1 0 1
예제 출력 1
S
예제 입력 2
0 0 1 9 0 1 0 1
예제 출력 2
F
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("9")) {
                System.out.println("F");
                return;
            }
        }
        System.out.println("S");
    }
}
