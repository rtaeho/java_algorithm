class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            answer[i] = check(quiz[i]);
        }
        return answer;
    }
    
    private String check(String expression){
        int result;

        String[] str = expression.split(" ");
        // 3, -, 4, =, -3
        int X = Integer.parseInt(str[0]);
        String operator = str[1];
        int Y = Integer.parseInt(str[2]);
        int Z = Integer.parseInt(str[4]);
        
        if(operator.equals("+")){
            result = X + Y;
        } else {
            result = X - Y;
        }
        
        return result == Z ? "O" : "X";
    }
}