package JavaActivity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Home {

    private Scanner in = new Scanner(System.in);
    private String confirmPassCheck;
    private User[] userAccounts;
    public User currentUser;

    // simula id da posição do vetor, onde estão armazenados os dados
    private int idAccountInfo;

    public Home() {
        idAccountInfo = 0;
        userAccounts = new User[1000];
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

    // armazena o login
    public void changeLogin(String login, String storageNewLogin) {
        User user = this.findUserById(login);
        user.setLogin(storageNewLogin);
    }

    // armazena a senha
    public void changePass(String login, String storageNewPass) {
        User user = this.findUserById(login);
        user.setPassword(storageNewPass);
    }

    public void mainTitle() {

        boolean executionSwitch = false;
        while (!executionSwitch) {
            Scanner in = new Scanner(System.in);

            System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Finalizar App  | ");

            try {
                switch (in.nextInt()) {
                    case 1:
                        this.createNewAccount();
                        this.menuWhenUserLogged();
                        break;

                    case 2:
                        this.login();
                        this.menuWhenUserLogged();
                        break;

                    case 3:
                        System.out.println("Saindo...");
                        Runtime.getRuntime().exit(0);

                    default:
                        System.out.println("Opção inválida, tente novamente: ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: " + e + " Tipo de valor inválido, tente novamente: ");
            }
        }
    }

    public void createNewAccount() {

        String login;
        String password;

        System.out.println("Crie um Login: ");
        login = in.nextLine();

        while (login.length() == 0) {
            System.out.println("Erro: O campo login está vazio! Preencha-o novamente: ");
            login = in.nextLine();
        }

        while (this.checkLoginAlreadyExist(login)) {
            System.out.println("Erro: A conta já existe! Tente outro: ");
            login = in.nextLine();
        }

        System.out.println("Crie uma senha: ");
        password = in.nextLine();

        while (password.length() == 0) {
            System.out.println("Campos vazios não são permitidos! Tente novamente: ");
            password = in.nextLine();
        }

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

    public Friends[] getFollowers() {

        int requestsAmount = 0;
        Friends[] followRequests = new Friends[1000];

        for (int i = 0; i < idAccountInfo; i++) {
            User user = userAccounts[i];
            if (!(currentUser == user)) {
                Friends[] searchedFriends = user.getFriends();
                for (int j = 0; j < user.getAmountFriends(); j++) {
                    Friends friendsReached = searchedFriends[j];
                    if (friendsReached.getForAnyone().equals(currentUser.getLogin()) && friendsReached.getPending()) {
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

    // enviar solicitação de amizade
    public void sendFriendshipRequest() {

        int optionsChoosed = in.nextInt();
        while (optionsChoosed != 2) {
            switch (optionsChoosed) {
                case 1:
                    System.out.println("Login de quem você quer seguir: ");
                    String friendReceiverLogin = in.nextLine();

                    while (!this.checkLoginAlreadyExist(friendReceiverLogin)) {
                        System.out.print("Não encontramos esse usuário! Digite novamente: ");
                        friendReceiverLogin = in.nextLine();
                    }
                    currentUser.inviteFriend(friendReceiverLogin);
                    System.out.println("Solicitação enviada com sucesso!");
                    break;
            }
            this.menuNetworkSystem();
        }
    }

    public void viewPendingRequests() {

        Friends[] friends = currentUser.getFriends();
        int optionChoosed = 0;

        if (friends != null) {
            System.out.println("Solicitações enviadas: ");
            for (int i = 0; i < friends.length; i++) {
                if (friends[i] != null) {
                    Friends friend = friends[i];

                    User friendAccount = this.findUserById(friend.getForAnyone());
                    String statusRequest = friend.getPending() ? "Ainda pendente..." : "Foi aceita!";
                    System.out.println(friendAccount.getLogin() + statusRequest);
                }
            }
        } else {
            System.out.println("0 - Solicitações enviadas.");
        }

        Friends[] pendingRequests = getFollowers();
        if (pendingRequests != null) {
            System.out.println("Solicitações de amizade para você!");
            for (int i = 0; i < pendingRequests.length; i++) {
                if (pendingRequests[i] != null) {
                    Friends friend = pendingRequests[i];
                    User friendAccount = this.findUserById(friend.getFromCurrentUser());
                    System.out.println(friendAccount.getLogin() + " N° " + (i + 1));
                }
            }
            System.out.println("Digite o N° da solicitação para ACEITAR ou 0 para NEGAR e VOLTAR.");
            optionChoosed = in.nextInt();
            while (optionChoosed != 0) {
                pendingRequests[optionChoosed - 1].setPending(false);
                optionChoosed = in.nextInt();
            }
        } else {
            System.out.println("Vá procurar amigos! a caixa está vazia de solicitações ;-; ");
            this.menuNetworkSystem();
        }
    }

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

    public void menuWhenUserLogged() {

        boolean executionSwitch = false;

        while (!executionSwitch) {
            Scanner in = new Scanner(System.in);

            System.out.println("| O que deseja fazer " + currentUser.getLogin() + "? ");
            System.out.println("|  1 - Editar Perfil  |  2 - Conversas  |  3 - Amizades  |  4 - Deslogar  |");

            try {
                switch (in.nextInt()) {

                    case 1: // edição de perfil
                        editProfile();
                        break;

                    case 2: // sistema de mensagem
                        messageSystem();
                        break;

                    case 3: // sistema de seguidores
                        menuNetworkSystem();
                        break;

                    case 4: // volta ao menu
                        mainTitle();
                        break;

                    default:
                        System.out.println("Opção inválida, tente novamente: ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: " + e + " Tipo de valor inválido, tente novamente: ");
            }
        }
    }

    public void editProfile() {

        System.out.println("| O que deseja alterar " + currentUser.getLogin() + "?");
        System.out.println("|  1 - Seu Login  |  2 - Sua Senha  |  3 - Sair  | ");
        int optionChoosed = in.nextInt();
        in.nextLine();

        while (optionChoosed != 3) {
            switch (optionChoosed) {

                case 1:
                    resetLogin();
                    break;

                case 2:
                    resetPassword();
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente: ");
            }
            this.editProfile();
        }
        this.menuWhenUserLogged();
    }

    // entrada de dado resetar login
    public void resetLogin() {
        System.out.println("Digite o novo Login: ");
        String storageNewLogin = in.nextLine();
        this.changeLogin(currentUser.getLogin(), storageNewLogin);
        System.out.println("Login alterado com sucesso!");
    }

    // entrada de dado resetar password
    public void resetPassword() {
        System.out.println("Digite a nova Senha: ");
        String storageNewPass = in.nextLine();
        this.changePass(currentUser.getLogin(), storageNewPass);
        System.out.println("Senha alterada com sucesso!");
    }

    public void messageSystem() {

        String login;
        String message;

        System.out.println("| Inbox de " + currentUser.getLogin());
        System.out.println("|  1 - Enviar Mensagens  |  2 - Mensagens Recebidas  |  3 - Voltar   |");
        int optionChoosed = in.nextInt();
        in.nextLine();

        while (optionChoosed != 3) {
            switch (optionChoosed) {

                case 1:
                    System.out.println("Digite o Login do seu amigo: ");
                    login = in.nextLine();

                    while (!this.checkLoginAlreadyExist(login)) {
                        System.out.println("Amigo não encontrado! Tente outro: ");
                        login = in.nextLine();
                    }

                    System.out.println("Amigo encontrado!");
                    System.out.println("Digite o que deseja enviar: ");
                    message = in.nextLine();

                    Messages messageSended = new Messages(login, currentUser.getLogin(), message);
                    currentUser.addMessage(messageSended);
                    User user = findUserById(login);
                    user.addMessage(messageSended);
                    System.out.println("Mensagem enviada!");
                    break;

                case 2:
                    Messages[] receivedMessage = currentUser.getMessage();
                    if (receivedMessage != null) {
                        for (int i = 0; i < currentUser.countMessages; i++) {
                            Messages messages = receivedMessage[i];
                            System.out.println("Mensagem de " + findUserById(messages.getFromCurrentUser()).getLogin() + " para você! ");
                            System.out.println("> " + messages.getCurrentMessage());
                        }
                    } else {
                        System.out.println("Vá procurar amigos! a caixa está vazia ;-; ");
                    }
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente: ");
                    break;
            }
            messageSystem();
        }
        menuWhenUserLogged();
    }

    public void menuNetworkSystem() {

        boolean executionSwitch = false;
        while (!executionSwitch) {
            Scanner in = new Scanner(System.in);

            System.out.println("| O que deseja fazer " + currentUser.getLogin() + "?");
            System.out.println("|  1 - Adicionar Amigos  |  2 - Solicitações de Amizade  |  3 - Voltar   |");

            try {
                switch (in.nextInt()) {
                    case 1:
                        sendFriendshipRequest();
                        break;

                    case 2:
                        viewPendingRequests();
                        break;

                    case 3:
                        menuWhenUserLogged();
                        break;

                    default:
                        System.out.println("Opção inválida, tente novamente: ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: " + e + " Tipo de valor inválido, tente novamente: ");
            }
        }
    }
}
