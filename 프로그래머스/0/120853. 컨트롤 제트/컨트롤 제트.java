import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(String st : str){
            if(st.equals("Z")){
                stack.pop();
            }
            else stack.push(Integer.parseInt(st));
        }
        
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }
}