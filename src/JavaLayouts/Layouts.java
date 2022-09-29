package JavaLayouts;

 import java.util.Scanner;

import JavaActivity.*;

// classe para gráficos
public class Layouts {

    public void mainTitle() {
        Scanner in = new Scanner(System.in);

        Home verHome = new Home();
        int optionChoosed = 0;

        System.out.println("");
        System.out.println(" |               > SOCIAL PEOPLE <              | ");   
        System.out.println(" |  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
        System.out.print(" | ");
        optionChoosed = in.nextInt(); in.nextLine();

        while(optionChoosed != 3) {

            switch(optionChoosed) {

                case 1: verHome.createNewAccount();
                break;

                case 2: 
                break;

                default: System.out.println("Opção inválida, tente novamente: ");
            }
        }

        in.close();
        System.out.println("Saindo...");
        Runtime.getRuntime().exit(0);
    }
}
