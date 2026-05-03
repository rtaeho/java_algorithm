import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int day = remaining / speeds[i];
            if (remaining % speeds[i] != 0) {
                day++;
            }
            days.add(day);
        }

        while (!days.isEmpty()) {
            int currentDay = days.poll();
            int count = 1;

            while (!days.isEmpty() && days.peek() <= currentDay) {
                days.poll();
                count++;
            }

            result.add(count);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}