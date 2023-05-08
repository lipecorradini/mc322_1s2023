import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//Criando o cliente PF
		ClientePF clientePf = new ClientePF("jorge", "rua boa viagem, 55"
										, LocalDate.now(), "ensino médio",
										 "masculino", "média-alta","120.102.984-89", LocalDate.of(1977, 3, 27));


		//Validando o cpf do cliente PF
		System.out.println("----------- Validando o CPF -----------");
		boolean validador;
		validador = clientePf.validarCPF("494.996.278-71");
		System.out.println("O cpf é válido: " + validador);
		

		//Criando o cliente PJ
		ClientePJ clientePJ = new ClientePJ("apple", "silicon valley"
							, LocalDate.now(), "32.001.336/0001-65",
							 LocalDate.of(1952, 3, 23), 5, 0);


		//Validando CNPJ do cliente PJ
		System.out.println("----------- Validando o CNPJ -----------");
		validador = clientePJ.validarCNPJ("32.001.336/0001-65");
		System.out.println("o cnpj é válido: " + validador);
		


		//Gerando a lista de sinistros
		ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();


		//Gerando a lista de clientes
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		

		//Criando a seguradora
		System.out.println("----------- Gerando a Seguradora -----------");
		Seguradora seguradora = new Seguradora("proteg seguradora", "(19)99999-9899"
												, "proteg@gmail.com", "rua orosimbo maia, 191");
		System.out.println(seguradora.toString()); 
		


		//Adicionando um veiculo para o cliente PF
		System.out.println("----------- Adicionando os veículos -----------");
		Veiculo carroPf = new Veiculo("NNT-4I21", "Suzuki", "Gran Vitara", 2012);
		clientePf.cadastrarVeiculos(carroPf);
		clientePf.listarVeiculos();


		//Adicionando um veículo para o cliente PJ
		Veiculo carroPj = new Veiculo("QLK-8C00", "Jeep", "Compass", 2018);
		clientePJ.cadastrarVeiculos(carroPj);
		clientePf.listarVeiculos();


		//Cadastrando o primeiro cliente
		System.out.println("----------- Cadastrando os clientes -----------");
		validador = seguradora.cadastrarCliente(clientePf);
		System.out.println("O cliente PF foi cadastrado: " + validador);
		listaClientes = seguradora.listarClientes("ClientePF");


		//Cadastrando o segundo cliente
		validador = seguradora.cadastrarCliente(clientePJ);
		System.out.println("O cliente PJ foi cadastrado: " + validador);
		listaClientes = seguradora.listarClientes("ClientePJ");
		


		//Gerando um sinistro
		System.out.println("----------- Gerando os sinsitros -----------");
		Sinistro sinistro = new Sinistro(LocalDate.now(), "rua zuppi, 27", seguradora, carroPj, clientePJ);
		System.out.println(sinistro.toString());


		//Chamando os métodos listarSinistros e visualizarSinistro da Seguradora
		seguradora.gerarSinistro(carroPj, clientePJ);
		seguradora.gerarSinistro(carroPf, clientePf);

		seguradora.visualizarSinistro(clientePJ.toString());
		seguradora.visualizarSinistro(clientePf.toString());

		System.out.println("----------- Listando os sinsitros dos clientes -----------");
		seguradora.listarSinistros();

		System.out.println("Olá! Bem vindo à nossa seguradora!\n");
		System.out.println("Digite PF para pessoa física ou PJ para pessoa jurídica: \n");
		Scanner tipoCliente = new Scanner(System.in);
		String tipoClienteStr = tipoCliente.nextLine();
	
		System.out.println("Muito bem! Agora selecione o serviço desejado: ");
		System.out.println("1 - Ver os Veículos cadastrados\n");
		System.out.println("2 - Ver os Sinistros cadastrados\n");
		Scanner servico = new Scanner(System.in);
		String servicoStr = servico.nextLine();
	
		if(tipoClienteStr.equals("PF")){
			if(servicoStr.equals("1")) clientePf.listarVeiculos();
			else if(servicoStr.equals("2")) seguradora.visualizarSinistro(clientePf.getNome());
		}

		if(tipoClienteStr.equals("PJ")){

			if(servicoStr.equals("1")) clientePJ.listarVeiculos();
			else if(servicoStr.equals("2")) seguradora.visualizarSinistro(clientePJ.getNome());
		}

	}
    
}
