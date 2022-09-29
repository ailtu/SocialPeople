package JavaActivity;

public class Friends {
    
    private String forAnyone;
    private String fromCurrentUser;

    public Friends(String forAnyone, String fromCurrentUser) {

        this.forAnyone = forAnyone;
        this.fromCurrentUser = fromCurrentUser;
    }

    public Friends() {
        
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