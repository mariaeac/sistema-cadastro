import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> answers = new ArrayList<>();
        FileManager fm = new FileManager();
        CLIHelper cliHelper = new CLIHelper(fm);

        List<String> form = new ArrayList<>();
        form = cliHelper.printForm();

        for (String questions : form ) {
            System.out.println(questions);
            answers.add(sc.nextLine());
        }

        User newUser = new User(answers.get(0), answers.get(1), Integer.parseInt(answers.get(2)), Double.parseDouble(answers.get(3)));
        fm.saveUserArchive(newUser);
        System.out.println(newUser);







    }
}