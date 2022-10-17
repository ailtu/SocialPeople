package JavaActivity;

import java.util.InputMismatchException;
import java.util.Scanner;

import JavaLayouts.Layouts;

public class Home {

    private Scanner in = new Scanner(System.in);
    private String confirmPassCheck;
    private User[] userAccounts;
    public User currentUser;
    private Layouts view;

    // simula id da posição do vetor, onde estão armazenados os dados
    private int idAccountInfo;

    public Home() {
        idAccountInfo = 0;
        userAccounts = new User[1000];
        view = new Layouts(this);
    }

    // método para auxiliar nas buscas de um usuário
    public User findUserById(String login) {

        for (int i = 0; i <= idAccountInfo; i++) {
            if (login.equals(userAccounts[i].getLogin())) {
                return userAccounts[i];
            }
        }
        return null;
    }

    // checa se o login já existe
    public boolean checkLoginAlreadyExist(String login) {

        // predefinido como não existente
        boolean loginExist = false;

        for (int i = 0; i < idAccountInfo; i++) {
            if (login.equals(userAccounts[i].getLogin())) {
                loginExist = true; // login já existe
                break;
            }
        }
        return loginExist;
    }

    // checa se a senha é a do login correto
    public boolean checkPassIsSuitableOfLogin(String login, String password) {

        User user = this.findUserById(login);
        if (user != null) {
            return password.equals(user.getPassword());
        }
        return false;
    }

    // edita a senha
    public void changeLogin(String login, String storageNewLogin) {
        User user = this.findUserById(login);
        user.setLogin(storageNewLogin);
    }

    // edita a senha
    public void changePass(String login, String storageNewPass) {
        User user = this.findUserById(login);
        user.setPassword(storageNewPass);
    }

    public Friends[] getFollowers() {

        int requestsAmount = 0;
        Friends[] followRequests = new Friends[1000];

        for(int i = 0; i < idAccountInfo; i++) {
            User user = userAccounts[i];

            if(!(currentUser == user)) {
                Friends[] searchedFriends = user.getFriends();

                for(int j = 0; j < user.getAmountFriends(); j++) {
                    Friends friendsReached = searchedFriends[j];

                    if(friendsReached.getForAnyone().equals(currentUser.getLogin()) && friendsReached.getPending()) {
                        followRequests[requestsAmount] = friendsReached;
                        requestsAmount++;
                    }
                }
            }
        }
        if (requestsAmount > 0) {
            return followRequests;
        }
        return null;
    }

    /* :: Métodos de criação, login e gerenciamento de conta :: */
    public void mainTitle() {
        Scanner in = new Scanner(System.in);

        int optionChoosed = 0;

        try {
            System.out.println("|               > SOCIAL PEOPLE <              | ");
            System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
            System.out.print("| ");
            optionChoosed = in.nextInt();
            in.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Você só pode escolher os valores abaixo! |");
            System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");

        }

        while (optionChoosed != 3) {
            switch (optionChoosed) {

                case 1:
                    this.createNewAccount();
                    this.menuWhenUserLogged();
                    break;

                case 2:
                    this.login();
                    this.menuWhenUserLogged();
                break;

                // default -> System.out.println("| Opção inválida, tente novamente: ");
            }
        }
        System.out.println("Saindo...");
        Runtime.getRuntime().exit(0);
    }

