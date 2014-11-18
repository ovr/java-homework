import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Working Directory = " +  System.getProperty("user.dir"));

        File currentDir = new File(System.getProperty("user.dir") + "/input/");

        MessagesService service = new MessagesService(currentDir);
        service.work();

        File output = new File(System.getProperty("user.dir") + "/out.txt");
        service.write(output);

        System.out.println("Hello World!");
    }
}
