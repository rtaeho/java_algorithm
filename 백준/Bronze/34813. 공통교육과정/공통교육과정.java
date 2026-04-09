import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        char type = code.charAt(0);

        if (type == 'F') {
            System.out.println("Foundation");
        } else if (type == 'C') {
            System.out.println("Claves");
        } else if (type == 'V') {
            System.out.println("Veritas");
        } else if (type == 'E') {
            System.out.println("Exploration");
        }
    }
}