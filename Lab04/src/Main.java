import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		
		//Criando o cliente PF
		ClientePF clientePF = new ClientePF("jorge", "rua boa viagem, 55"
										, LocalDate.now(), "ensino médio",
										 "masculino", "média-alta","120.102.984-89", LocalDate.of(1977, 3, 27), 0);


		//Validando o cpf do cliente PF
		System.out.println("----------- Validando o CPF -----------");
		boolean validador;
		validador = Validacao.validarCPF("494.996.278-71");
		System.out.println("O cpf é válido: " + validador);
		

		//Criando o cliente PJ
		ClientePJ clientePJ = new ClientePJ("apple", "silicon valley"
							, LocalDate.now(), "32.001.336/0001-65",
							 LocalDate.of(1952, 3, 23), 15, 0);


		//Validando CNPJ do cliente PJ
		System.out.println("----------- Validando o CNPJ -----------");
		validador = Validacao.validarCNPJ("32.001.336/0001-65");
		System.out.println("o cnpj é válido: " + validador);

		//Gerando a lista de clientes
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

		//Gerando a lista de seguradoras
		ArrayList<Seguradora> listaSeguradora = new ArrayList<Seguradora>();
		

		//Criando a seguradora
		System.out.println("----------- Gerando a Seguradora -----------");
		Seguradora seguradora = new Seguradora("proteg seguradora", "(19)99999-9899"
												, "proteg@gmail.com", "rua orosimbo maia, 191");
		System.out.println(seguradora.toString()); 
		listaSeguradora.add(seguradora);
		


		//Adicionando um veiculo para o cliente PF
		System.out.println("----------- Adicionando os veículos -----------");
		Veiculo carroPf = new Veiculo("NNT-4I21", "Suzuki", "Gran Vitara", 2012);
		clientePF.cadastrarVeiculos(carroPf);
		clientePF.listarVeiculos();


		//Adicionando um veículo para o cliente PJ
		Veiculo carroPj = new Veiculo("QLK-8C00", "Jeep", "Compass", 2018);
		clientePJ.cadastrarVeiculos(carroPj);
		clientePF.listarVeiculos();


		//Cadastrando o primeiro cliente
		System.out.println("----------- Cadastrando os clientes -----------");
		validador = seguradora.cadastrarCliente(clientePF); // remover ele depois
		System.out.println("O cliente PF foi cadastrado: " + validador);


		//Cadastrando o segundo cliente
		validador = seguradora.cadastrarCliente(clientePJ); // remover ele depois
		System.out.println("O cliente PJ foi cadastrado: " + validador);

		//Gerando um sinistro
		System.out.println("----------- Gerando os sinsitros -----------");
		Sinistro sinistro = new Sinistro(LocalDate.now(), "rua zuppi, 27", seguradora, carroPj, clientePJ);
		System.out.println(sinistro.toString());

		//instanciando a lista de clientes

		listaClientes = seguradora.getListaClientes();

		//Chamando os métodos listarSinistros e visualizarSinistro da Seguradora
		seguradora.gerarSinistro(carroPj, clientePJ);
		seguradora.gerarSinistro(carroPf, clientePF);

		seguradora.visualizarSinistro(clientePJ.toString());
		seguradora.visualizarSinistro(clientePF.toString());

		double valorSeguroPF =	seguradora.calcularPrecoSeguroCliente(clientePF);
		System.out.println("valor seguro pf: " + valorSeguroPF);
		double valorSeguroPJ = seguradora.calcularPrecoSeguroCliente(clientePJ);
		System.out.println("valor seguro pj: " + valorSeguroPJ);

		seguradora.calcularReceita();



		System.out.println("---------- COMEÇANDO O MENU ----------");

		
		System.out.println("Olá, seja bem vindo à seguradora!");
        System.out.println("Digite o número correto para a respectiva ação:");
        System.out.println("1) Cadastros \n2) Listar \n3) Excluir \n4) Gerar Sinistro");
        System.out.println("5) Transferir Seguro \n6) Calcular receita Seguradora \n0) Sair");
        System.out.println("---------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        int operacao = sc.nextInt();
        

        switch(operacao){

            case 1: // cadastos
                System.out.println("1) Cadastrar Cliente PF/PJ\n 2) Cadastrar Veículos\n 3) Cadastrar Seguradora\n 4) Voltar\n");
				System.out.println("---------------------------------------------------");
                int operacaoCadastrar = sc.nextInt();

                //fazer as instrucoes para cada um dos 
                switch(operacaoCadastrar){

                    case 1:
                        //cadastrar cliente pf/pj
						System.out.println("1) Cliente Pessoa Física\n2) Cliente Pessoa Jurídica\n ");
						int tipoCliente = sc.nextInt();	

						System.out.println(" Nome: ");
						String nome = sc.nextLine();
						
						System.out.println("Endereço: ");
						String endereco = sc.nextLine();
						
						System.out.println("Data da licenca [dd. MM. yyyy]: ");
						String str = sc.nextLine();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MM. yyyy");
						LocalDate datadaLicenca = LocalDate.parse(str, dtf);
						
						switch(tipoCliente){
							
							case 1:
								
								System.out.println("Educação: ");
								String educacao = sc.nextLine();

								System.out.println("Gênero: ");
								String genero = sc.nextLine();

								System.out.println("Classe econômica: ");
								String classeEconomica = sc.nextLine();

								System.out.println("CPF: ");
								String cpf = sc.nextLine();

								System.out.println("Data de Nascimento [dd. MMM. yyyy]: ");
								String dataNascimento = sc.nextLine();
    							LocalDate dataNascimentoDate = LocalDate.parse(dataNascimento, dtf);

								ClientePF clientePf = new ClientePF(nome, endereco, datadaLicenca, educacao, genero, classeEconomica, cpf, dataNascimentoDate, 0);
								double valorSeguroPf = seguradora.calcularPrecoSeguroCliente(clientePf);
								clientePf.setValorSeguro(valorSeguroPf);
								
								seguradora.cadastrarCliente(clientePf);
							
							case 2:
								
								System.out.println("CNPJ: ");
								String cnpj = sc.nextLine();

								System.out.println("Data de Fundação [dd. MMM. yyyy]: ");
								String dataFundacao = sc.nextLine();
								LocalDate dataFundacaoDate = LocalDate.parse(dataFundacao, dtf);

								System.out.println(" Quantidade de Funcionários: ");
								int qtdeFuncionarios = sc.nextInt();
								
								ClientePJ clientePj = new ClientePJ(nome, endereco, datadaLicenca, cnpj, dataFundacaoDate, qtdeFuncionarios, 0);
								double valorSeguroPj = seguradora.calcularPrecoSeguroCliente(clientePj);
								clientePj.setValorSeguro(valorSeguroPj);

								seguradora.cadastrarCliente(clientePj);
				
						}				
                    
                    case 2:
						//cadastrar veiculo
						System.out.println("Placa: ");
						String placa = sc.nextLine();

						System.out.println("Marca: ");
						String marca = sc.nextLine();

						System.out.println("Modelo: ");
						String modelo = sc.nextLine();

						System.out.println("Ano de Fabricação: ");
						int anoFabricacao = sc.nextInt();

						Veiculo veiculoCadastrado = new Veiculo(placa, marca, modelo, anoFabricacao);
						System.out.println("Veículo de placa " + veiculoCadastrado.getPlaca() + " cadastrado!");
						
                    case 3:

						//cadastrar seguradora

						System.out.println("Nome: ");
						String nomeSeguradora = sc.nextLine();

						System.out.println("Telefone: ");
						String telefoneSeguradora = sc.nextLine();

						System.out.println("Email: ");
						String emailSeguradora = sc.nextLine();

						System.out.println("Endereco: ");
						String enderecoSeguradora = sc.nextLine();

						Seguradora seguradoraNova = new Seguradora(nomeSeguradora, telefoneSeguradora, emailSeguradora, enderecoSeguradora);
						listaSeguradora.add(seguradoraNova);

                    
                    case 4:
                        //voltar
                }                

            case 2:
                
				System.out.println("1) Listar Cliente PF/PJ por Seguradora\n 2) Listar Sinistros por Seguradora\n");
                System.out.println("3) Listar Sinistro por Cliente\n 4) Listar Veículo por Cliente\n 5) Listar Veículo por Seguradora\n 6) Voltar");

				int operacaoListar = sc.nextInt();

				switch(operacaoListar){

					case 1:
						//Listar os clientesPF e clientesPJ por seguradora
						System.out.println("Quais tipos de Cliente quer listar? \n1)ClientePF \n2)ClientePJ]");
						int tipoCliente = sc.nextInt();

						switch(tipoCliente){

							case 1:
								for(Seguradora seguradoraIterada : listaSeguradora){
									seguradoraIterada.listarClientes("ClientePF");
								}
							
							case 2:
								for(Seguradora seguradoraIterada : listaSeguradora){
									seguradoraIterada.listarClientes("ClientePJ");
								}
			
						}
					
					case 2:
						//Listar os Sinistros por Seguradora
						for(Seguradora seguradoraIterada : listaSeguradora){
							seguradoraIterada.listarSinistros();
						}

					case 3:
						//Listar Sinistros por Cliente
						for(Cliente clienteIterado : listaClientes){
							seguradora.visualizarSinistro(clienteIterado.getNome());
						}
					
					case 4:
						//Listar Veículo por Cliente
						for(Cliente clienteIterado : listaClientes){
							clienteIterado.listarVeiculos();
						}
					
					case 5:
						//Listar Veículos por Seguradora
						for(Seguradora seguradoraIterada: listaSeguradora){
							seguradoraIterada.listarVeiculos();
						}
						
				}

            case 3:
                System.out.println("1) Excluir Cliente \n2) Excluir Veículo\n3) Excluir Sinistro\n4) Voltar");
				int tipoExclusao = sc.nextInt();

				switch(tipoExclusao){

					case 1:
						
						System.out.println("Digite o nome do Cliente / Empresa: ");
						String nomeExcluido = sc.nextLine();

						int contador = 0;
						for(Cliente cliente: listaClientes){
							if(cliente.getNome() == nomeExcluido){
								seguradora.removerCliente(nomeExcluido);
							}
							contador = contador + 1;
						}
						
					case 2:

						System.out.println("Digite a placa do veículo: ");
						String placaExcluida = sc.nextLine();
						
						for(Seguradora seguradoraVeiculos: listaSeguradora){
							for(Cliente clienteVeiculos: seguradoraVeiculos.getListaClientes() ){
								ArrayList<Veiculo> listaVeiculos = clienteVeiculos.getListaVeiculos();
								for(Veiculo veiculo : listaVeiculos){
									if(veiculo.getPlaca() == placaExcluida){
										clienteVeiculos.removerVeiculos(veiculo);
									}
								}
							}
						}

					case 3:
						
							
					}		
				}
				sc.close();            
        }
	}
    
