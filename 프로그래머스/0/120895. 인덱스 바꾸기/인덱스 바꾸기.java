class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++){
            if(i == num2){
                sb.append(my_string.charAt(num1));
            }
            else if (i == num1){
                sb.append(my_string.charAt(num2));
            }
            else{
                sb.append(my_string.charAt(i));   
            }
        }
        answer = sb.toString();
        return answer;
    }
}