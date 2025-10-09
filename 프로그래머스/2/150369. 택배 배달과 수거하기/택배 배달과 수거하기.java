class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int toDeliver = 0;
        int toPickup = 0;
        
        for(int i = n - 1; i >= 0; i--){
            toDeliver += deliveries[i];
            toPickup += pickups[i];
            
            int repeat = 0;
            while(toDeliver > 0 || toPickup > 0){
                toDeliver -= cap;
                toPickup -= cap;
                repeat++;
            }
            
            answer += (i + 1) * 2 * repeat;
        }
        
        return answer;
    }
}