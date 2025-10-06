import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);

        for (String word : dic) {
            if (word.length() != spell.length) continue;

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            boolean matched = true;
            for (int i = 0; i < spell.length; i++) {
                if (!spell[i].equals(String.valueOf(chars[i]))) {
                    matched = false;
                    break;
                }
            }

            if (matched) return 1;
        }

        return 2;
    }
}