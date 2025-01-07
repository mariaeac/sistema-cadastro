import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileManager fm = new FileManager();
        CLIHelper cliHelper = new CLIHelper(fm);

        cliHelper.printForm();



    }
}