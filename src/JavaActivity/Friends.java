package JavaActivity;

public class Friends {

    private String forAnyone;
    private String fromCurrentUser;
    private boolean pendingF;

    public Friends(String forAnyone, String fromCurrentUser) {

        this.pendingF = true;
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

    public void setPending(boolean friendshipSolicitation) {

        this.pendingF = friendshipSolicitation;
    }

    public boolean getPending() {

        return this.pendingF;
    }
}