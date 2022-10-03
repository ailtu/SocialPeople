package JavaLayouts;

 import java.util.Scanner;

import JavaActivity.*;

// classe para gráficos
public class Layouts {

    private Home verHome;

    public Layouts(Home vH) {
        this.verHome = vH;
    }

    public void viewMainTitle() {
        Scanner in = new Scanner(System.in);

        int optionChoosed = 0;

        System.out.println("|               > SOCIAL PEOPLE <              | ");   
        System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
        optionChoosed = in.nextInt(); in.nextLine();

        while(optionChoosed != 3) {

            switch(optionChoosed) {

                case 1: verHome.createNewAccount();
                        this.viewMenuWhenUserLogged();
                break;

                case 2: verHome.login();
                        this.viewMenuWhenUserLogged();
                break;

                default: System.out.println("Opção inválida, tente novamente: ");
            }
        }

        in.close();
        System.out.println("Saindo...");
        Runtime.getRuntime().exit(0);
    }

    public void viewMenuWhenUserLogged() {
        Scanner in = new Scanner(System.in);
       
        int optionChoosed = 0;

        System.out.println("|  1 - Editar Login/Senha  |  2 - Add/Seguir Amigos  |  3 - Enviar Mensagem  |  4 - Sair  |");
        optionChoosed = in.nextInt(); in.nextLine();
        while(optionChoosed != 4) {

            Home showHomeMenus = new Home();

            switch(optionChoosed) {

                case 1: showHomeMenus.editProfile();
                break;

                case 2: showHomeMenus.followAndShowFriends();
                break;

                case 3: showHomeMenus.sendMessages();
                break;

                default: System.out.println("Opção inválida, tente novamente: ");
            }
            this.viewMenuWhenUserLogged();
            optionChoosed = in.nextInt(); in.nextLine();
        }

        System.out.println("Redirecionandopara o menu...");
        this.viewMainTitle();
        
        in.close();
    }

}
