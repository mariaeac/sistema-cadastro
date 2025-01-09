import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final static String FORM_FILE_PATH = "src/files/formulario.txt";
    private final static String COUNTER_FILE_PATH = "src/files/counter.txt";
    protected final static String USERS_DIR = "src/files/users";


    // Carrega o formulário
    public static List<String> loadForm() {
        List<String> formLines = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(FORM_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                formLines.add(line);
            }
            return formLines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Salva um novo usuário
    public void saveUserArchive(User user) {
        String archiveName = generateArchiveName((String) user.getAnswer("1 - Qual seu nome completo?"));
        String archivePath = "src/files/users/" + archiveName;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivePath))) {
            for (var e : user.getAllAnswers().entrySet()) {
                bw.write(e.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }

        updateCounterNumber();
    }

    // Gera o nome do arquivo
    public static String generateArchiveName(String name) {
        int counter = getCounterNumber();
        String userName = name.replace(" ", "").toUpperCase();
        return counter + "-" + userName + ".txt";
    }

    public static Integer getCounterNumber() {
        try (BufferedReader br = new BufferedReader(new FileReader(COUNTER_FILE_PATH)) ) {
            String strNum = br.readLine();
            return Integer.parseInt(strNum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateCounterNumber() {
        Integer counter = getCounterNumber();
        try (FileWriter fw = new FileWriter(COUNTER_FILE_PATH, false)) {
            fw.write(String.valueOf(counter + 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> loadUsers() {
        List<String> users = new ArrayList<>();
        File usersDir = new File(USERS_DIR);
        String[] archives = usersDir.list();
        for (String archive : archives) {
            String userName = archive.substring(0, archive.lastIndexOf("."));
            users.add(userName);
        }
        return users;
    }

    public static void updateForm(String newQuestion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FORM_FILE_PATH, true))) {
            List<String> form = loadForm();
            int questionCounter = form.size() + 1;
            bw.write(questionCounter + " -" + newQuestion + "\n");
            System.out.println("Pergunta adicionada com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFormAnswer(List<String> form) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FORM_FILE_PATH))) {
            for (int i = 0; i < form.size(); i++) {
                bw.write((i + 1) + " - " + form.get(i).split("-", 2)[1].trim() + "\n");
            }
            System.out.println("Pergunta deletada com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchUser(String[] archives, String searchTerm) {

        boolean found = false;

        for (String archive : archives) {
            try (BufferedReader br = new BufferedReader(new FileReader(USERS_DIR + "/" +  archive))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.toLowerCase().contains(searchTerm.toLowerCase())) {
                        System.out.println("Termo encontrado no arquivo: " + archive);
                        found = true;
                        break;
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (!found) {
            System.out.println("Nenhum usuário encontrado com o termo informado");
        }
    }





}
