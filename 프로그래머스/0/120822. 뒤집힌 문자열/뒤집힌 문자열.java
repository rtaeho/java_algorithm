class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuffer st = new StringBuffer(my_string);
        answer = st.reverse().toString();
        return answer;
    }
}