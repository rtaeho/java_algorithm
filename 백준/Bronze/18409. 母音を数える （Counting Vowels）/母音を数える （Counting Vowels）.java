/*
문제
長さ N の英小文字からなる文字列 S が与えられる．S のうち母音字の個数，つまり a，i，u，e，o の個数の総和を求めよ．

입력
入力は以下の形式で標準入力から与えられる．

N
S
출력
S のうち母音字の個数，つまり a，i，u，e，o の個数の総和を出力せよ．

제한
1 ≦ N ≦ 50.
S は長さ N の文字列である．
S の各文字は英小文字である．
예제 입력 1
8
joiyosen
예제 출력 1
4
母音字は _oi_o_e_ の 4 個である．
예제 입력 2
6
bitaro
예제 출력 2
3
母音字は _i_a_o の 3 個である．
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'a':
                case 'i':
                case 'u':
                case 'e':
                case 'o':
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
