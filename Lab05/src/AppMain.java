public class AppMain {

    public static void appMain(String[] args) {

       // Chamando o menu estático
       MenuEstatico menuEstatico = new MenuEstatico();
       menuEstatico.GerarMenuEstatico();

        // Chamando o menu dinamico
        MenuInterativo menuInterativo = new MenuInterativo();
        menuInterativo.GerarMenuInterativo();

    }
}
