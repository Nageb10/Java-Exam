import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JDBCOps.populate();

        Program p = new Program();

        boolean isPlaying = true;

        while (isPlaying) {
            p.startProgram();

            Scanner sc = new Scanner(System.in);
            System.out.println("Play another round? (yes/no)");

            if (sc.nextLine().equals("no")) {
                isPlaying = false;
                System.out.println("Thank you and goodbye");
            }
        }
    }
}
