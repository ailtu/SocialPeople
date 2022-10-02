package JavaActivity;

public class User implements Comparable<User> {

    private String login;
    private String password;
    private Friends[] friends;
    private Messages[] messages;

    public User(String login, String password) {

        this.login = login;
        this.password = password;
        friends = new Friends[10];
        messages = new Messages[10];
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "O Login: " + this.login + "Senha: " + this.password;
    }

    @Override
    public int compareTo(User userToComparate) {

        return this.login.compareTo(userToComparate.login);
    }

    /* :: Simulador de mensagens e seguidores:: */

    int countFollowers = 0;

    public int getAmountFriends() {

        return countFollowers;
    }

    public Friends[] getFriends() {

        return this.friends;
    }

    public Friends[] getPendingFriends() {

        Friends[] pendingFriendsRequests = new Friends[countFollowers]; int j = 0;

        for (int i = 0; i < countFollowers; i++) {

            Friends friend = friends[i];
            
            if (friend.getPending()) {
                pendingFriendsRequests[j] = friend;
                j++;
            }
        }
        if (j > 0) {
            return pendingFriendsRequests;
        }
        return null;
    }

    public void inviteFriend(String forAnyone) {
        Friends friend = new Friends(login, forAnyone);
        friends[countFollowers] = friend;
        countFollowers++;
    }

    int countMessages = 0;

    public Messages[] getMessage() {
       
        if (countMessages > 0) {
            return messages;
        }
        return null;
    }

    public void sendMessage(Messages message) {
      
        messages[countMessages] = message;
        countMessages++;
    }
}
