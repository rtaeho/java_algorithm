import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> indicesToRemove = new HashSet<>();
        for (int index : indices) {
            indicesToRemove.add(index);
        }
        StringBuilder sb = new StringBuilder();
        int n = my_string.length();

        for (int i = 0; i < n; i++) {
            if (!indicesToRemove.contains(i)) {
                sb.append(my_string.charAt(i));
            }
        }

        return sb.toString();
    }
}