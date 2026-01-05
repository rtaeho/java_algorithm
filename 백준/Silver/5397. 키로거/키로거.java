import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }

            StringBuilder temp = new StringBuilder();
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                temp.append(right.pop());
            }
            sb.append(temp).append("\n");
        }
        System.out.print(sb.toString());
    }
}