    // cria conta para um novo usuário
    public void createNewAccount() {

        String login;
        String password;

        // criação de login
        System.out.println("Crie um Login: ");
        login = in.nextLine();

        // verifica se está vazio
        while (login.length() == 0) {
            System.out.print("Erro: O campo login está vazio! Preencha-o novamente: ");
            login = in.nextLine();
        }

        while (this.checkLoginAlreadyExist(login)) {
            System.out.println("Erro: A conta já existe! Tente outro: ");
            login = in.nextLine();
        }

        // criação de senha
        System.out.println("Crie uma senha: ");
        password = in.nextLine();

        while (password.length() == 0) {
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

        System.out.println("Registrando e redirecionando... ");
        currentUser = this.registerNewAccount(login, password);
    }

    // registra na array o usuário criado
    public User registerNewAccount(String login, String password) {
        User accountForRegister = new User(login, password);
        userAccounts[idAccountInfo] = accountForRegister;
        idAccountInfo++;

        return accountForRegister;
    }

    // login para usuários já cadastrados
    public void login() {

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
    }

    // menu de quando usuário já estiver logado
    public void menuWhenUserLogged() {

        System.out.println("| O que deseja fazer " + currentUser.getLogin() + "? ");
        System.out.println("|  1 - Editar Login/Senha  |  2 - Seguir Amigos  |  3 - Enviar Mensagem  |  4 - Sair  |");
        System.out.print("| ");
        int optionChoosed = in.nextInt(); in.nextLine();

        while (optionChoosed != 4) {

            switch (optionChoosed) {
                case 1:
                    editProfile();
                    break;

                case 2:
                    followFriends();
                break;

                case 3:
                    messageSystem();
                break;

                default: System.out.println("Opção inválida, tente novamente: ");
            }
            this.menuWhenUserLogged();
            optionChoosed = in.nextInt(); in.nextLine();
        }
        System.out.println("Redirecionando para o menu...");
        this.mainTitle();
    }

    // poder editar login e senha do usuário
    public void editProfile() {

        System.out.println("O que deseja alterar " + currentUser.getLogin() + "?");
        System.out.println("|  1 - Seu Login  |  2 - Sua Senha  |  3 - Sair  | ");
        int optionChoosed = in.nextInt(); in.nextLine();

        while (optionChoosed != 3) {
            switch (optionChoosed) {

                case 1:
                    System.out.println("Digite o novo Login: ");
                    String storageNewLogin = in.nextLine();
                    this.changeLogin(currentUser.getLogin(), storageNewLogin);
                    System.out.println("Login alterado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite a nova Senha: ");
                    String storageNewPass = in.nextLine();
                    this.changePass(currentUser.getLogin(), storageNewPass);
                    System.out.println("Senha alterada com sucesso!");
                break;

                default: System.out.println("Opção inválida, tente novamente: ");
            }
            this.editProfile();
        }
        this.menuWhenUserLogged();
    }

    // seguir amigo
    public void followFriends() {

        System.out.println("|  1 - Seguir amigo  |  2 - Voltar   |");
        int optionChoosed = in.nextInt(); in.nextLine();

        while (optionChoosed != 2) {
            if (optionChoosed == 1) {
                String loginFriend = in.nextLine();
                while (!this.checkLoginAlreadyExist(loginFriend)) {
                    System.out.println("Login não encontrado ou não existente! Tente novamente: ");
                    loginFriend = in.nextLine();
                }
                currentUser.inviteFriend(loginFriend);
                System.out.println("Solicitação de amizade enviada, aguarde ser aceita!");
            } else {
                System.out.println("Opção inválida, tente novamente: ");
            }
            this.followFriends();
        }
        this.menuWhenUserLogged();
    }

    public void messageSystem() {

        String login;
        String message;

        System.out.println("| Inbox de " + currentUser.getLogin());
        System.out.println("|  1 - Enviar Mensagens  |  2 - Mensagens Recebidas  |  3 - Voltar   |");
        System.out.print("| ");
        int optionChoosed = in.nextInt(); in.nextLine();

        while (optionChoosed != 3) {
            switch (optionChoosed) {

                case 1 -> {
                    System.out.println("Digite o Login do seu amigo: ");
                    login = in.nextLine();

                    while (!this.checkLoginAlreadyExist(login)) {
                        System.out.println("Amigo não encontrado! Tente outro: ");
                        login = in.nextLine();
                    }

                    System.out.println("Amigo encontrado...");
                    System.out.println("Digite o que deseja enviar: ");
                    System.out.print("| ");
                    message = in.nextLine();

                    Messages messageSended = new Messages(login, currentUser.getLogin(), message);
                    currentUser.addMessage(messageSended);
                    User user = findUserById(login);
                    user.addMessage(messageSended);
                }

                case 2 -> {
                    Messages[] receivedMessage = currentUser.getMessage();
                    if (receivedMessage != null) {
                        for (int i = 0; i < currentUser.countMessages; i++) {
                            Messages messages = receivedMessage[i];
                            System.out.println("| Mensagem de " + findUserById(messages.getFromCurrentUser()).getLogin() + " para voce! ");
                            System.out.println("> " + messages.getCurrentMessage());
                        }
                    } else {
                        System.out.println("Vá procurar amigos! a caixa está vazia ;-; ");
                    }
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
            messageSystem();
        }
        menuWhenUserLogged();
    }
}
