import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> b - a);

        Deque<Integer> deque = new ArrayDeque<>();

        boolean turn = true; // true가 왼쪽

        for (int i : arr) {
            if (i < 0) {
                if (turn) {
                    deque.addLast(i);
                } else {
                    deque.addFirst(i);
                }
                turn = !turn;
            } else {
                if (turn) {
                    deque.addFirst(i);
                } else {
                    deque.addLast(i);
                }
            }
            turn = !turn;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}
