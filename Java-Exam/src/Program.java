import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

    public ArrayList<String> menu;
    public ArrayList<String> arrayUsername;

    public String name;
    public String topic;

    HashMap<String, String> topics = new HashMap<>();

    public Program(){
        topics.put("A", "Football (Multiplechoice quiz)");
        topics.put("B", "Basketball (Binary quiz)");
    }

    public void startProgram() throws IllegalStateException{
        Scanner sc = new Scanner(System.in);

        username();
        name = sc.nextLine();

        System.out.println("Choose topic");
        System.out.format("%s\n%s\n", "A: " + topics.get("A"), "B: " + topics.get("B"));
        topic = sc.nextLine().toUpperCase();

        Quiz quiz;

        switch (topic) {
            case "A": {
                quiz = new MultichoiceQuiz();
                break;
            }

            case "B": {
                quiz = new BinaryQuiz();
                break;
            }

            default: {
                throw new IllegalArgumentException();
            }
        }

        quiz.showQuestions();
        System.out.println(quiz.getScore());
        JDBCOps.saveScore(name, quiz.getScore(), topics.get(topic));
        JDBCOps.getScoreboard();
    }

    public void username(){
        System.out.println("Enter your username below");
    }

}
