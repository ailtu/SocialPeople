package JavaActivity;

public class User implements Comparable<User> {

    private String login;
    private String password;
    private Messages[] messages;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        messages = new Messages[10];
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
    public int compareTo(User U) {
        return this.login.compareTo(U.login);
    }

    int countMessages = 0;
    public Messages[] getMessage() {

        if (countMessages > 0) {
            return messages;
        }
        return null;
    }

    public void addMessage(Messages message) {
        messages[countMessages] = message;
        countMessages++;
    }
}
