package JavaActivity;

import java.util.Scanner;
import JavaLayouts.Layouts;

public class Home {

    private String confirmPassCheck;
    private User[] userAccounts;
    public User currentUser;

    // simula id da posição do vetor, onde estão armazenados os dados
    private int idAccountInfo;

    public Home() {
        int indexSize = 100;
        userAccounts = new User[indexSize];
        idAccountInfo = 0;
    }

    /* :: Métodos de checagem e verificação :: */

    // método para auxiliar nas buscas de um usuário
    public User findUserById(String login) {

        for (int i = 0; i <= idAccountInfo; i++) {
            if (login.equals(userAccounts[i].getLogin())) {
                return userAccounts[i]; // se encontrar, retorne-a
            }
        }
        return null; // se não, retorne nula
    }

    // checa se o campo de login foi preenchido
    public boolean checkLoginIsSuitable(String login) {

        // predefinido como login adequado
        boolean suitableAlert = true;

        for (int i = 0; i < idAccountInfo; i++) {
            if (login.equals("")) {
                suitableAlert = false; // valor não adequado identificado
                break;
            }
        }
        return suitableAlert;
    }

    // checa se o login já existe
    public boolean checkLoginAlreadyExist(String login) {

        // predefinido como não existente
        boolean loginDoesNotExist = false;

        for (int i = 0; i <= idAccountInfo; i++) {
            if (login.equals(userAccounts[i].getLogin())) {
                return true; // login já existe
            }
        }
        return loginDoesNotExist;
    }

    // checa se a senha é a do login correto
    public boolean checkPassIsSuitableOfLogin(String login, String password) {

        User userForCheck = this.findUserById(login);
        if (userForCheck != null) {
            return password.equals(userForCheck.getPassword());
        }
        return false;
    }

    	// altera a senha do usuário
	public void changePassOfAccount(String login, String newPass) {
		User userForChangePass = this.findUserById(login);
		userForChangePass.setPassword(newPass);
	}

    /* :: Métodos de criação, login e gerenciamento de conta :: */

    // cria conta para um novo usuário
    public void createNewAccount() {
        Scanner in = new Scanner(System.in);

        String login;
        String password;

        // criação de login
        System.out.println("Crie um Login: ");
        login = in.nextLine();

        while (this.checkLoginAlreadyExist(login) == false || this.checkLoginIsSuitable(login)) {
            System.out.println("Erro: A conta já existe! Tente outro: ");
            login = in.nextLine();
        }

        while (this.checkLoginIsSuitable(login)) {
            System.out.println("Campos vazios não são permitidos! Tente novamente: ");
            login = in.nextLine();
        }

        // criação de senha
        System.out.println("Crie uma senha: ");
        password = in.nextLine();

        while (password.equals("")) {
            System.out.println("Campos vazios não são permitidos! Tente novamente: ");
            password = in.nextLine();
        }

        // pede confirmação de senha para checar se foi digitada corretamente
        System.out.println("Confirme sua senha: ");
        confirmPassCheck = in.nextLine();

        while (!password.equals(confirmPassCheck)) {
            System.out.println("A senha está diferente! Tente novamente: ");
            confirmPassCheck = in.nextLine();
        }

        in.close();
    }

    // login para usuários já cadastrados
    public void login() {
        Scanner in = new Scanner(System.in);

        String login;
        String password;

        System.out.println("Seu login: ");
        login = in.nextLine();

        while (!this.checkLoginAlreadyExist(login)) {
            System.out.println("Esse login não existe, tente outro: ");
            login = in.nextLine();
        }

        System.out.println("Sua Senha: ");
        password = in.nextLine();

        while (password.equals("")) {
            System.out.println("Campos vazios não são permitidos! Tente novamente: ");
            password = in.nextLine();
        }

        while (!this.checkPassIsSuitableOfLogin(login, password)) {
            System.out.println("Senha incorreta! Tente novamente: ");
            password = in.nextLine();
        }

        currentUser = this.findUserById(login);
        in.close();
    }

    // menu de quando usuário já estiver logado
    public void menuWhenUserLogged() {
        Scanner in = new Scanner(System.in);
        Layouts viewLayouts = new Layouts();

        System.out.println(" Olá" + currentUser.getLogin() + "! ");
        viewLayouts.viewMenuWhenUserLogged();

        in.close();
    }
}
