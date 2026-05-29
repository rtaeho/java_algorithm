import java.util.*;

class Solution {
    Set<Integer> set;
    boolean[] visited;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "");
        
        int answer = 0;
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(String str, String current) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                dfs(str, current + str.charAt(i));
                
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if (n < 2){
            return false;  
        }
        
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}