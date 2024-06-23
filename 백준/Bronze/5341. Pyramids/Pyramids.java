/*
A pyramid of blocks is constructed by first building a base layer of n blocks and then adding n-1 blocks to the next layer. This process is repeated until the top layer only has one block.



You must calculate the number of blocks needed to construct a pyramid given the size of the base. For example, a pyramid that has a base of size 4 will need a total of 10 blocks.

입력
The input will be a sequence of integers, one per line. The end of input will be signaled by the integer 0, and does not represent the base of a pyramid. All integers, other than the last (zero), are positive.

출력
For each positive integer print the total number of blocks needed to build the pyramid with the specified base.

예제 입력 1
4
6
0
예제 출력 1
10
21
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            long n = Long.parseLong(br.readLine());
            if (n == 0) break;
            sb.append(n * (n + 1) / 2).append('\n');
        }
        System.out.print(sb);
    }
}
