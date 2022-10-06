package JavaLayouts;

import java.util.Scanner;

import JavaActivity.Home;

// classe para gráficos
public class Layouts {
    private Home controller;

    public Layouts(Home viewController) {
        controller = viewController;
    }

    // ver o menu principal
    public void mainTitle() {
        Scanner in = new Scanner(System.in);

        int optionChoosed;

        System.out.println("|               > SOCIAL PEOPLE <              | ");
        System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
        optionChoosed = in.nextInt();
        in.nextLine();

        while (optionChoosed != 3) {

            switch (optionChoosed) {

                case 1 -> {
                    controller.createNewAccount();
                    this.menuWhenUserLogged();
                }
                case 2 -> {
                    controller.login();
                    this.menuWhenUserLogged();
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
        }
        in.close();
        System.out.println("Saindo...");
        Runtime.getRuntime().exit(0);
    }

    // segundo menu após a tela de login
    public void menuWhenUserLogged() {
        Scanner in = new Scanner(System.in);

        int optionChoosed;

        System.out.println("|  1 - Editar Login/Senha  |  2 - Add/Seguir Amigos  |  3 - Enviar Mensagem  |  4 - Sair  |");
        optionChoosed = in.nextInt();
        in.nextLine();
        while (optionChoosed != 4) {

            switch (optionChoosed) {
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                    followAndShowFriends();
                }
                case 4 -> {
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
            this.menuWhenUserLogged();
            optionChoosed = in.nextInt();
            in.nextLine();
        }
        System.out.println("Redirecionandopara o menu...");
        this.mainTitle();
        in.close();
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
                    while (!controller.checkLoginAlreadyExist(loginFriend)) {
                        System.out.println("Login não encontrado ou não existente! Tente novamente: ");
                        loginFriend = in.nextLine();
                    }
                    controller.currentUser.inviteFriend(loginFriend);
                    System.out.println("Solicitação de amizade enviada, aguarde ser aceita!");
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
            this.followAndShowFriends();
        }
        this.menuWhenUserLogged();
    }
}
