import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLIHelper {


    private final FileManager fileManager;

    public CLIHelper(FileManager fileManager) {
        this.fileManager = fileManager;
    }


    public void registerUser(Scanner scanner) {
        List<String> form = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        form = printForm();
        for (String questions : form) {
            System.out.println(questions);
            answers.add(scanner.nextLine());
        }
        User user = new User();
        user.setAnswer(String.valueOf(form), answers);
        UserRegistration ur = new UserRegistration();
        ur.RegisterUser(form, answers);
    }

    public void mainMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Listar Todos os Usuários");
        System.out.println("3 - Cadastrar Nova Pergunta no Formulário");
        System.out.println("4 - Deletar Pergunta do Formulário");
        System.out.println("5 - Pesquisar Usuário por Nome, Idade ou Email");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public List<String> printForm() {
        try {
            List<String> form = fileManager.loadForm();
            return form;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printAllUsers() {
        List<String> allUsers = FileManager.loadUsers();
        for (String user : allUsers) {
            System.out.println(user);
        }
    }

    public void addNewQuestion(Scanner scanner) {
        System.out.println("Insira a nova pergunta: ");
        String question = scanner.nextLine();
        FileManager.updateForm(question);

    }
}
