import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class UserRegistration {

    public boolean RegisterUser(List<String> form, List<String> answers) {
        FileManager fileManager = new FileManager();
        User newUser = new User();
            for (int i = 0; i < answers.size(); i++) {
                newUser.setAnswer(form.get(i), answers.get(i));
            }

        userValidate(newUser);
        fileManager.saveUserArchive(newUser);
        return true;
    }

    public static void userValidate(User user) {

        String userName = (String) user.getAnswer("1 - Qual seu nome completo?");
        String userEmail = (String) user.getAnswer("2 - Qual seu email de contato?");
        String userAge = (String) user.getAnswer("3 - Qual sua idade?");
        String userHeight = (String) user.getAnswer("4 - Qual sua altura?");



       if ( userName == null  ||userName.trim().length() < 10 ) {
           throw new UserValidationException("O nome deve ter ao menos 10 caracteres");
       };

        if (userEmail == null  || !userEmail.contains("@")) {
            throw new UserValidationException("O email deve ter ao menos um @");
        }

         List<String> usersEmail = FileManager.loadAllEmails();
        if ( usersEmail.contains(userEmail) ) {
            throw new UserValidationException("O email informado já está cadastrado!");
        }

        if ( parseInt(userAge) <= 18) {
            throw new UserValidationException("O usuário não pode ter menos que 18 anos!");
        }

        if (!Pattern.matches("\\d+,\\d+", userHeight)) {
           throw new UserValidationException("A altura deve estar no formato númerico com vírgula ( , )");
        }




    }

}


