import java.time.LocalDate;
import java.util.ArrayList;

public class MenuEstatico {

    public MenuEstatico() {
    }

    public void GerarMenuEstatico() {

        /*
         * Classe para mostrar as instanciações estáticas do menu
         */

        // Criando o Cliente PF
        ClientePF clientePF = new ClientePF("Luiz Felipe Costa", "Rua Francisco Humberto Zuppi, 27",
                "Ensino Médio Completo", "Masculino", "120.102.984-89", LocalDate.of(2004, 4, 10), "(81)99728-2004",
                "luizfelipecorradini@gmail.com");

        // Validando o CPF do cliente PF
        System.out.println("----------- Validando o CPF -----------");
        boolean validador;
        validador = Validacao.validarCPF(clientePF.getCpf());
        System.out.println("O cpf é válido: " + validador);

        // Criando o cliente PJ
        ClientePJ clientePJ = new ClientePJ("Apple Inc.", "Silicon Valley, USA", LocalDate.now(),
                "32.001.336/0001-65", LocalDate.of(1973, 12, 1), "(11)99999-9989", "apple@apple.com", 1560);

        // Validando CNPJ do cliente PJ
        System.out.println("----------- Validando o CNPJ -----------");
        validador = Validacao.validarCNPJ(clientePJ.getCNPJ());
        System.out.println("o cnpj é válido: " + validador);

        // Adicionando um veiculo para o cliente PF
        System.out.println("----------- Adicionando os veículos -----------");
        Veiculo carroPf = new Veiculo("NNT-4I21", "Suzuki", "Gran Vitara", 2012);
        clientePF.cadastrarVeiculos(carroPf);
        clientePF.listarVeiculos();

        // Adicionando uma frota para o cliente PJ
        Frota frota = new Frota();
        Veiculo carroPj = new Veiculo("QLK-8C00", "Jeep", "Compass", 2018);
        frota.addVeiculo(carroPj);
        clientePJ.cadastrarFrota(frota);
        clientePJ.listarVeiculos();

        // Cadastrando Seguradora
        Seguradora seguradora = new Seguradora("32.001.336/0001-65", "Safety Seguradora", "(81)3361-6502",
                "safetyseguradora@gmail.com", "Av Orosimbo Maia, 2354");

        // Cadastrando o primeiro cliente

        System.out.println("----------- Cadastrando os clientes -----------");
        seguradora.cadastrarCliente(clientePF);

        // Cadastrando o segundo cliente
        seguradora.cadastrarCliente(clientePJ);

        // Gerando dois Condutores
        System.out.println("\n----------- Gerando os Condutores -----------");

        Condutor condutor1 = new Condutor("120.102.984-89", "Luiz Felipe Costa", "(81)99728-2004",
                "Rua Francisco Humberto Zuppi, 27",
                "luizfelipecorradini@gmail.com", LocalDate.of(2004, 04, 10));

        Condutor condutor2 = new Condutor("120.102.774-81", "Gabriela Costa", "(81)99715-1002",
                "Av Visconde de Jequitinhonha, 1360", "gabriela.corradini@gmail.com", LocalDate.of(2007, 9, 19));

        // Gerando SeguroPF e SeguroPJ
        System.out.println("\n----------- Gerando os Seguros -----------");

        seguradora.gerarSeguro(); // Para escolher o Cliente PF
        seguradora.gerarSeguro(); // Para escolher o Cliente PJ

        SeguroPF seguro1 = ((SeguroPF) (seguradora.getListaSeguro().get(0)));
        SeguroPJ seguro2 = ((SeguroPJ) (seguradora.getListaSeguro().get(1)));

        // Criando um Sinistro para cada Condutor ( já adiciona automaticamente ao
        // condutor)

        System.out.println("\n----------- Gerando os Sinistros -----------");


        seguro1.gerarSinistro(condutor1, "Av Brasil");
        seguro2.gerarSinistro(condutor2, "Av Paulista");

        // ToString de todos os objetos instanciados:
        System.out.println(clientePF.toString()+
        clientePJ.toString()+
        carroPf.toString()+
        frota.toString()+
        seguradora.toString()+
        condutor1.toString()+
        seguro1.toString());
        

    }
}