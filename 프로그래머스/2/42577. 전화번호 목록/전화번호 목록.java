import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        String temp = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(temp)){
                return false;                
            }
            temp = phone_book[i];
        }
        
        return true;
    }
}