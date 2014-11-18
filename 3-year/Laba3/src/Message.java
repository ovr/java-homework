/**
 * Created by ovr on 18.11.14.
 */
public class Message {
    String toTag;
    String fromTag;
    String headTag;
    String bodyTag;

    public void setTo(String to) {
        toTag = to;
    }

    public void setFrom(String from) {
        fromTag = from;
    }

    public void setHead(String head) {
        headTag = head;
    }

    public void setBody(String body) {
        bodyTag = body;
    }

    public String getTo() {
        return toTag;
    }

    public String getFrom() {
        return fromTag;
    }

    public String getHead() {
        return headTag;
    }

    public String getBody() {
        return bodyTag;
    }
}
