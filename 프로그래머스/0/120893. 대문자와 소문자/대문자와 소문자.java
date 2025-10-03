class Solution {
    public String solution(String my_string) {
        String answer = "";
        answer = inverse(my_string);
        return answer;
    }
    private String inverse(String str){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if('a' <= c && c <= 'z'){
               sb.append((char)(c - 'a' + 'A'));
            }
            else sb.append((char)(c + 'a' - 'A'));
        }
        return sb.toString();
    }
}