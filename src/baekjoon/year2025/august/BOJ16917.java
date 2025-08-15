/*
 * 문제
 * 현진 치킨에서 판매하는 치킨은 양념 치킨, 후라이드 치킨, 반반 치킨으로 총 세 종류이다. 반반 치킨은 절반은 양념 치킨, 절반은 후라이드
 * 치킨으로 이루어져있다. 양념 치킨 한 마리의 가격은 A원, 후라이드 치킨 한 마리의 가격은 B원, 반반 치킨 한 마리의 가격은 C원이다.
 * 
 * 상도는 오늘 파티를 위해 양념 치킨 최소 X마리, 후라이드 치킨 최소 Y마리를 구매하려고 한다. 반반 치킨을 두 마리 구입해 양념 치킨
 * 하나와 후라이드 치킨 하나를 만드는 방법도 가능하다. 상도가 치킨을 구매하는 금액의 최솟값을 구해보자.
 * 
 * 입력
 * 첫째 줄에 다섯 정수 A, B, C, X, Y가 주어진다.
 * 
 * 출력
 * 양념 치킨 최소 X마리, 후라이드 치킨 최소 Y마리를 구매하는 비용의 최솟값을 출력한다.
 * 
 * 제한
 * 1 ≤ A, B, C ≤ 5,000
 * 1 ≤ X, Y ≤ 100,000
 * 예제 입력 1
 * 1500 2000 1600 3 2
 * 예제 출력 1
 * 7900
 * 반반 치킨 4마리를 구매해서, 양념 치킨 2마리와 후라이드 치킨 2마리를 만들고, 양념 치킨 1마리를 구매하는 것이 최소이다.
 * 
 * 예제 입력 2
 * 1500 2000 1900 3 2
 * 예제 출력 2
 * 8500
 * 예제 입력 3
 * 1500 2000 500 90000 100000
 * 예제 출력 3
 * 100000000
 */

 package baekjoon.year2025.august;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ16917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken()); // 양념 치킨 가격
        int B = Integer.parseInt(st.nextToken()); // 후라이드 치킨 가격
        int C = Integer.parseInt(st.nextToken()); // 반반 치킨 가격
        int X = Integer.parseInt(st.nextToken()); // 필요한 양념 치킨 수
        int Y = Integer.parseInt(st.nextToken()); // 필요한 후라이드 치킨 수
        
        long minCost = Long.MAX_VALUE;
        
        // 반반 치킨을 0개부터 max(X, Y) * 2개까지 시도
        for (int half = 0; half <= Math.max(X, Y) * 2; half += 2) {
            // 반반 치킨으로 얻을 수 있는 치킨 수
            int halfChicken = half / 2;
            
            // 추가로 필요한 치킨 수
            int needA = Math.max(0, X - halfChicken);
            int needB = Math.max(0, Y - halfChicken);
            
            // 총 비용 계산
            long totalCost = (long) half * C + (long) needA * A + (long) needB * B;
            
            minCost = Math.min(minCost, totalCost);
        }
        
        System.out.println(minCost);
        br.close();
    }
}