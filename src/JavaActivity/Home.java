package JavaActivity;

import java.util.Scanner;

public class Home {

    private User[] userAccounts;

    // simula id da posição do vetor, onde estão armazenados os dados
    private int idAccountInfo;

    public Home() {
        int indexSize = 100;
        userAccounts = new User[indexSize];
        idAccountInfo = 0;
    }

    public void createNewAccount(String login, String password) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite seu login: ");
        login = in.nextLine();

        /*
         * while (/* verifica se a conta ja existe ou não foi preenchida ) {
         * 
         * }
         */

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

    // checa contas existentes ou campos não preenchidos
    public boolean checkAccounts(String login, String password) {

        boolean notSuitableAlert = true;

        for (int i = 0; i < idAccountInfo; i++) {
            if (login.equals("") || login.equals(userAccounts[i].getLogin())) {
                
                notSuitableAlert = true; // valor não adequado identificado
                break;
            } else if(password.equals("")) {
                notSuitableAlert = true;
            
            }
        }

        // falta verificar senha

        return false;
    }

    public void userLogin() {

    }
}
