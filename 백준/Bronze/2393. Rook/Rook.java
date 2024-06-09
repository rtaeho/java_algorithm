/*
문제
You have just learned how to output text to the screen and your teacher has challenged you to create an ASCII art of a chess piece. You have decided to make your favorite piece, the rook.

출력
The rook art, exactly as shown below, with no extra blank spaces. In particular, a line must not end with a blank space.

예제 입력 1
예제 출력 1
  ___  ___  ___
  | |__| |__| |
  |           |
   \_________/
    \_______/
     |     |
     |     |
     |     |
     |     |
     |_____|
  __/       \__
 /             \
/_______________\
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("  ___  ___  ___\n" +
                "  | |__| |__| |\n" +
                "  |           |\n" +
                "   \\_________/\n" +
                "    \\_______/\n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |     |\n" +
                "     |_____|\n" +
                "  __/       \\__\n" +
                " /             \\\n" +
                "/_______________\\");
    }
}
