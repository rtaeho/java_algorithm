import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int youngsikTotalCost = 0;
        int minsikTotalCost = 0;

        for (int i = 0; i < N; i++) {
            int T = Integer.parseInt(st.nextToken());

            youngsikTotalCost += (T / 30 + 1) * 10;

            minsikTotalCost += (T / 60 + 1) * 15;
        }

        if (youngsikTotalCost < minsikTotalCost) {
            System.out.println("Y " + youngsikTotalCost);
        } else if (minsikTotalCost < youngsikTotalCost) {
            System.out.println("M " + minsikTotalCost);
        } else {
            System.out.println("Y M " + youngsikTotalCost);
        }
    }
}