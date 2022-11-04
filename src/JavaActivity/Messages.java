package JavaActivity;

public class Messages {

    private String fromCurrentUser;
    private String currentMessage;
    
    public Messages(String forAnyone, String fromCurrentUser, String currentMessage) {
        this.fromCurrentUser = fromCurrentUser;
        this.currentMessage = currentMessage;
    }

    public String getCurrentMessage() {
        return currentMessage;
    }

    public String getFromCurrentUser() {
        return fromCurrentUser;
    }
}
