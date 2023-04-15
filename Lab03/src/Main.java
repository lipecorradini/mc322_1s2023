import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {

		//Criando a lista de veículos
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		
		//Criando o cliente
		ClientePF cliente = new ClientePF("jorge", "rua boa viagem, 55"
										, LocalDate.now(), "ensino médio",
										 "masculino", "média-alta",
										 listaVeiculos, "120.102.984-89", LocalDate.of(1977, 3, 27));

		//Validando o cpf do cliente
		boolean validador;
		validador = cliente.validarCPF("120.102.984-89");
		System.out.println("O cpf é válido: " + validador);

		//Gerando a lista de sinistros
		ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();

		//Gerando a lista de clientes
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		//Criando a seguradora
		Seguradora seguradora = new Seguradora("proteg seguradora", "(19)99999-9899"
												, "proteg@gmail.com", "rua orosimbo maia, 191",
												 listaSinistros, listaClientes);

		//Cadastrando o primeiro cliente
		validador = seguradora.cadastrarCliente(cliente);
		System.out.println("O cliente foi cadastrado: " + validador);
		listaClientes = seguradora.listarClientes("ClientePF");

	
	}
    
}
