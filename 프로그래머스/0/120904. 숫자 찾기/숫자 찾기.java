class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String ns = String.valueOf(num);
        char ks = (char)(k + '0');
        for(int i = 0; i < ns.length(); i++){
            if(ns.charAt(i) == ks){
                return i + 1;
            }
        }
        answer = -1;
        return answer;
    }
}