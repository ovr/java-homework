package laba1;

public class Laba1 {

    public static void main(String[] args)
    {
        try {
            AnswerQuestion anserQuestion = new AnswerQuestion("in.txt", "out.txt");
            anserQuestion.work();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Конец приложения");
    }
}
