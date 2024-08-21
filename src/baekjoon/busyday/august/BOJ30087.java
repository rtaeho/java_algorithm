/*
문제
한국정보기술진흥원에서는 다양한 세미나가 열린다.

전문가를 위한 알고리즘, 데이터분석, 인공지능, 사이버보안, 네트워크 세미나뿐만 아니라 예비 창업가를 위한 창업 세미나, 그리고 청소년들을 위한 입시 세미나가 열린다.

오늘은 위
$7$개 주제의 세미나가 모두 열리는 날이다. 진흥이는 이 중
$N$ (
$1 \le N \le 7$) 개의 세미나를 신청했다. 아래의 표를 보고 어느 교실에서 열리는지 알아보자.

세미나	교실
Algorithm	204
DataAnalysis	207
ArtificialIntelligence	302
CyberSecurity	B101
Network	303
Startup	501
TestStrategy	105
입력
첫 번째 줄에 진흥이가 신청한 세미나의 수
$N$이 주어진다.

두 번째 줄부터
$N$개의 줄에 진흥이가 신청한 세미나의 목록이 주어진다. 세미나는 지문의 표에 있는
$7$개 중 하나로 주어지며, 중복되는 세미나는 없다.

출력
 
$N$개의 줄에 걸쳐서 각 세미나가 어느 교실에서 열리는지 한 줄에 하나씩 출력한다.

예제 입력 1
4
Algorithm
Network
CyberSecurity
Startup
예제 출력 1
204
303
B101
501
예제 입력 2
2
Network
Algorithm
예제 출력 2
303
204
 */
package baekjoon.busyday.august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ30087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            if (a.equals("Algorithm")) {
                System.out.println("204");
            } else if (a.equals("DataAnalysis")) {
                System.out.println("207");
            } else if (a.equals("ArtificialIntelligence")) {
                System.out.println("302");
            } else if (a.equals("CyberSecurity")) {
                System.out.println("B101");
            } else if (a.equals("Network")) {
                System.out.println("303");
            } else if (a.equals("Startup")) {
                System.out.println("501");
            } else if (a.equals("TestStrategy")) {
                System.out.println("105");
            }
        }
        br.close();
    }
}
