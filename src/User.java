import java.util.LinkedHashMap;
import java.util.Map;

public class User {
   private Map<String, Object> answers;

   public User() {
       this.answers = new LinkedHashMap<>();

   }

   public void setAnswer(String question, Object answer) {
       this.answers.put(question, answer);
   }
   public Object getAnswer(String question) {
       return this.answers.get(question);
   }

   public Map<String, Object> getAllAnswers() {
       return this.answers;
   }


}
