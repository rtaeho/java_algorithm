import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for(String s : phone_book){
            set.add(s);
        }
        
        for(String s : phone_book){
            for(int i = 1; i < s.length(); i++){
                String tmp = s.substring(0, i);
                if(set.contains(tmp)){
                    return false;
                }
            }
        }
        
        return true;
    }
}