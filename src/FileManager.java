import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final static String FORM_FILE_PATH = "src/files/formulario.txt";
    private final static String COUNTER_FILE_PATH = "src/files/counter.txt";


    // Carrega o formulário
    public List<String> loadForm() {
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



}
