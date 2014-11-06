package laba1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Laba1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        PrintWriter bw;
        BufferedReader wr;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt"), "CP1251"))) {
            bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"), "CP1251")));
            wr = new BufferedReader(new InputStreamReader(System.in, "CP1251"));
            String s, s1;
            while((s = br.readLine()) != null) {
                
                System.out.println("Вопрос: " + s);
                
                bw.println("Вопрос: " + s);
                
                System.out.println("Введите ответ:");
                
                s1 = wr.readLine();
                
                bw.println("Ответ: " + s1 );
                
            }
        }
        bw.close();
        wr.close();
       
    }
    
}
