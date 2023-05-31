import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JDBCOps {
    static final String DB_URL = "jdbc:mysql://localhost/quizDb?user=root&password=Nahom619$";

    public static void populate(){
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
        ) {
            String q1 = "INSERT INTO multichoiceQuiz VALUES (1, 'Who has won the most Ballon D´or:', 'A: Cristiano Ronaldo', 'B: Lionel Messi', 'C: Pele', 'D: Maradona', 'B')";
            statement.executeUpdate(q1);
            String q2 = "INSERT INTO multichoiceQuiz VALUES (2, 'Which team won the recent Champions League title:', 'A: Liverpool', 'B: Manchester City', 'C: PSG', 'D: Real Madrid', 'A')";
            statement.executeUpdate(q2);
            String q3 = "INSERT INTO multichoiceQuiz VALUES (3, 'Who won the Premier league title this season:', 'A: Manchester City', 'B: Manchester United', 'C: Liverpool', 'D: Chelsea', 'A')";
            statement.executeUpdate(q3);
            String q4 = "INSERT INTO multichoiceQuiz VALUES (4, 'Which team did Erling Haaland transer to?:', 'A: Tottenham Hotspurs', 'B: West Ham United', 'C: Manchester City', 'D: Manchester United', 'A')";
            statement.executeUpdate(q4);

            String q5 = "INSERT INTO binaryQuiz VALUES ('This years NBA finals are played between Golden State Warriors and Miami Heat', 'no')";
            statement.executeUpdate(q5);
            String q6 = "INSERT INTO binaryQuiz VALUES ('Michael Jordan used to play for Cleveland Cavalries.', 'no')";
            statement.executeUpdate(q6);
            String q7 = "INSERT INTO binaryQuiz VALUES ('In 2013 Miami Heat won the NBA finals.', 'yes')";
            statement.executeUpdate(q7);
            String q8 = "INSERT INTO binaryQuiz VALUES ('Larry Bird a former Celtic player is left handed', 'no')";
            statement.executeUpdate(q8);
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                // Database is already populated
                return;
            }

            e.printStackTrace();
        }
    }

    public static void saveScore(String user, int score, String topic){
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = conn.prepareStatement("INSERT INTO scoreHistory(user, score, topic) VALUES (?, ?, ?)");
        ) {
            statement.setString(1, user);
            statement.setInt(2, score);
            statement.setString(3, topic);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getScoreboard(){
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
        ) {
            String query = "SELECT user, score, topic FROM scoreHistory ORDER BY score DESC";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String user = resultSet.getString(1);
                int score = resultSet.getInt(2);
                String topic = resultSet.getString(3);

                System.out.format("%s, %s, %s\n\n", user, score, topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<BinaryQuestion> getBinaryQuestions(){
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
        ) {
            String query = "SELECT question, correctAnswer FROM binaryQuiz";
            ResultSet rs = statement.executeQuery(query);

            ArrayList<BinaryQuestion> result = new ArrayList<>();

            while(rs.next()) {
                String question = rs.getString(1);
                String correctAnswer = rs.getString(2);

                result.add(new BinaryQuestion(question, correctAnswer));
            }
            Collections.shuffle(result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public static ArrayList<MultichoiceQuestions> getmultiplechoiceQuestions(){
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
        ) {
            String query = "SELECT question, answerA, answerB, answerC, answerD, correctAnswer FROM multichoiceQuiz";
            ResultSet rs = statement.executeQuery(query);

            ArrayList<MultichoiceQuestions> result = new ArrayList<>();

            while(rs.next()) {
                String question = rs.getString(1);
                String answerA = rs.getString(2);
                String answerB = rs.getString(3);
                String answerC = rs.getString(4);
                String answerD = rs.getString(5);
                String correctAnswer = rs.getString(6);

                result.add(new MultichoiceQuestions(question, answerA, answerB, answerC, answerD, correctAnswer));
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
