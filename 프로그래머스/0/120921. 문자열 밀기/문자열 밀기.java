class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int n = A.length();
        
        if(A.equals(B)) return 0;
        
        while(answer < n){
            A = rotate(A);
            answer++;
            if(A.equals(B)) return answer;
        }
        return -1;
    }
    private String rotate(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(str.length()-1));
        for(int i = 0; i<str.length()-1; i++){
            sb.append(str.charAt(i));
        }
        
        return sb.toString();
    }
}