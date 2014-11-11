package laba1;

public class Laba1 {

    public static void main(String[] args)
    {
        try {
            AnswerQuestionService anserQuestion = new AnswerQuestionService("in.txt", "out.txt");
            anserQuestion.readQuestions();
            anserQuestion.work();
            anserQuestion.write();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Конец приложения");
    }
}
