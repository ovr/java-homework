import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Created by ovr on 18.11.14.
 */
public class XmlToMessage {
    static public Message convert(String fileName) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String content;
        String temp;
        StringTokenizer st;

        Message msg = new Message();

        while ((content = in.readLine()) != null) {

            st = new StringTokenizer(content, "<>");

            while (st.hasMoreTokens()) {

                switch(st.nextToken()) {

                    case "to":
                        if ((temp = st.nextToken()) != "/to") {
                            msg.setTo(temp);
//                            System.out.println(msg.getTo());
                            break;
                        }

                    case "from":
                        if ((temp = st.nextToken()) != "/from") {
                            msg.setFrom(temp);
//                            System.out.println(msg.getFrom());
                            break;
                        }

                    case "heading":
                        if ((temp = st.nextToken()) != "/heading") {
                            msg.setHead(temp);
//                            System.out.println(msg.getHead());
                            break;
                        }

                    case "body":
                        if ((temp = st.nextToken()) != "/body") {
                            msg.setBody(temp);
//                            System.out.println(msg.getBody());
                            break;
                        }
                }
            }
        }
        in.close();

        return msg;
    }
}
