import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner sc = new Scanner(System.in);
        List<String> answers = new ArrayList<>();
        FileManager fm = new FileManager();
        CLIHelper cliHelper = new CLIHelper(fm);


        boolean cont = true;
        int choice;
        while (cont) {
            cliHelper.mainMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> cliHelper.registerUser(sc);
                case 2 -> cliHelper.printAllUsers();
                case 3 -> cliHelper.addNewQuestion(sc);
                case 4 -> cliHelper.deleteQuestion(sc);
                case 5 -> cliHelper.searchUser(sc);
                case 0 -> {
                    cont = false;
                    System.out.println("Saindo do menu principal..");
                }
                default -> System.out.println("A opção inserida é inválida!");

            }
        }

















    }
}