package laba1;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Класс для работы с чтение вопросов и записью ответов
 */
public class AnswerQuestion {
    protected String inputFilePath;
    protected String outFilePath;


    public AnswerQuestion(String inputFilePath, String outFilePath)
    {
        this.inputFilePath = inputFilePath;
        this.outFilePath = outFilePath;
    }

    public void work() throws IOException {
        PrintWriter bw;
        BufferedReader wr;

        /**
         * Входной
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.inputFilePath)));

        /**
         * Выходной
         */
        bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.outFilePath))));

        /**
         * Читаем консоль
         */
        wr = new BufferedReader(new InputStreamReader(System.in));

        String question, answer;

        while((question = br.readLine()) != null) {

            System.out.println("Вопрос: " + question);
            bw.println("Вопрос: " + question);

            System.out.println("Введите ответ:");

            answer = wr.readLine();
            bw.println("Ответ: " + answer );

        }

        bw.close();
        wr.close();
    }
}
