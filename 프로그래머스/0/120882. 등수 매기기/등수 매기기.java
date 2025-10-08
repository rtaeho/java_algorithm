import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        double[] avg = new double[n];
        for (int i = 0; i < n; i++) {
            avg[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        double[] sortedAvg = avg.clone();
        Arrays.sort(sortedAvg); // 오름차순
        
        for (int i = 0; i < n / 2; i++) {
            double temp = sortedAvg[i];
            sortedAvg[i] = sortedAvg[n - 1 - i];
            sortedAvg[n - 1 - i] = temp;
        } // 뒤집기
        
        Map<Double, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        for (int i = 0; i < n; i++) {
            if (!rankMap.containsKey(sortedAvg[i])) {
                rank = i + 1;
                rankMap.put(sortedAvg[i], rank);
            }
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = rankMap.get(avg[i]);
        }
        
        return answer;
    }
}