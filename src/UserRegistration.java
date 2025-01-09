import entities.User;

import java.util.List;

public class UserRegistration {

    public void RegisterUser(List<String> form, List<String> answers) {
        FileManager fileManager = new FileManager();
        User newUser = new User();
            for (int i = 0; i < answers.size(); i++) {
                newUser.setAnswer(form.get(i), answers.get(i));
            }
        fileManager.saveUserArchive(newUser);
        }
        }

