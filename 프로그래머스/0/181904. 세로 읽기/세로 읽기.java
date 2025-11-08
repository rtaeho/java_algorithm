class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
    
        int startIndex = c - 1; 

        for (int i = startIndex; i < my_string.length(); i += m) {
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}