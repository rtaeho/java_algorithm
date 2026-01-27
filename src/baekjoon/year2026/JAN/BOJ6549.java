package baekjoon.year2026.JAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6549 {
    public static void main(String[] args) throws IOException {
        // 1. 분할정복
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            int[] histogram = new int[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(getArea(histogram, 0, n - 1));
        }

        // 2. 스택
    }
    // 넓이 구하는 메서드
    public static long getArea(int[] histogram, int left, int right) {
        if (left == right) { // 블럭 하나
            return histogram[left];
        }

        int mid = (left + right) / 2; // 중간

        // 좌우 탐색
        long leftArea = getArea(histogram, left, mid);
        long rightArea = getArea(histogram, mid + 1, right);

        long maxArea = Math.max(leftArea, rightArea);

        // 중간을 포함한 넓이와 비교 단일 블럭이 클 수도 있지만 중간 포함한 게 클 수도 있음
        return Math.max(maxArea, getCrossArea(histogram, left, right, mid));
    }

    // 중간 포함 넓이 계산 메서드
    public static long getCrossArea(int [] histogram, int left, int right, int mid) {
        // 중간에서부터 좌우로 확장
        int toLeft = mid;
        int toRight = mid;

        // 초기 높이
        long height = histogram[mid];

        // 넓이
        long maxArea = height;

        while (toLeft > left && toRight < right) { // 인덱스 벗어나기 전
            // 오른쪽 높이가 클 경우 오른쪽으로 확장
            if (histogram[toLeft - 1] < histogram[toRight + 1]) {
                toRight++;
                height = Math.min(height, histogram[toRight]); // 높이는 작은 값으로
            }
            // 왼쪽으로 확장
            else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }
        // 한 쪽 끝에 먼저 도달한 경우 나머지도 탐색
        while (toLeft > left) {
            toLeft--;
            height = Math.min(height, histogram[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < right) {
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
