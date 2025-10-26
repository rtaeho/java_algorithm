import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n); // 초기값 추가

        while (n != 1) {
            // 짝수면 2로 나누고, 홀수면 3n + 1
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            list.add(n); // 결과 추가
        }

        // ArrayList를 int 배열로 변환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
