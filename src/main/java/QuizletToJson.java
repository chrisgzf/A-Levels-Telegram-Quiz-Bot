import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 1/9/16.
 */
public class QuizletToJson {

    public static void main(String[] args) throws IOException {
        List<String> inputQuestions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please drag and drop or paste the file location of the exported Quizlet File into this Window:");
        //String fileLocation = br.readLine();
        String fileLocation = "/Users/chris/IDEA Projects/A-Levels-Telegram-Quiz-Bot/src/main/resources/9646_modern-physics";

        try {
            inputQuestions = IOUtils.readLines(new FileInputStream(fileLocation), "US-ASCII");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Name of this question set:");
        String questionSetName = "a";
        System.out.println("Author of this question set:");
        String authorName = "b";

        QuestionSet questionSet = new QuestionSet(questionSetName, authorName);

        for (String question : inputQuestions)
        {
            String term = question.substring(0, question.indexOf("\t"));
            String definition = question.substring(question.indexOf("\t") + 1);
            questionSet.getQuestions().add(new QuizQuestion(term, definition));
        }

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        OutputStream output = new FileOutputStream(authorName + "_" + questionSetName + ".json");
        IOUtils.write(gson.toJson(questionSet), output, "US-ASCII");
    }
}
