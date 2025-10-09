import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int m = gifts.length;
        
        int[][] previousGift = new int[n][n]; // 선물 기록
        Map<String,Integer> nameToIdx = new HashMap<>(); // 이름 인덱스
        int[] giftPoint = new int[n]; // 선물 지수
        
        // 이름 인덱스 매핑
        for(int i = 0; i < n; i++){
            nameToIdx.put(friends[i], i);
        }
        
        // 선물 기록 작성
        for(int i = 0; i < m; i++){
            String[] temp = gifts[i].split(" ");
            int from = nameToIdx.get(temp[0]);
            int to = nameToIdx.get(temp[1]);
            previousGift[from][to]++; // 주고받은 선물 계산
            giftPoint[from]++; // 선물 지수 계산
            giftPoint[to]--;
        }
        printArr(giftPoint);
        System.out.println();
        System.out.println();
        
        printArr(previousGift);
        System.out.println();
        int[] nextMonthGift = new int[n]; // 다음 달 받을 선물
        
        // 서로 주고받은 선물 계산
        for(int i = 0; i < n; i++){
           for(int j = i; j < n; j++){
               if (previousGift[i][j] > previousGift[j][i]){
                   // i가 j에게 더 많이 준 경우 j가 i에게 선물
                   nextMonthGift[i]++;
               }
               else if(previousGift[i][j] < previousGift[j][i]){
                   // j가 i에게 더 많이 준 경우 i가 j에게 선물
                   nextMonthGift[j]++;
               }
               else{
                   // 같은 경우
                   if(giftPoint[i] > giftPoint[j]){
                       nextMonthGift[i]++;
                   }
                   else if(giftPoint[i] < giftPoint[j]){
                       nextMonthGift[j]++;
                   }
               }
           }
        }
        printArr(nextMonthGift);
        List<Integer> nextMonthGiftList = new ArrayList<>();
        for(int gift : nextMonthGift){
            nextMonthGiftList.add(gift);
        }
        Collections.sort(nextMonthGiftList, (a, b) -> {
            return b - a;
        });
        // printList(nextMonthGiftList);
        
        answer = nextMonthGiftList.get(0);
        return answer;
    }
    
    private void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    private void printArr(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private void printList(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
