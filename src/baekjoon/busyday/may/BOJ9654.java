/*
문제
나부 행성의 함대 정보를 출력하는 프로그램을 작성하시오.

출력
나부 행성의 함대의 정보를 아래와 예제 출력과 같은 표로 출력한다.

처음 두 열의 너비는 문자 15개, 세 번째 열은 11개, 마지막 열의 너비는 10개이다.

예제 입력 1
예제 출력 1
SHIP NAME      CLASS          DEPLOYMENT IN SERVICE
N2 Bomber      Heavy Fighter  Limited    21
J-Type 327     Light Combat   Unlimited  1
NX Cruiser     Medium Fighter Limited    18
N1 Starfighter Medium Fighter Unlimited  25
Royal Cruiser  Light Combat   Limited    4
 */
package baekjoon.busyday.may;

public class BOJ9654 {
    public static void main(String[] args) {
        System.out.println("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n" +
                "N2 Bomber      Heavy Fighter  Limited    21        \n" +
                "J-Type 327     Light Combat   Unlimited  1         \n" +
                "NX Cruiser     Medium Fighter Limited    18        \n" +
                "N1 Starfighter Medium Fighter Unlimited  25        \n" +
                "Royal Cruiser  Light Combat   Limited    4");
    }
}
