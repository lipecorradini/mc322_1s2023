import java.time.LocalDate;
import java.util.ArrayList;

public class MenuEstatico {

    public void MenuEstatico(ArrayList<Cliente> listaClientes, ArrayList<Seguradora> listaSeguradora, Seguradora seguradora) {
        
        // Criando o cliente PF
        ClientePF clientePF = new ClientePF("jorge", "rua boa viagem, 55", LocalDate.now(), "ensino médio",
                "masculino", "média-alta", "120.102.984-89", LocalDate.of(1977, 3, 27), 0);

        // Validando o cpf do cliente PF
        System.out.println("----------- Validando o CPF -----------");
        boolean validador;
        validador = Validacao.validarCPF("494.996.278-71");
        System.out.println("O cpf é válido: " + validador);

        // Criando o cliente PJ
        ClientePJ clientePJ = new ClientePJ("apple", "silicon valley", LocalDate.now(), "32.001.336/0001-65",
                LocalDate.of(1952, 3, 23), 15, 0);

        // Validando CNPJ do cliente PJ
        System.out.println("----------- Validando o CNPJ -----------");
        validador = Validacao.validarCNPJ("32.001.336/0001-65");
        System.out.println("o cnpj é válido: " + validador);

        

        // Adicionando um veiculo para o cliente PF
        System.out.println("----------- Adicionando os veículos -----------");
        Veiculo carroPf = new Veiculo("NNT-4I21", "Suzuki", "Gran Vitara", 2012);
        clientePF.cadastrarVeiculos(carroPf);
        clientePF.listarVeiculos();

        // Adicionando um veículo para o cliente PJ
        Veiculo carroPj = new Veiculo("QLK-8C00", "Jeep", "Compass", 2018);
        clientePJ.cadastrarVeiculos(carroPj);
        clientePF.listarVeiculos();

        // Cadastrando o primeiro cliente
        System.out.println("----------- Cadastrando os clientes -----------");
        validador = seguradora.cadastrarCliente(clientePF); // remover ele depois
        System.out.println("O cliente PF foi cadastrado: " + validador);

        // Cadastrando o segundo cliente
        validador = seguradora.cadastrarCliente(clientePJ); // remover ele depois
        System.out.println("O cliente PJ foi cadastrado: " + validador);

        // Gerando um sinistro
        System.out.println("----------- Gerando os sinsitros -----------");
        Sinistro sinistro = new Sinistro(LocalDate.now(), "rua zuppi, 27", seguradora, carroPj, clientePJ);
        System.out.println(sinistro.toString());

        // instanciando a lista de clientes

        listaClientes = seguradora.getListaClientes();

        // Chamando os métodos listarSinistros e visualizarSinistro da Seguradora
        seguradora.gerarSinistro(carroPj, clientePJ);
        seguradora.gerarSinistro(carroPf, clientePF);

        seguradora.visualizarSinistro(clientePJ.toString());
        seguradora.visualizarSinistro(clientePF.toString());

        double valorSeguroPF = seguradora.calcularPrecoSeguroCliente(clientePF);
        System.out.println("valor seguro pf: " + valorSeguroPF);
        double valorSeguroPJ = seguradora.calcularPrecoSeguroCliente(clientePJ);
        System.out.println("valor seguro pj: " + valorSeguroPJ);

        seguradora.calcularReceita();

    }

}
