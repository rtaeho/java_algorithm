import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> expandedPictureList = new ArrayList<>();
        for (String row : picture) {
            StringBuilder expandedRowBuilder = new StringBuilder();
            
            for (char pixel : row.toCharArray()) {
                for (int i = 0; i < k; i++) {
                    expandedRowBuilder.append(pixel);
                }
            }
            
            String expandedRow = expandedRowBuilder.toString();
            
            for (int i = 0; i < k; i++) {
                expandedPictureList.add(expandedRow);
            }
        }
        return expandedPictureList.toArray(new String[0]);
    }
}