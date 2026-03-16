import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 시각 입력
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        
        // 요리 시간(초) 입력
        int d = sc.nextInt();

        // 1. 모든 시간을 '초' 단위로 통합
        int totalSec = h * 3600 + m * 60 + s + d;

        // 2. 다시 시, 분, 초로 변환
        // 초는 60으로 나눈 나머지
        int resS = totalSec % 60;
        
        // 분은 전체 초를 60으로 나눈 뒤, 그 값을 다시 60으로 나눈 나머지
        int resM = (totalSec / 60) % 60;
        
        // 시는 전체 초를 3600으로 나눈 뒤, 24시가 넘어가면 0부터 시작하므로 24로 나눈 나머지
        int resH = (totalSec / 3600) % 24;

        // 결과 출력
        System.out.println(resH + " " + resM + " " + resS);
        
        sc.close();
    }
}