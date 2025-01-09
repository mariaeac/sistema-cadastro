import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> answers = new ArrayList<>();
        FileManager fm = new FileManager();
        CLIHelper cliHelper = new CLIHelper(fm);

        cliHelper.mainMenu();
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> cliHelper.registerUser(sc);
        }











    }
}