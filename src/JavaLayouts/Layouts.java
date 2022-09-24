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
        System.out.println(" |  1 - Cadastra-se  |  2 - Login  |  3 - Sair  | ");

        optionChoosed = in.nextInt(); in.nextLine();
        

        
        in.close();
    }

}
