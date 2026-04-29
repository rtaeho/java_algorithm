import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int r = nums.length / 2;
        int n = set.size();
        int answer = Math.min(r, n);
        return answer;
    }
}