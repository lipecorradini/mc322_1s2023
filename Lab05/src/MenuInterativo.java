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

        Seguradora seguradora = new Seguradora("36.495.490/0001-91", "Safety Seguradora", "(81)3361-6502",
                "safetyseguradora@gmail.com", "Av Orosimbo Maia, 2354");

        ArrayList<Seguradora> listaSeguradora = new ArrayList<Seguradora>();

        listaSeguradora.add(seguradora);
        boolean validacaoContinuar = true;
        while (validacaoContinuar) {
            ExecutarOperacao(listaSeguradora, seguradora, validacaoContinuar);
        }
    }

    public void ExecutarOperacao(ArrayList<Seguradora> listaSeguradora,  Seguradora seguradora , boolean validacaoContinuar) {
        /*
         * Executa as operações do menu dinâmico
         * 
         */

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Começando o menu interativo
        System.out.println("---------- COMEÇANDO O MENU ----------");

        System.out.println("Olá, seja bem vindo à seguradora!");
        System.out.println("Digite o número correto para a respectiva ação:");
        System.out.println("1) Cadastros \n2) Listar \n3) Excluir \n4) Gerar Sinistro");
        System.out.println("5) Transferir Seguro \n6) Calcular receita Seguradora \n0) Sair");
        System.out.println("---------------------------------------------------");

        double operacao = sc.nextDouble();
        sc.nextLine();
        MenuOperacoes comandoMenu = MenuOperacoes.retornarComando(operacao);

        switch (comandoMenu) {

            case CADASTRAR: // cadastos
                System.out.println("---------- CADASTRO -----------");

                double operacaoCadastrar = 0;

                System.out.println(
                        "1) Cadastrar Cliente PF/PJ\n2) Cadastrar Veículos\n3) Cadastrar Seguradora\n4) Cadastrar Frota (PJ)");
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

                        System.out.println("- Nome do Cliente/Empresa: ");
                        String nome = sc.nextLine();
                        boolean ehValido = Validacao.validarNome(nome);
                        if (!ehValido) {
                            System.out.println("O nome não é válido! ");
                            //sc.close();
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

                                ClientePF clientePf = new ClientePF(nome, endereco, educacao, genero, cpf, dataNascimentoDate, telefone, email);   
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

                                ClientePJ clientePj = new ClientePJ(nome, endereco, datadaLicenca, cnpj, dataFundacaoDate, telefone, email, qtdeFuncionarios);
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


                        switch(tipoDoCliente){
                            
                            case "PF":
                                System.out.println("CPF do Cliente: ");
                                String cpfCliente = sc.nextLine();

                                for( Cliente cliente : seguradora.getListaClientes()){
                                    if(cliente instanceof ClientePF && ((ClientePF)(cliente)).getCpf().equals(cpfCliente)){
                                        ((ClientePF)(cliente)).cadastrarVeiculos(veiculoCadastrado);
                                    }
                                }
                            
                            case "PJ":
                                
                                System.out.println("CNPJ do Cliente: ");
                                String cnpjCliente = sc.nextLine();

                                for(Cliente cliente : seguradora.getListaClientes()){
                                    if(cliente instanceof ClientePJ && ((ClientePJ)(cliente)).getCNPJ().equals(cnpjCliente)){
                                        ((ClientePJ)(cliente)).atualizarFrota(veiculoCadastrado); 
                                    }
                                }
                                
    
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

                        Seguradora seguradoraNova = new Seguradora(cnpjSeguradora, nomeSeguradora, telefoneSeguradora, emailSeguradora, enderecoSeguradora);
                        listaSeguradora.add(seguradoraNova);
                        
                        System.out.println(
                                "Seguradora de nome " + nomeSeguradora + " cadastrada em nosso sistema!");
                        break;
                    
                    case CADASTRAR_FROTA:
                        
                        System.out.println("CNPJ do cliente Pessoa Jurídica: ");
                        String cnpjClienteFrota = sc.nextLine();

                        Frota frotaCadastrada = new Frota();

                        for(Cliente cliente : seguradora.getListaClientes()){
                            if(cliente instanceof ClientePJ && ((ClientePJ)(cliente)).getCNPJ().equals(cnpjClienteFrota)){
                                ((ClientePJ)(cliente)).cadastrarFrota(frotaCadastrada); 
                            }
                        }

                        
                    case SAIR_CADASTRAR:
                        ExecutarOperacao(listaSeguradora, seguradora, validacaoContinuar);
                }

                break;

            case LISTAR:
                System.out.println("---------- LISTAGEM -----------");

                System.out.println("1) Listar Cliente PF/PJ por Seguradora\n2) Listar Sinistros por Seguradora");
                System.out.println(
                        "3) Listar Sinistro por Cliente\n4) Listar Veículo por Cliente\n5) Listar Veículo por Seguradora\n6) Voltar");

                double operacaoListar = sc.nextDouble();
                sc.nextLine();

                double listarMenuFracionado = operacao + operacaoListar / 10;
                MenuOperacoes listarMenu = MenuOperacoes.retornarComando(listarMenuFracionado);

                switch (listarMenu) {

                    case LISTAR_CLIENTE_POR_SEGURADORA:
                        // Listar os clientesPF e clientesPJ por seguradora
                        System.out
                                .println("Quais tipos de Cliente quer listar? \n1) ClientePF \n2) ClientePJ]");
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
                            seguradoraIterada.listarSinistros();
                        }
                        break;

                    case LISTAR_SINISTRO_POR_CLIENTE:
                        // Listar Sinistros por Cliente
                        for (Cliente clienteIterado : seguradora.getListaClientes()) {
                            seguradora.visualizarSinistro(clienteIterado.getNome());
                        }
                        break;

                    case LISTAR_VEICULO_POR_CLIENTE:
                        // Listar Veículo por Cliente
                        for (Cliente clienteIterado : seguradora.getListaClientes()) {
                            clienteIterado.listarVeiculos();
                        }
                        break;

                    case LISTAR_VEICULO_POR_SEGURADORA:
                        // Listar Veículos por Seguradora
                        for (Seguradora seguradoraIterada : listaSeguradora) {
                            seguradoraIterada.listarVeiculos();
                        }
                        break;
                    case SAIR_LISTAR:
                        ExecutarOperacao(listaSeguradora, seguradora, validacaoContinuar);
                        break;
                }
                break;

            case EXCLUIR:
                System.out.println("---------- EXCLUIR -----------");

                System.out.println("1) Excluir Cliente \n2) Excluir Veículo\n3) Excluir Sinistro\n4) Voltar");

                double operacaoExcluir = sc.nextDouble();
                sc.nextLine();
                double excluirMenuFracionado = operacao + operacaoExcluir / 10;
                MenuOperacoes excluirMenu = MenuOperacoes.retornarComando(excluirMenuFracionado);

                switch (excluirMenu) {

                    case EXCLUIR_CLIENTE:

                        System.out.println("Digite o nome do Cliente / Empresa: ");
                        String nomeExcluido = sc.nextLine();

                        int contador = 0;
                        boolean clienteRemovido = false;
                        for (Cliente cliente : seguradora.getListaClientes()) {
                            if (cliente.getNome().equals(nomeExcluido)) {
                                clienteRemovido = true;
                                seguradora.removerCliente(nomeExcluido); // passar o cliente como parametro
                                System.out.println("Cliente com nome " + nomeExcluido + " excluído!");
                            }
                            contador = contador + 1;
                        }
                        if (!clienteRemovido) {
                            System.out.println("Nenhum cliente encontrado!");
                        }
                        break;

                    case EXCLUIR_VEICULO:

                        System.out.println("Digite a placa do veículo: ");
                        String placaExcluida = sc.nextLine();
                        boolean veiculoRemovido = false;

                        for (Cliente clienteVeiculos : seguradora.getListaClientes()) {
                            ArrayList<Veiculo> listaVeiculos = clienteVeiculos.getListaVeiculos();
                            for (Veiculo veiculo : listaVeiculos) {
                                if (veiculo.getPlaca().equals(placaExcluida)) {
                                    System.out.println("Veículo com placa" + placaExcluida + " excluído!");
                                    veiculoRemovido = true;
                                    clienteVeiculos.removerVeiculos(veiculo);
                                }
                            }
                        }
                        if (!veiculoRemovido) {
                            System.out.println("Nenhum veículo encontrado!");

                        }

                        break;

                    case EXCLUIR_SINISTRO:

                        System.out.println("Lista com todas as seguradoras: ");
                        int contadorSeg = 0;
                        for (Seguradora seguradoraIterada : listaSeguradora) {
                            System.out.println("[" + contadorSeg + "] = " + seguradoraIterada.getNome());
                            contadorSeg = contadorSeg + 1;
                            seguradoraIterada.listarSinistros();
                        }

                        System.out.println("Digite o número da seguradora que deseja: ");
                        int indexSeguradora = sc.nextInt();
                        sc.nextLine();

                        Seguradora SeguradoraDesejada = listaSeguradora.get(indexSeguradora);

                        SeguradoraDesejada.listarSinistros();

                        System.out.println("Digite o número do id do sinistro que deseja: ");
                        int idSinistro = sc.nextInt();
                        sc.nextLine();

                        for (Sinistro sinistroIterado : SeguradoraDesejada.getListaSinistros()) {
                            if (sinistroIterado.getId() == idSinistro) {
                                SeguradoraDesejada.removerSinistro(idSinistro);
                                break;
                            }
                        }
                        break;

                    case SAIR_EXCLUIR:
                        ExecutarOperacao(listaSeguradora, seguradora, validacaoContinuar);
                        break;

                }
                break;

            case GERAR_SINISTRO:
                System.out.println("---------- GERAR SINISTRO -----------");

                System.out.println("Digite o endereço que ocorreu o Sinistro: ");
                String enderecoSinistro = sc.nextLine();

                System.out.println("Digite a placa do Veículo:  ");
                String placa = sc.nextLine();

                System.out.println("Digite o nome do Cliente/Empresa: ");
                String nome = sc.nextLine();

                boolean clienteExiste = false;
                boolean veiculoExiste = false;
                for (Cliente cliente : seguradora.getListaClientes()) {
                    if (cliente.getNome().equals(nome)) {
                        clienteExiste = true;
                        for (Veiculo veiculo : cliente.getListaVeiculos()) {
                            if (veiculo.getPlaca().equals(placa)) {
                                veiculoExiste = true;
                                seguradora.gerarSinistro(veiculo, cliente, enderecoSinistro);
                                System.out.println("Sinistro do cliente " + nome + " gerado com sucesso! ");

                            }
                        }
                    }
                }

                if (!clienteExiste) {
                    System.out.println("Desculpe, não encontramos o cliente.");
                } else if (!veiculoExiste) {
                    System.out.println("Desculpe, não encontramos o veículo.");
                }

                ExecutarOperacao(listaSeguradora, seguradora, validacaoContinuar);
                break;

            case TRANSFERIR_SEGURO:

                System.out.println("---------- TRANSFERÊNCIA DE SEGURO -----------");

                System.out.println("Digite o nome do Cliente de quem deseja transferir o Seguro: ");
                String nomeClienteRemetente = sc.nextLine();

                System.out.println("Digite o nome do Cliente para quem deseja transferir o Seguro: ");
                String nomeClienteDestinatario = sc.nextLine();

                boolean achouCliente = false;
                for (Cliente clienteRemetente : seguradora.getListaClientes()) {
                    if (clienteRemetente.getNome().equals(nomeClienteRemetente)) {
                        achouCliente = true;
                        for (Cliente clienteDestinatario : seguradora.getListaClientes()) {
                            if (clienteDestinatario.getNome().equals(nomeClienteDestinatario)) {
                                for (Veiculo veiculo : clienteRemetente.getListaVeiculos()) {
                                    clienteDestinatario.cadastrarVeiculos(veiculo);
                                    clienteRemetente.removerVeiculos(veiculo);
                                }
                                seguradora.removerCliente(nomeClienteRemetente);
                                double novoValorSeguro = seguradora.calcularPrecoSeguroCliente(clienteDestinatario);
                                clienteDestinatario.setValorSeguro(novoValorSeguro);
                                System.out.println("Seguro transferido com sucesso!");
                                break;
                            }
                        }
                    }
                }
                if (!achouCliente) {
                    System.out.println("Desculpe, não encontramos o cliente.");
                }
                ExecutarOperacao(listaSeguradora, seguradora, validacaoContinuar);
                break;

            case CALCULAR_RECEITA_SEGURADORA:
                System.out.println("---------- CALCULANDO RECEITA SEGURADORA -----------");

                seguradora.calcularReceita();
                ExecutarOperacao(listaSeguradora, seguradora, validacaoContinuar);
                break;

            case SAIR:
                validacaoContinuar = false;
                System.exit(0);
        }

    }

}
