package JavaActivity;

import java.util.Scanner;
import JavaLayouts.Layouts;

public class Home {

    private String confirmPassCheck;
    private User[] userAccounts;
    public User currentUser;
    private Layouts view;

    // simula id da posição do vetor, onde estão armazenados os dados
    private int idAccountInfo;

    public Home() {
        idAccountInfo = 0;
        userAccounts = new User[100];
        view = new Layouts(this);
    }

    public void startView() {
        view = new Layouts(this);
        view.mainTitle();
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

    public void mainTitle() {
        Scanner in = new Scanner(System.in);

        int optionChoosed;

        System.out.println("|               > SOCIAL PEOPLE <              | ");
        System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
        optionChoosed = in.nextInt(); in.nextLine();

        while(optionChoosed != 3) {

            switch(optionChoosed) {

                case 1 -> {
                    this.createNewAccount();
                    this.menuWhenUserLogged();
                }
                case 2 -> {
                    this.login();
                    this.menuWhenUserLogged();
                }
                default -> {
                    System.out.println("Opção inválida, tente novamente: ");
                }
            }
        }
        in.close();
        System.out.println("Saindo...");
        Runtime.getRuntime().exit(0);
    }

    // cria conta para um novo usuário
    public void createNewAccount() {
        Scanner in = new Scanner(System.in);

        String login;
        String password;

        // criação de login
        System.out.println("Crie um Login: ");
        login = in.nextLine();

        while(this.checkLoginAlreadyExist(login) == false || this.checkLoginIsSuitable(login)) {
            System.out.println("Erro: A conta já existe! Tente outro: ");
            login = in.nextLine();
        }

        while(this.checkLoginIsSuitable(login)) {
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
        currentUser = this.registerNewAccount(login, password);
        in.close();
    }

    // registra na array o novo usuário
    public User registerNewAccount(String login, String password) {
        User accountForRegister = new User(login, password);
        userAccounts[idAccountInfo] = accountForRegister;
        idAccountInfo++;

        return accountForRegister;
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

        int optionChoosed = 0;

        System.out.println("|  1 - Editar Login/Senha  |  2 - Add/Seguir Amigos  |  3 - Enviar Mensagem  |  4 - Sair  |");
        optionChoosed = in.nextInt(); in.nextLine();
        while(optionChoosed != 4) {

            switch(optionChoosed) {
                case 1 -> {
                    editProfile();
                }
                case 2 -> {
                    followAndShowFriends();
                }
                case 3 -> {
                    sendMessages();
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
            this.menuWhenUserLogged();
            optionChoosed = in.nextInt(); in.nextLine();
        }
        System.out.println("Redirecionandopara o menu...");
        this.mainTitle();
        in.close();
    }

    public void editProfile() {
        Scanner in = new Scanner(System.in);

        String newLogin;
        String newPass;
        int optionChoosed;

        System.out.println("O que deseja alterar " + currentUser.getLogin() + "?");
        System.out.println("|  1 - Seu Login  |  2 - Sua Senha  |  3 - Sair  | ");
        optionChoosed = in.nextInt(); in.nextLine();

        while (optionChoosed != 3) {
            switch (optionChoosed) {

                case 1 -> {
                    System.out.println("Digite o novo Login: ");
                    newLogin = in.nextLine();
                    this.changeLogin(currentUser.getLogin(), newLogin);
                    System.out.println("Login alterado com sucesso!");
                }
                case 2 -> {
                    System.out.println("Digite a nova Senha: ");
                    newPass = in.nextLine();
                    this.changePass(currentUser.getLogin(), newPass);
                    System.out.println("Senha alterada com sucesso!");
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
            this.editProfile();
        }
        this.menuWhenUserLogged();
        in.close();
    }

    public void changeLogin(String login, String storageNewLogin ) {
        User user = this.findUserById(login);
        user.setLogin(storageNewLogin);
    }

    public void changePass(String login, String storageNewPass) {
        User user = this.findUserById(login);
        user.setPassword(storageNewPass);
    }

    public void followAndShowFriends() {
        Scanner in = new Scanner(System.in);

        int optionChoosed;
        String loginFriend;

        System.out.println("|  1 - Seguir amigo  |  2 - Voltar   |");
        optionChoosed = in.nextInt();

        while (optionChoosed != 2) {
            switch (optionChoosed) {

                case 1 -> {
                    System.out.println("");
                    loginFriend = in.nextLine();
                    while(!this.checkLoginAlreadyExist(loginFriend)) {
                        System.out.println("Login não encontrado ou não existente! Tente novamente: ");
                        loginFriend = in.nextLine();
                    }
                    currentUser.inviteFriend(loginFriend);
                    System.out.println("Solicitação de amizade enviada, aguarde ser aceita!");
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
            this.followAndShowFriends();
        }
        this.menuWhenUserLogged();
    }

    public void sendMessages() {
    }
}
