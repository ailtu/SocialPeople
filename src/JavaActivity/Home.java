package JavaActivity;

import java.util.Scanner;
import JavaLayouts.Layouts;

public class Home {

    private User[] userAccounts;
    public User currentUser;
    public Layouts showView;

    // simula id da posição do vetor, onde estão armazenados os dados
    private int idAccountInfo;

    public Home() {
        int indexSize = 100;
        userAccounts = new User[indexSize];
        idAccountInfo = 0;
    }

    public void createNewAccount(String login, String password) {
        Scanner in = new Scanner(System.in);

        System.out.println("Crie um Login: ");
        login = in.nextLine();

          while (this.checkLoginAlreadyExist(login) == true) {
         }
         

        in.close();
    }

    public User addIdForAccount(String login, String password) {

        User newAccount = new User(login, password);
        userAccounts[idAccountInfo] = newAccount;
        idAccountInfo++;
        return newAccount;
    }

    // método para auxiliar nas buscas de um usuário
    public User findUserById(String login) {

        for (int i = 0; i <= idAccountInfo; i++) {
            if (login.equals(userAccounts[i].getLogin())) {
                return userAccounts[i]; // se encontrar, retorne-a
            }
        }
        return null; // se não, retorne nula
    }

    // checa se o campo foi preenchido
    public boolean checkLoginIsSuitable(String login) {

        boolean suitableAlert = false; 

        for (int i = 0; i < idAccountInfo; i++) {
            if (login.equals("")) {         
                suitableAlert = false; // valor não adequado identificado
                break;
            }
        }
        return true;
    }

    // checa se o login já existe
    public boolean checkLoginAlreadyExist(String login) {

        for (int i = 0; i <= idAccountInfo; i++) {
            if(login.equals(userAccounts[i].getLogin())) {
                return

            }

        }
    }

    public void userLogin() {

    }
}
