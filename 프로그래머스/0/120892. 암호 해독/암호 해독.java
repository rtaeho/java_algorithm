class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<cipher.length() + 1; i++){
            if(i % code == 0){
                sb.append(cipher.charAt(i-1));
            }
        }
        answer = sb.toString();
        return answer;
    }
}