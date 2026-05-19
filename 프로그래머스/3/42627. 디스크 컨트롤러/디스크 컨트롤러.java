import java.util.*;

class Solution {
    class Work{
        int number;
        int requestTime;
        int duration;
        
        public Work(int number, int requestTime, int duration){
            this.number = number;
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Work> waitingPQ = new PriorityQueue<>((a, b) -> {
            if(a.duration == b.duration){
                if(a.requestTime == b.requestTime){
                    return Integer.compare(a.number, b.number);
                }
                return Integer.compare(a.requestTime, b.requestTime);
            }
            return Integer.compare(a.duration, b.duration);
        });
        
        PriorityQueue<Work> requestPQ = new PriorityQueue<>((a,b) ->{
            return Integer.compare(a.requestTime, b.requestTime);
        });
        
        for(int i = 0; i < jobs.length; i++){
            requestPQ.offer(new Work(i + 1, jobs[i][0], jobs[i][1]));
        }
        int answer = 0;
        
        Work job = null;
        int time = requestPQ.peek().requestTime;
        int endTime = -1;
        
        while(!requestPQ.isEmpty() || !waitingPQ.isEmpty() || endTime != -1){
            while(!requestPQ.isEmpty() && requestPQ.peek().requestTime <= time){
                waitingPQ.offer(requestPQ.poll());                
            }
            
            if(time >= endTime && endTime != -1){
                answer += (time - job.requestTime);
                endTime = -1;
            }

            if(endTime == -1 && !waitingPQ.isEmpty()){
                job = waitingPQ.poll();
                endTime = time + job.duration;
            }
            time++;
        }
    
        return answer / jobs.length;
    }
}