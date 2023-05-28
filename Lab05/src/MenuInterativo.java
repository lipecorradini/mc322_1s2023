import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuInterativo {
    /*
     * Chama o menu interativo em loop até a validação ser falsa
     * 
     */
    public MenuInterativo() {
    }

    public void GerarMenuInterativo() {

        Scanner sc = new Scanner(System.in);

        Seguradora seguradora = new Seguradora("36.495.490/0001-91", "Safety Seguradora", "(81)3361-6502",
                "safetyseguradora@gmail.com", "Av Orosimbo Maia, 2354");

        ArrayList<Seguradora> listaSeguradora = new ArrayList<Seguradora>();
        Seguradora seguradoraEscolhida = seguradora;

        listaSeguradora.add(seguradora);
        boolean validacaoContinuar = true;
        do{
            int cont = 1;
            System.out.println("---------- SELECIONANDO SEGURADORA -----------");

            System.out.println("Digite o número referente à Seguradora desejada: ");
            for(Seguradora seguradoraIterada : listaSeguradora){
                System.out.println(cont + ") " + seguradoraIterada.getNome());
                cont ++;
            }
            int indiceSeguradora = sc.nextInt();
            seguradoraEscolhida = listaSeguradora.get(indiceSeguradora - 1);
            ExecutarOperacao(listaSeguradora, seguradoraEscolhida, validacaoContinuar);

        } while (validacaoContinuar);
    }

    public void ExecutarOperacao(ArrayList<Seguradora> listaSeguradora, Seguradora seguradora,
            boolean validacaoContinuar) {
        /*
         * Executa as operações do menu dinâmico
         * 
         */

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Começando o menu interativo
        System.out.println("---------- MENU DE OPERAÇÕES----------");

        System.out.println("Olá, seja bem vindo à seguradora!");
        System.out.println("Digite o número correto para a respectiva ação:");
        System.out.println("1) Cadastros \n2) Listar \n3) Excluir \n4) Gerar Sinistro");
        System.out.println("5) Gerar Seguro \n6) Transferir Seguro\n7) Calcular receita Seguradora \n0) Sair");
        System.out.println("---------------------------------------------------");

        double operacao = sc.nextDouble();
        sc.nextLine();
        MenuOperacoes comandoMenu = MenuOperacoes.retornarComando(operacao);

        switch (comandoMenu) {

            case CADASTRAR: // cadastos
                System.out.println("---------- CADASTRO -----------");

                double operacaoCadastrar = 0;

                System.out.println(
                        "1) Cadastrar Cliente PF/PJ\n2) Cadastrar Veículos\n3) Cadastrar Seguradora\n4) Cadastrar Frota (PJ)\n5) Cadastrar Condutor \n6) Voltar");
                System.out.println("---------------------------------------------------");
                operacaoCadastrar = sc.nextDouble();
                sc.nextLine();

                double cadastrarMenuFracionado = operacao + operacaoCadastrar / 10;
                MenuOperacoes cadastrarMenu = MenuOperacoes.retornarComando(cadastrarMenuFracionado);

                // fazer as instrucoes para cada um dos
                switch (cadastrarMenu) {

                    case CADASTRAR_CLIENTE:
                        // cadastrar cliente pf/pj
                        System.out.println("1) Cliente Pessoa Física\n2) Cliente Pessoa Jurídica ");
                        int tipoCliente = sc.nextInt();
                        sc.nextLine();

                        System.out.println("- Nome do Cliente/Empresa (usar _ ao invés de espaços): ");
                        String nome = sc.nextLine();
                        boolean ehValido = Validacao.validarNome(nome);
                        if (!ehValido) {
                            System.out.println("O nome não é válido! ");
                            // sc.close();
                            break;
                        }

                        System.out.println("- Endereço do Cliente/Empresa: ");
                        String endereco = sc.nextLine();

                        System.out.println("- Data da licença [dd/MM/yyyy]: ");
                        String str = sc.nextLine();
                        LocalDate datadaLicenca = LocalDate.parse(str, dtf);

                        System.out.println("- Telefone do Cliente/Empresa: ");
                        String telefone = sc.nextLine();

                        System.out.println("- Email do Cliente/Empresa: ");
                        String email = sc.nextLine();

                        switch (tipoCliente) {

                            case 1:
                                System.out.println("Digite o grau de Educação: ");
                                String educacao = sc.nextLine();

                                System.out.println("Digite o Gênero: ");
                                String genero = sc.nextLine();

                                System.out.println("Digite o CPF: ");
                                String cpf = sc.nextLine();

                                System.out.println("Data de Nascimento [dd/MM/yyyy]: ");
                                String dataNascimento = sc.nextLine();
                                LocalDate dataNascimentoDate = LocalDate.parse(dataNascimento, dtf);

                                ClientePF clientePf = new ClientePF(nome, endereco, educacao, genero, cpf,
                                        dataNascimentoDate, telefone, email);
                                seguradora.cadastrarCliente(clientePf);

                                break;

                            case 2:
                                System.out.println("CNPJ: ");
                                String cnpj = sc.nextLine();

                                System.out.println("Data de Fundação [dd/MMM/yyyy]: ");
                                String dataFundacao = sc.nextLine();
                                LocalDate dataFundacaoDate = LocalDate.parse(dataFundacao, dtf);

                                System.out.println(" Quantidade de Funcionários: ");
                                int qtdeFuncionarios = sc.nextInt();
                                sc.nextLine();

                                ClientePJ clientePj = new ClientePJ(nome, endereco, datadaLicenca, cnpj,
                                        dataFundacaoDate, telefone, email, qtdeFuncionarios);
                                seguradora.cadastrarCliente(clientePj);

                                break;

                        }
                        break;

                    case CADASTRAR_VEICULO:

                        System.out.println("Placa: ");
                        String placa = sc.nextLine();

                        System.out.println("Marca: ");
                        String marca = sc.nextLine();

                        System.out.println("Modelo: ");
                        String modelo = sc.nextLine();

                        System.out.println("Ano de Fabricação: ");
                        int anoFabricacao = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Qual o tipo de Cliente? [PF/PJ] ");
                        String tipoDoCliente = sc.nextLine();

                        Veiculo veiculoCadastrado = new Veiculo(placa, marca, modelo, anoFabricacao);

                        switch (tipoDoCliente) {

                            case "PF":
                                System.out.println("CPF do Cliente: ");
                                String cpfCliente = sc.nextLine();

                                for (Cliente cliente : seguradora.getListaClientes()) {
                                    if (cliente instanceof ClientePF
                                            && ((ClientePF) (cliente)).getCpf().equals(cpfCliente)) {
                                        ((ClientePF) (cliente)).cadastrarVeiculos(veiculoCadastrado);
                                    }
                                }
                                break;

                            case "PJ":

                                System.out.println("CNPJ do Cliente: ");
                                String cnpjCliente = sc.nextLine();

                                for (Cliente cliente : seguradora.getListaClientes()) {
                                    if (cliente instanceof ClientePJ
                                            && ((ClientePJ) (cliente)).getCNPJ().equals(cnpjCliente)) {
                                        ((ClientePJ) (cliente)).atualizarFrota(veiculoCadastrado);
                                    }
                                }
                                break;

                        }

                        break;

                    case CADASTRAR_SEGURADORA:

                        System.out.println("Nome: ");
                        String nomeSeguradora = sc.nextLine();

                        System.out.println("CNPJ da Seguradora: ");
                        String cnpjSeguradora = sc.nextLine();

                        System.out.println("Telefone: ");
                        String telefoneSeguradora = sc.nextLine();

                        System.out.println("Email: ");
                        String emailSeguradora = sc.nextLine();

                        System.out.println("Endereco: ");
                        String enderecoSeguradora = sc.nextLine();

                        Seguradora seguradoraNova = new Seguradora(cnpjSeguradora, nomeSeguradora, telefoneSeguradora,
                                emailSeguradora, enderecoSeguradora);
                        listaSeguradora.add(seguradoraNova);

                        System.out.println(
                                "Seguradora de nome " + nomeSeguradora + " cadastrada em nosso sistema!");
                        break;

                    case CADASTRAR_FROTA:

                        System.out.println("CNPJ do cliente Pessoa Jurídica: ");
                        String cnpjClienteFrota = sc.nextLine();

                        Frota frotaCadastrada = new Frota();

                        for (Cliente cliente : seguradora.getListaClientes()) {
                            if (cliente instanceof ClientePJ
                                    && ((ClientePJ) (cliente)).getCNPJ().equals(cnpjClienteFrota)) {
                                ((ClientePJ) (cliente)).cadastrarFrota(frotaCadastrada);
                            }
                        }

                        break;

                    case CADASTRAR_CONDUTOR:

                        System.out.println("Nome: ");
                        String nomeCondutor = sc.nextLine();

                        System.out.println("CPF do Condutor: ");
                        String cpfCondutor = sc.nextLine();

                        System.out.println("Telefone: ");
                        String telefoneCondutor = sc.nextLine();

                        System.out.println("Email: ");
                        String emailCondutor = sc.nextLine();

                        System.out.println("Endereco: ");
                        String enderecoCondutor = sc.nextLine();

                        System.out.println("Data de Nascimento [dd/MMM/yyyy]: ");
                        String dataNascimentoCondutor = sc.nextLine();
                        LocalDate dataNascimentoCondutorDate = LocalDate.parse(dataNascimentoCondutor, dtf);
                        
                        Seguro seguro = seguradora.escolherSeguro();
                        Condutor condutor = new Condutor(cpfCondutor, nomeCondutor, telefoneCondutor, enderecoCondutor, emailCondutor, dataNascimentoCondutorDate);
                        seguro.cadastrarCondutor(condutor);


                    case SAIR_CADASTRAR:

                        break;
                }

                break;

            case LISTAR:
                System.out.println("---------- LISTAGEM -----------");

                System.out.println("1) Listar Cliente PF/PJ por Seguradora\n2) Listar Sinistros por Seguradora");
                System.out.println(
                        "3) Listar Sinistro por Cliente\n4) Listar Veículo por Cliente\n5) Listar Veículo por Seguradora\n6) Listar Seguro Por Cliente \n7) Voltar");

                double operacaoListar = sc.nextDouble();
                sc.nextLine();

                double listarMenuFracionado = operacao + operacaoListar / 10;
                MenuOperacoes listarMenu = MenuOperacoes.retornarComando(listarMenuFracionado);

                switch (listarMenu) {

                    case LISTAR_CLIENTE_POR_SEGURADORA:
                        // Listar os clientesPF e clientesPJ por seguradora
                        System.out.println("Quais tipos de Cliente quer listar? \n1) ClientePF \n2) ClientePJ]");
                        int tipoCliente = sc.nextInt();
                        sc.nextLine();

                        switch (tipoCliente) {

                            case 1:
                                for (Seguradora seguradoraIterada : listaSeguradora) {
                                    seguradoraIterada.listarClientes("ClientePF");
                                }
                                break;

                            case 2:
                                for (Seguradora seguradoraIterada : listaSeguradora) {
                                    seguradoraIterada.listarClientes("ClientePJ");
                                }
                                break;
                        }
                        break;

                    case LISTAR_SINISTRO_POR_SEGURADORA:

                        // Listar os Sinistros por Seguradora
                        for (Seguradora seguradoraIterada : listaSeguradora) {
                            System.out.println(seguradoraIterada.getNome() + ": ");
                            for (Seguro seguro : seguradora.getListaSeguro()) {
                                seguro.listarSinistros();
                            }
                            System.out.println("\n");
                        }

                        break;

                    case LISTAR_SINISTRO_POR_CLIENTE:

                        seguradora.getSinistrosPorCliente();
                        break;

                    case LISTAR_VEICULO_POR_CLIENTE:
                        // Listar Veículo por Cliente
                        for (Cliente clienteIterado : seguradora.getListaClientes()) {
                            System.out.println(clienteIterado.getNome() + ": ");
                            clienteIterado.listarVeiculos();
                            System.out.println("--------------------");
                        }
                        break;

                    case LISTAR_VEICULO_POR_SEGURADORA:
                        // Listar Veículos por Seguradora
                        for (Seguradora seguradoraIterada : listaSeguradora) {
                            System.out.println(seguradoraIterada.getNome() + ": ");
                            for (Cliente clienteVeiculo : seguradoraIterada.getListaClientes()) {
                                clienteVeiculo.listarVeiculos();
                            }
                        }
                        break;

                    case LISTAR_SEGURO_POR_CLIENTE:
                        seguradora.getSegurosPorCliente();
                        break;

                    case SAIR_LISTAR:

                        break;
                }
                break;

            case EXCLUIR:

                System.out.println("---------- EXCLUIR -----------");

                System.out.println(
                        "1) Excluir Cliente \n2) Excluir Veículo\n3) Excluir Sinistro\n4) Excluir Seguro \n5) Excluir Condutor \n6) Excluir Frota\n7) Voltar");

                double operacaoExcluir = sc.nextDouble();
                sc.nextLine();
                double excluirMenuFracionado = operacao + operacaoExcluir / 10;
                MenuOperacoes excluirMenu = MenuOperacoes.retornarComando(excluirMenuFracionado);

                switch (excluirMenu) {

                    case EXCLUIR_CLIENTE:

                        seguradora.removerCliente();

                        break;

                    case EXCLUIR_VEICULO:

                        System.out.println("Digite o nome do dono do veículo: ");
                        String nomeExcluido = sc.nextLine();

                        for (Cliente clienteIterado : seguradora.getListaClientes()) {
                            if (clienteIterado instanceof ClientePF
                                    && ((ClientePF) (clienteIterado)).getNome().equals(nomeExcluido)) {
                                ((ClientePF) (clienteIterado)).removerVeiculos();
                            } else if (clienteIterado instanceof ClientePJ
                                    && ((ClientePJ) (clienteIterado)).getNome().equals(nomeExcluido)) {
                                Veiculo veiculoExcluido = ((ClientePJ) (clienteIterado)).escolherFrota()
                                        .escolherVeiculo();
                                System.out.println(
                                        "Agora, escolha novamente a frota que deseja remover o veículo, por favor: ");
                                ((ClientePJ) (clienteIterado)).atualizarFrota(veiculoExcluido);
                            }
                        }

                        break;

                    case EXCLUIR_SINISTRO:

                        System.out.println("Digite o nome do cliente associado ao Sinistro que quer remover: ");
                        String nomeExcluidoSinistro = sc.nextLine();

                        for (Seguro seguroIterado : seguradora.getListaSeguro()) {
                            if (seguroIterado instanceof SeguroPF && ((SeguroPF) (seguroIterado)).getCliente().getNome()
                                    .equals(nomeExcluidoSinistro)) {
                                seguroIterado.excluirSinistro();

                            } else if (seguroIterado instanceof SeguroPJ && ((SeguroPJ) (seguroIterado)).getCliente()
                                    .getNome().equals(nomeExcluidoSinistro)) {
                                seguroIterado.excluirSinistro();
                            }
                        }

                        break;

                    case EXCLUIR_SEGURO:

                        seguradora.cancelarSeguro();
                        break;

                    case EXCLUIR_CONDUTOR:

                        seguradora.escolherSeguro().excluirCondutor();
                        break;

                    case EXCLUIR_FROTA:

                        System.out.println("Digite o CNPJ do cliente associado à frota que quer remover: ");
                        String cnpjExcluidoFrota = sc.nextLine();

                        for (Cliente cliente : seguradora.getListaClientes()) {
                            if (cliente instanceof ClientePJ
                                    && ((ClientePJ) (cliente)).getCNPJ().equals(cnpjExcluidoFrota)) {
                                ((ClientePJ) (cliente)).atualizarFrota();
                            }
                        }

                    case SAIR_EXCLUIR:

                        break;

                }
                break;

            case GERAR_SINISTRO:
                System.out.println("---------- GERAR SINISTRO -----------\n");

                Seguro seguroEscolhidoSinistro = seguradora.escolherSeguro();

                Condutor condutorEscolhidoSinistro = seguroEscolhidoSinistro.escolherCondutor();

                System.out.println("Digite o endereço que ocorreu o Sinistro: ");
                String enderecoSinistro = sc.nextLine();

                seguroEscolhidoSinistro.gerarSinistro(condutorEscolhidoSinistro, enderecoSinistro);

                break;

            case GERAR_SEGURO:

                seguradora.gerarSeguro();

                break;

            case TRANSFERIR_SEGURO:

                System.out.println("---------- TRANSFERÊNCIA DE SEGURO -----------\n");

                System.out.println("Digite o nome do Cliente de quem deseja transferir o Seguro: ");
                String nomeClienteRemetente = sc.nextLine();

                for (Seguro seguro : seguradora.getListaSeguro()) {
                    if (seguro instanceof SeguroPF
                            && ((SeguroPF) (seguro)).getCliente().getNome().equals(nomeClienteRemetente)) {
                        ((SeguroPF) (seguro)).setCliente((ClientePF) (seguradora.escolherCliente()));
                        System.out.println("Seguro transferido com sucesso!");

                    } else if (seguro instanceof SeguroPJ
                            && ((SeguroPJ) (seguro)).getCliente().getNome().equals(nomeClienteRemetente)) {
                        ((SeguroPJ) (seguro)).setCliente((ClientePJ) (seguradora.escolherCliente()));
                        System.out.println("Seguro transferido com sucesso!");

                    }
                }
                break;

            case CALCULAR_RECEITA_SEGURADORA:
                System.out.println("---------- CALCULANDO RECEITA SEGURADORA -----------");

                seguradora.calcularReceita();
                break;

            case SAIR:
                validacaoContinuar = false;
                System.exit(0);
        }

    }

}
