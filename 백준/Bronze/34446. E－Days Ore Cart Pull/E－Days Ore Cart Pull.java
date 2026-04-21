import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        br.readLine();
        br.readLine();
        
        System.out.println(m * 2);
    }
}