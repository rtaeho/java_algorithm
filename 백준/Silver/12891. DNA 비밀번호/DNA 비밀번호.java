import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int answer = 0;

        int as = 0, cs = 0, gs = 0, ts = 0;
        char[] dna = str.toCharArray();

        for (int i = 0; i < P; i++) {
            if (dna[i] == 'A') as++;
            else if (dna[i] == 'C') cs++;
            else if (dna[i] == 'G') gs++;
            else if (dna[i] == 'T') ts++;
        }
        if (as >= A && cs >= C && gs >= G && ts >= T) answer++;

        for (int i = P; i < S; i++) {
            char add = dna[i];
            if (add == 'A') as++;
            else if (add == 'C') cs++;
            else if (add == 'G') gs++;
            else if (add == 'T') ts++;

            char remove = dna[i - P];
            if (remove == 'A') as--;
            else if (remove == 'C') cs--;
            else if (remove == 'G') gs--;
            else if (remove == 'T') ts--;

            if (as >= A && cs >= C && gs >= G && ts >= T) answer++;
        }
        System.out.println(answer);
    }
}