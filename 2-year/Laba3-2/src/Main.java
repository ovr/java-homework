import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        BufferedReader bufferedReader;

        FileReader fReader;
        try {
            fReader = new FileReader(new File("in.txt"));
            bufferedReader = new BufferedReader(fReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int linesToRead;
        LineNumberReader lineNumberReader = new LineNumberReader(fReader);
        lineNumberReader.skip(Long.MAX_VALUE);
        linesToRead = lineNumberReader.getLineNumber();

        System.out.println(linesToRead);
        if (linesToRead <= 0) {
            throw new RuntimeException("lines to read must be positive");
        }

        ArrayList<String> tmp = new ArrayList<String>(linesToRead);

        try {
            for (int i = 0; i < linesToRead; i++) {
                tmp.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        bufferedReader.close();

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert bufferedWriter != null;

        try {
            for (int i = linesToRead-1; i >= 0; i--) {
                bufferedWriter.write(tmp.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        bufferedWriter.close();
    }
}
