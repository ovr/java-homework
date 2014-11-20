import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader("in.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int linesToRead;

        try {
            linesToRead = Integer.valueOf(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (linesToRead <= 0) {
            throw new RuntimeException("lines to read must be positive");
        }

        ArrayList<String> tmp = new ArrayList<String>(linesToRead);
        for (int i = 0; i < linesToRead; i++) {
            try {
                tmp.add(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        bufferedReader.close();

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert bufferedWriter != null;

        for (int i = linesToRead-1; i >= 0; i--) {
            try {
                bufferedWriter.write(tmp.get(i) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        bufferedWriter.close();
    }
}
