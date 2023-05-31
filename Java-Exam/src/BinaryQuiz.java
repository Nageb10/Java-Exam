import java.util.ArrayList;
import java.util.Scanner;

public class BinaryQuiz implements Quiz {

    int score = 0;

    int currentIndex = 0;

    ArrayList<BinaryQuestion> questions;

    public BinaryQuiz() {
        questions = JDBCOps.getBinaryQuestions();
    }
    @Override
    public void showQuestions() {
        Scanner sc = new Scanner(System.in);

        questions.forEach(qu -> {
            System.out.format("%s, %s\n\n", qu.question, "(yes/no)");
            if (isCorrectAnswer(sc.nextLine().toLowerCase())) {
                score++;
            };
            currentIndex++;
        });
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        return questions.get(currentIndex).correctAnswer.equals(answer);
    }

    @Override
    public int getScore() {
        return score;
    }
}

