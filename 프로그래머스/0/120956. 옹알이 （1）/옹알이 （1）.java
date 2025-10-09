class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSay = new String[]{"aya", "ye", "woo", "ma" };
        for(String str : babbling){
            for(int i = 0; i < 4; i++){
                str = str.replace(canSay[i], " ");
            }
            str = str.replace(" ", "");
            if(str.isEmpty()) answer ++;
        }
        return answer;
    }
}