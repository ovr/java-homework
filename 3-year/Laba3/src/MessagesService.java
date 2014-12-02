import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Created by ovr on 18.11.14.
 */
public class MessagesService {
    protected File currentDir;

    protected ArrayList<Message> messages = new ArrayList<>();

    MessagesService(File currentDir) {
        this.currentDir = currentDir;
    }

    public void work() throws Exception {
        //rly?
        messages.clear();

        File[] files = currentDir.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                /**
                 * Проверяем файлы по mime типу
                 */
                if (Files.probeContentType(file.toPath()).equals("application/xml")) {
                    System.out.println(file.getName());
                    Message msg = XmlToMessage.convert(file.getAbsolutePath());
                    this.messages.add(msg);
                }
            }
        }
    }

    public void write(File outFile) throws IOException {
        System.out.println(outFile.getAbsolutePath());
        PrintWriter out = new PrintWriter(new FileWriter(outFile.getAbsolutePath()));

        /**
         * Фильтрованные списки по уникальности
         *
         * Отправители
         * Получатели
         * Заголовки
         */
        ArrayList<String> outUsers = new ArrayList<>();
        ArrayList<String> intUsers = new ArrayList<>();
        ArrayList<String> headings = new ArrayList<>();

        for (Message msg : this.messages) {
            if (!outUsers.contains(msg.getFrom())) {
                outUsers.add(msg.getFrom());
            }

            if (!intUsers.contains(msg.getTo())) {
                intUsers.add(msg.getTo());
            }

            if (!headings.contains(msg.getHead())) {
                headings.add(msg.getHead());
            }
        }

        out.println("Список отправителей:");
        for (String tmp : outUsers) {
            out.println(tmp);
        }

        out.println();

        out.println("Список получателей:");
        for (String tmp : intUsers) {
            out.println(tmp);
        }

        out.println();

        out.println("Заголовки:");
        for (String tmp : headings) {
            out.println(tmp);
        }

        out.close();
    }
}
