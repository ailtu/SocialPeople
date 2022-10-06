package JavaActivity;

public class Friends {

    private boolean pendingF;
    private String forAnyone;
    private String fromCurrentUser;

    public Friends(String forAnyone, String fromCurrentUser) {
        this.pendingF = true;
        this.forAnyone = forAnyone;
        this.fromCurrentUser = fromCurrentUser;
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

    public void setPending(boolean friendshipSolicitation) {
        this.pendingF = friendshipSolicitation;
    }

    public boolean getPending() {
        return this.pendingF;
    }
}