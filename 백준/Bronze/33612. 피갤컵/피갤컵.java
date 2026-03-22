import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int year = 2024;
        int month = 8;

        for (int i = 1; i < N; i++) {
            month += 7;
            if (month > 12) {
                year += (month - 1) / 12;
                month = (month - 1) % 12 + 1;
            }
        }

        System.out.println(year + " " + month);
    }
}