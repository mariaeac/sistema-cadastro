import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {

    private final static String FORM_FILE_PATH = "src/files/formulario.txt";
    private final static String COUNTER_FILE_PATH = "src/files/counter.txt";
    protected final static String USERS_DIR = "src/files/users/";


    public static List<String> loadForm() {
        List<String> formLines = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(FORM_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                formLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao carregar o formulário: " + e.getMessage());
        }

        return formLines;
    }

    public void saveUserArchive(User user) {
        String userName = (String) user.getAnswer("1 - Qual seu nome completo?");
        String archiveName = generateArchiveName(userName);
        String archivePath = "src/files/users/" + archiveName;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivePath))) {
            for (var e : user.getAllAnswers().entrySet()) {
                bw.write(e.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
        System.out.println("Usuário " + userName + " salvo com sucesso!");
        updateCounterNumber();
    }

    // Gera o nome do arquivo
    public static String generateArchiveName(String name) {
        int counter = getCounterNumber();
        String userName = name.replace(" ", "").toUpperCase();
        return counter + "-" + userName + ".txt";
    }

    public static Integer getCounterNumber() {
        String strNum = "";
        try (BufferedReader br = new BufferedReader(new FileReader(COUNTER_FILE_PATH)) ) {
            strNum = br.readLine();
        } catch (IOException e) {
           System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return Integer.parseInt(strNum);

    }

    public static void updateCounterNumber() {
        Integer counter = getCounterNumber();
        try (FileWriter fw = new FileWriter(COUNTER_FILE_PATH, false)) {
            fw.write(String.valueOf(counter + 1));
        } catch (IOException e) {
           System.out.println("Erro ao atualizar o contador: " + e.getMessage());
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
            bw.write(questionCounter + " - " + newQuestion + "\n");
            System.out.println("Pergunta adicionada com sucesso!");
        } catch (IOException e) {
           System.out.println("Erro ao atualizar o formulário: " + e.getMessage());
        }
    }

    public static void deleteFormAnswer(List<String> form) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FORM_FILE_PATH))) {
            for (int i = 0; i < form.size(); i++) {
                bw.write((i + 1) + " - " + form.get(i).split("-", 2)[1].trim() + "\n");
            }
            System.out.println("Pergunta deletada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao deletar pergunta do formulário: " + e.getMessage());
        }
    }

   public static List<File> searchUser(File[] files, String searchTerm ) {
       List<File> matchingFiles = new ArrayList<>();

       if (files != null) {
           for (File file : files) {
               try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                   String line;
                   while ((line = br.readLine()) != null) {
                       if (line.toLowerCase().contains(searchTerm.toLowerCase())) {
                           matchingFiles.add(file);
                           break;
                       }
                   }
               } catch (Exception e) {
                   System.out.println("Erro ao ler arquivo: " + e.getMessage());
               }
           }
           return matchingFiles;
       }
       return matchingFiles;
   }

   public static void getUsersDetails(File userFiles) {

        try (BufferedReader br = new BufferedReader(new FileReader(userFiles))) {
          System.out.println("Detalhes do usuário: " + userFiles.getName());
          String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

   }

   public static List<String> loadAllEmails() {
       List<String> emails = new ArrayList<>();
       File usersDir = new File(USERS_DIR);
       File[] archives = usersDir.listFiles();
       for (File archive : archives) {
           try (BufferedReader br = new BufferedReader(new FileReader(archive))){
               br.readLine();
               String userEmail = br.readLine();
               emails.add(userEmail);
           } catch (IOException e) {
               System.out.println("Erro ao ler arquivo: " + e.getMessage());
           }
       }
       return emails;
   }





}
