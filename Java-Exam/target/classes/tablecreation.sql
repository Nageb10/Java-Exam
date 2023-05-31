USE quizDb;

    CREATE TABLE multichoiceQuiz(
        id INT NOT NULL AUTO_INCREMENT,
        question varchar(50),
        answerA varchar(50),
        answerB varchar(50),
        answerC varchar(50),
        answerD varchar(50),
        correctAnswer varchar(50),
        PRIMARY KEY (id)
    );

CREATE TABLE binaryQuiz(
                           id INT NOT NULL AUTO_INCREMENT,
                           question varchar(100),
                           correctAnswer VARCHAR(10),
                           PRIMARY KEY(id)
);

    CREATE TABLE scoreHistory(
        id INT NOT NULL AUTO_INCREMENT,
        user varchar(100),
        score INT NOT NULL,
        topic varchar(100),
        PRIMARY KEY(id)
    );

