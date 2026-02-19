import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 파일 개수 N 입력
        int n = sc.nextInt();
        
        // 2. 파일 이름들을 담을 배열 선언 및 입력
        String[] files = new String[n];
        for (int i = 0; i < n; i++) {
            files[i] = sc.next();
        }

        // 3. 첫 번째 파일 이름을 기준으로 패턴 만들기 (StringBuilder 활용)
        StringBuilder pattern = new StringBuilder(files[0]);

        // 4. 나머지 파일들과 비교 (두 번째 파일부터 마지막까지)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < pattern.length(); j++) {
                // 패턴의 j번째 글자와 현재 파일의 j번째 글자가 다르면 '?'로 변경
                if (pattern.charAt(j) != files[i].charAt(j)) {
                    pattern.setCharAt(j, '?');
                }
            }
        }

        // 5. 최종 패턴 출력
        System.out.println(pattern.toString());
        
        sc.close();
    }
}