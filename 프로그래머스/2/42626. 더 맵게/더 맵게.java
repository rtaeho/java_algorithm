import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int val : scoville){
            pq.offer(val);
        }
        int cnt = 0;
        
        while(pq.size() > 1){
            int first = pq.poll();
            if(first >= K){
                pq.offer(first);
                break;
            }
            int second = pq.poll();
            pq.offer(first + second * 2);
            cnt++;
        }
        if(pq.peek() < K){
            return -1;
        }
        else{
            return cnt;
        }
    }
}