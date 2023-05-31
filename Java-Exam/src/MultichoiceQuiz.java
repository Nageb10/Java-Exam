import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class MultichoiceQuiz implements Quiz {
    int score = 0;
    int currentIndex = 0;

    ArrayList<MultichoiceQuestions> questions;

    public MultichoiceQuiz() {
        questions = JDBCOps.getmultiplechoiceQuestions();
    }

    @Override
    public void showQuestions() {
        Scanner sc = new Scanner(System.in);

        questions.forEach(qu -> {
            System.out.format("%s\n, %s, %s, %s, %s\n\n", qu.question, qu.answerA, qu.answerB, qu.answerC, qu.answerD);
            if (isCorrectAnswer(sc.nextLine().toUpperCase())) {
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
