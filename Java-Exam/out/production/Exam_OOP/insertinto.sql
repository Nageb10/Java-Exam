USE quizDb;

INSERT INTO multichoiceQuiz(
    question, answera, answerb, answerc, answerd, correctanswer
) VALUES('Who has won the most Ballon D´or:', 'A: Cristiano Ronaldo', 'B: Lionel Messi', 'C: Pele', 'D: Maradona', 'B: Lionel Messi');
INSERT INTO multichoiceQuiz(
    question, answera, answerb, answerc, answerd, correctanswer
) VALUES('Which team won the recent Champions League title:', 'A: Liverpool', 'B: Manchester City', 'C: PSG', 'D: Real Madrid', 'A: Liverpool');
INSERT INTO multichoiceQuiz(
    question, answera, answerb, answerc, answerd, correctanswer
) VALUES('Who won the Premier league title this season:', 'A: Manchester City', 'B: Manchester United', 'C: Liverpool', 'D: Chelsea', 'A: Manchester City');
INSERT INTO multichoiceQuiz(
    question, answera, answerb, answerc, answerd, correctanswer
) VALUES('Which team did Erling Haaland transer to?:', 'A: Tottenham Hotspurs', 'B: West Ham United', 'C: Manchester City', 'D: Manchester United', 'A: Manchester City');

INSERT INTO binaryQuiz(question, correctAnswer)
VALUES('This years NBA finals are played between Golden State Warriors and Miami Heat', 'no');
INSERT INTO binaryQuiz(question, correctAnswer)
VALUES('Michael Jordan used to play for Cleveland Cavalries.', 'no');
INSERT INTO binaryQuiz(question, correctAnswer)
VALUES('In 2013 Miami Heat won the NBA finals.', 'yes');
INSERT INTO binaryQuiz(question, correctAnswer)
VALUES('Larry Bird a former Celtic player is left handed', 'no');