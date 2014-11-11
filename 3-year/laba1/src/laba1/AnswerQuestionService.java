package laba1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Класс для работы с чтение вопросов и записью ответов
 */
public class AnswerQuestionService {
    protected String inputFilePath;
    protected String outFilePath;

    protected ArrayList<AnswerQuestion> answerQuestions = new <AnswerQuestion>ArrayList();

    public AnswerQuestionService(String inputFilePath, String outFilePath)
    {
        this.inputFilePath = inputFilePath;
        this.outFilePath = outFilePath;
    }

    public void readQuestions() throws IOException {
        /**
         * Входной
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.inputFilePath)));

        String question;

        while((question = br.readLine()) != null) {
            this.answerQuestions.add(new AnswerQuestion(question));
        }

        br.close();
    }

    public void work() throws IOException
    {
        /**
         * Читаем консоль
         */
        BufferedReader wr = new BufferedReader(new InputStreamReader(System.in));

        for (AnswerQuestion aq : this.answerQuestions) {
            System.out.println("Вопрос: " + aq.getQuestion());
            System.out.println("Введите ответ:");

            aq.setAnswer(wr.readLine());
        }

        wr.close();
    }

    public void write() throws FileNotFoundException {
        /**
         * Выходной
         */
        PrintWriter bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.outFilePath))));

        for (AnswerQuestion aq : this.answerQuestions) {
            bw.println("Вопрос: " + aq.getQuestion());
            bw.println("Ответ: " + aq.getAnswer());
        }

        bw.close();
    }
}
