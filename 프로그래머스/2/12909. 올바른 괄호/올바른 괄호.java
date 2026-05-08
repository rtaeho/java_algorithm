class Solution {
    boolean solution(String s) {
        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }
}