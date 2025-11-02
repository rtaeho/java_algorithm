class Solution {
    public int solution(String binomial) {
        long answer = 0;
        String[] parts = binomial.split("\\s");
        
        long a = Long.parseLong(parts[0]);
        long b = Long.parseLong(parts[2]);
        
        String op = parts[1];
        
        if (op.equals("+")) {
            answer = a + b;
        } else if (op.equals("-")) {
            answer = a - b;
        } else if (op.equals("*")) {
            answer = a * b;
        }
        
        return (int)answer;
    }
}