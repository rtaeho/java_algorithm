import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        ()는 2
        []는 3
        (X)는 2 * X
        [X]는 3 * X
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        int result = 0;
        int temp = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            }
            else if (c == ')'){
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    if(input.charAt(i - 1) == '('){
                        result += temp;
                    }
                    temp /= 2;
                } else {
                    System.out.println(0);
                    return;
                }
            }
            else{
                if(!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    if (input.charAt(i - 1) == '['){
                        result += temp;
                    }
                    temp /= 3;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
            return;
        }
        System.out.println(result);


    }
}