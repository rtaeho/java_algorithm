class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);

        String reversed_part = sb.substring(s, e + 1);
        
        StringBuilder reversed_sb = new StringBuilder(reversed_part);
        reversed_sb.reverse();
        sb.replace(s, e + 1, reversed_sb.toString());

        return sb.toString();
    }
}