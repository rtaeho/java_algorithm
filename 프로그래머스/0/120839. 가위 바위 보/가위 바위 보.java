class Solution {
    public String solution(String rsp) {
        String answer = "";
        StringBuilder st = new StringBuilder();
        for (char n : rsp.toCharArray()){
            if (n == '2') st.append("0");
            else if (n == '0') st.append("5");
            else st.append("2");
        }
        answer = st.toString();
        return answer;
    }
}