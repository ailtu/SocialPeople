package JavaLayouts;

 import java.util.Scanner;

// classe para gráficos
public class Layouts {

    public void mainTitle() {
        Scanner in = new Scanner(System.in);

        int optionChoosed = 0;

        // layout da páina com esse caractere
        System.out.println("    ▰▰▰▰▰ ▰▰▰▰▰ ▰▰▰▰   ▰  ▰▰▰▰▰  ▰         ▰▰▰▰▰  ▰▰▰▰▰  ▰▰▰▰▰  ▰▰▰▰▰  ▰      ▰▰▰▰▰ ");
        System.out.println("   ▰        ▰     ▰ ▰         ▰  ▰     ▰  ▰         ▰      ▰  ▰         ▰     ▰  ▰     ▰  ▰      ▰         ");
        System.out.println("  ▰▰▰▰▰ ▰     ▰ ▰         ▰  ▰▰▰▰▰  ▰         ▰ ▰ ▰    ▰▰▰      ▰     ▰  ▰ ▰ ▰   ▰      ▰▰▰      ");
        System.out.println("        ▰ ▰     ▰ ▰         ▰  ▰      ▰  ▰         ▰         ▰          ▰     ▰  ▰        ▰      ▰           ");
        System.out.println("▰▰▰▰▰ ▰▰▰▰▰ ▰▰▰▰▰  ▰  ▰      ▰  ▰▰▰▰    ▰         ▰▰▰▰▰   ▰▰▰▰▰  ▰       ▰▰▰▰ ▰▰▰▰▰    ");
        System.out.println("");
        
        System.out.println(" |  1 - Cadastre-se  |  2 - Login  |  3 - Sair  | ");
        optionChoosed = in.nextInt(); in.nextLine();

        while(optionChoosed != 3) {

            switch(optionChoosed) {

                case 1: 
                break;

                case 2: 
                break;

                case 3: System.out.println("Saindo...");
                        Runtime.getRuntime().exit(0);
                break;

                default: System.out.println("Opção inválida, tente novamente: ");
            }
        }
        in.close();
    }

}
