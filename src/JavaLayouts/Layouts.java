package JavaLayouts;

import java.util.Scanner;

import JavaActivity.Home;

// classe para gráficos
public class Layouts {

    private Scanner in = new Scanner(System.in);
    private  Home controller;

    public Layouts(Home viewController) {
        controller = viewController;
    }

    // ver o menu principal
    public void mainTitle() {

        System.out.println("|               > SOCIAL PEOPLE <              | ");
        System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
        System.out.print("| ");
        int optionChoosed = in.nextInt(); in.nextLine();

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
        System.out.println("Saindo...");
        Runtime.getRuntime().exit(0);
    }

    // segundo menu após a tela de login
    public void menuWhenUserLogged() {

        System.out.println("| O que deseja fazer " + controller.currentUser.getLogin() + "? ");
        System.out.println("|  1 - Editar Login/Senha  |  2 - Add/Seguir Amigos  |  3 - Enviar Mensagem  |  4 - Sair  |");
        System.out.print("| ");
        int optionChoosed = in.nextInt(); in.nextLine();

        while (optionChoosed != 4) {
            switch (optionChoosed) {
                case 1 -> {
                    // controller.editProfile();
                }
                case 2 -> {
                    followFriends();
                }
                case 3 -> {
                    // controller.messageSystem();
                }
                default -> System.out.println("Opção inválida, tente novamente: ");
            }
            this.menuWhenUserLogged();
            optionChoosed = in.nextInt();
        }
        System.out.println("Redirecionando para o menu...");
    }

    public void followFriends() {

        System.out.println("|  1 - Seguir amigo  |  2 - Voltar   |");
        System.out.print("| ");
        int optionChoosed = in.nextInt(); in.nextLine();

        while (optionChoosed != 2) {
            if (optionChoosed == 1) {
                String loginFriend = in.nextLine();
                while (!controller.checkLoginAlreadyExist(loginFriend)) {
                    System.out.println("Login não encontrado ou não existente! Tente novamente: ");
                    loginFriend = in.nextLine();
                }
                controller.currentUser.inviteFriend(loginFriend);
                System.out.println("Solicitação de amizade enviada, aguarde ser aceita!");
            } else {
                System.out.println("Opção inválida, tente novamente: ");
            }
            this.followFriends();
        }
        this.menuWhenUserLogged();
    }
}
