package MainActivity;

import JavaActivity.*;
import JavaLayouts.Layouts;

public class Main {
    public static void main(String[] args) {

        /* EXECUTE AQUI! */
        Layouts triggerLayouts = new Layouts();
        triggerLayouts.desingLayout();

        Home triggerHome = new Home();
        triggerHome.mainTitle();
    }
}
