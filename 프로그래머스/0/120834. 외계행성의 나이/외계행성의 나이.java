class Solution {
    public String solution(int age) {
        String answer = "";
        String as = String.valueOf(age);
        StringBuilder sb = new StringBuilder();
        for(char c : as.toCharArray()){
            sb.append((char)(c - '0' + 'a'));
        }
        answer = sb.toString();
        return answer;
    }
}