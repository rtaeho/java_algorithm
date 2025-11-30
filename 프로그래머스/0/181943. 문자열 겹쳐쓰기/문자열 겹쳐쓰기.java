class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String prefix = my_string.substring(0, s);
        
        String middle = overwrite_string;

        int end = s + overwrite_string.length();
        String suffix = my_string.substring(end);
        
        String answer = prefix + middle + suffix;
        
        return answer;
    }
}