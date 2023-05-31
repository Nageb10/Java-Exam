import java.util.ArrayList;

public interface Quiz {
    int score = 0;
    int currentIndex = 0;

    public void showQuestions();

    public boolean isCorrectAnswer(String answer);

    public int getScore();
}
