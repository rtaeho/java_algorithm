import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            if (input.equals("end")) {
                break;
            }

            if (input.equals("animal")) {
                System.out.println("Panthera tigris");
            } else if (input.equals("tree")) {
                System.out.println("Pinus densiflora");
            } else if (input.equals("flower")) {
                System.out.println("Forsythia koreana");
            }
        }

        sc.close();
    }
}