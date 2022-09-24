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
        System.out.println(teste);
 


    // entrada de dados e limpeza do buffer
    optionChoosed = in.nextInt(); in.nextLine();

    in.close();

    }

}
