/*
문제
서울의   오늘 날짜를 출력하는 프로그램을 작성하시오.

입력
입력은 없다.

출력
서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.

예제 입력 1
예제 출력 1
2015-01-24
 */
package baekjoon.busyday.may;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BOJ10699 {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println(df.format(date));
    }
}
