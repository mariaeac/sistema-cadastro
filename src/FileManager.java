import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final static String FORM_FILE_PATH = "src/files/formulario.txt";


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
}
