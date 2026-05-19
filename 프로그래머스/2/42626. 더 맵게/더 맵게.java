import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a, b);
        });
        for(int value : scoville){
            pq.offer(value);
        }
        int answer = 0;
        
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                int last = pq.poll();
                return last < K ? -1 : answer;
            }
            if(pq.peek() < K){
                answer++;
                int first = pq.poll();
                int second = pq.poll();
                pq.offer(first + second * 2);
            }
            else{
                break;
            }
        }

        return answer;
    }
}