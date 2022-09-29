package JavaActivity;

public class Messages {
    
    private String forAnyone;
    private String fromCurrentUser;
    private String currentMessage;
    
    public Messages(String forAnyone, String fromCurrentUser, String currentMessage) {
        super();
        this.forAnyone = forAnyone;
        this.fromCurrentUser = fromCurrentUser;
        this.currentMessage = currentMessage;
    }

    public void setCurrentMessage(String currentMessage) {
        this.currentMessage = currentMessage;
    }

    public String getCurrentMessage() {
        return currentMessage;
    }

    public Messages(){

    }

    public String getForAnyone() {
        return forAnyone;
    }

    public void setForAnyone(String forAnyone) {
        this.forAnyone = forAnyone;
    }

    public String getFromCurrentUser() {
        return fromCurrentUser;
    }

    public void setFromCurrentUser(String fromCurrentUser) {
        this.fromCurrentUser = fromCurrentUser;
    }
}
