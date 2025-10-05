class Solution {
    public int solution(String my_string) {
                String[] str = my_string.split(" ");
        int answer = Integer.parseInt(str[0]);
        
        for (int i = 1; i < str.length; i += 2) {
            String op = str[i];
            int num = Integer.parseInt(str[i + 1]);
            
            if (op.equals("+")) {
                answer += num;
            } else if (op.equals("-")) {
                answer -= num;
            }
        }
        return answer;
    }
}