import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>((a, b) ->{
            return b - a;
        });
        for(String s : operations){
            String[] str = s.split(" ");
            String command = str[0];
            int num = Integer.valueOf(str[1]);
            if(command.equals("I")){
                set.add(num);
            }
            else{
                if(!set.isEmpty()){
                    if(num == 1){
                        set.pollFirst();
                    }
                    else{
                        set.pollLast();
                    }
                }
            }
        }
        if(set.isEmpty()){
            return new int[]{0, 0};
        }
        else{
            return new int[]{set.first(), set.last()};
        }
    }
}