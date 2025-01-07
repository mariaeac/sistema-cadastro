import java.util.List;

public class CLIHelper {


    private final FileManager fileManager;

    public CLIHelper(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void printForm() {
        try {
           List<String> form = fileManager.loadForm();
           form.forEach(System.out::println);
        } catch (RuntimeException e) {
            System.out.println("Erro ao carregar o arquivo:" + e.getMessage());
        }
    }

}
