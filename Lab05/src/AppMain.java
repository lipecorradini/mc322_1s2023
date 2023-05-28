import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AppMain {


    public static void appMain(String[] args) {


       // Chamando o menu estático
       // MenuEstatico menuEstatico = new MenuEstatico();
       // menuEstatico.GerarMenuEstatico();

        // Chamando o menu dinamico
        MenuInterativo menuInterativo = new MenuInterativo();
        menuInterativo.GerarMenuInterativo();
        //MenuInterativo(listaClientes, listaSeguradora, seguradora);

    }
}
