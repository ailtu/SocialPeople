package JavaLayouts;

 import java.util.Scanner;

import JavaActivity.*;

// classe para gráficos
public class Layouts {

    public void viewMainTitle() {
        Scanner in = new Scanner(System.in);

        Home verHome = new Home();
        int optionChoosed = 0;

        System.out.println("|               > SOCIAL PEOPLE <              | ");   
        System.out.println("|  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
        optionChoosed = in.nextInt(); in.nextLine();

        while(optionChoosed != 3) {

            switch(optionChoosed) {

                case 1: verHome.createNewAccount();
                        viewMenuWhenUserLogged();
                break;

                case 2: verHome.login();
                        viewMenuWhenUserLogged();
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

        System.out.println("|  1 - Função1  |  2 - Função2  |  3 - Função3  | ");
        optionChoosed = in.nextInt(); in.nextLine();
        while(optionChoosed !=  2) {

            switch(optionChoosed) {

                case 1:
                break;

                default: System.out.println("Opção inválida, tente novamente: ");
            }

        }
        
        in.close();
    }

}
