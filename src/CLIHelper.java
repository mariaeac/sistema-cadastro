import java.util.List;

public class CLIHelper {


    private final FileManager fileManager;

    public CLIHelper(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public List<String> printForm() {
        try {
           List<String> form = fileManager.loadForm();
           return form;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
