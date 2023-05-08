import java.util.Scanner;
import java.util.*;
public class AppMain {

    public static void appMain(String[] args){

        System.out.println("Olá, seja bem vindo à seguradora!");
        System.out.println("Digite o número correto para a respectiva ação:");
        System.out.println("1) Cadastros \n2) Listar \n3) Excluir \n4) Gerar Sinistro");
        System.out.println("5) Transferir Seguro \n6) Calcular receita Seguradora \n0) Sair");

        Scanner comando = new Scanner(System.in);
        int operacao = comando.nextInt();
        comando.close();

        switch(operacao){

            case 1: // fazer a conexao com o menu de operacoes
                System.out.println("1) Cadastrar Cliente PF/PJ\n 2) Cadastrar Veículos\n 3) Cadastrar Seguradora\n 4) Voltar");
                Scanner novoComando = new Scanner(System.in);
                int novaOperacao = comando.nextInt();
                novoComando.close();

            case 2:
                System.out.println("1) Listar Cliente PF/PJ por Seguradora\n 2) Listar Sinistros por Seguradora\n");
                System.out.println("3) Listar Sinistro por Cliente\n 4) Listar Veículo por Cliente\n 5) Listar Veículo por Seguradora\n 6) Voltar");

            case 3:
                System.out.println("1) Excluir Cliente \n 2) Excluir Veículo\n 3) Excluir Sinistro\n 4) Voltar");


            
        }


    }
}
