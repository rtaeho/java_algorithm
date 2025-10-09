import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜
        // 약관 기간
        // 약관 가입 날짜 + 약관 종류
        // 우선 약관 가입 날짜 + 약관 종류를 달로 변환해서 파기일을 구함
        // 파기일과 오늘 날짜를 비교
        String[] now = today.split("\\.");
        int nowYear = Integer.parseInt(now[0]);
        int nowMonth = Integer.parseInt(now[1]);
        int nowDate = Integer.parseInt(now[2]);
        
        List<Integer> list = new ArrayList<>();
        
        Map<String, Integer> period = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] temp = terms[i].split(" ");
            period.put(temp[0], Integer.parseInt(temp[1]));
        }
        int n = privacies.length;
        String[] expired = new String[n];
        
        for(int i = 0; i < n; i++){
            String[] temp = privacies[i].split(" ");
            int month = period.get(temp[1]);
            temp = temp[0].split("\\.");
            int expiredYear = Integer.parseInt(temp[0]);
            int expiredMonth = Integer.parseInt(temp[1]);
            int expiredDay = Integer.parseInt(temp[2]);
            
            // 2018 12 28
            expiredMonth += month;
            // 2018 17 28
            expiredYear += (expiredMonth - 1) / 12;
            expiredMonth = (expiredMonth - 1) % 12 + 1;
            
            expiredDay -= 1;
            
            if(expiredDay == 0){
                expiredDay = 28;
                expiredMonth--;
                if(expiredMonth == 0){
                    expiredMonth = 12;
                    expiredYear--;
                }
            }
            
                
            System.out.println("expiredYear : " + expiredYear);
            System.out.println("expiredMonth : "+  expiredMonth);
            System.out.println("expiredDay : " + expiredDay);
            System.out.println("nowYear : " + nowYear);
            System.out.println("nowMonth : " + nowMonth);
            System.out.println("nowDate : " + nowDate);
            if(nowYear > expiredYear || // 년도 비교
               (nowYear == expiredYear) && (nowMonth > expiredMonth) || // 월 비교
              (nowYear == expiredYear) && (nowMonth == expiredMonth) 
               && (nowDate > expiredDay)) { // 일 비교
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}