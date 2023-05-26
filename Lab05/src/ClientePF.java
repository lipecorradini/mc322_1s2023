import java.util.*;
import java.time.LocalDate;

public class ClientePF extends Cliente {

	private String educacao;
	private String genero;
    private final String cpf;
    private LocalDate dataNascimento;
	private ArrayList<Veiculo> listaVeiculos;
	

    public ClientePF( String nome , String endereco ,
     String educacao , String genero , String cpf 
	 , LocalDate dataNascimento, String telefone, String email){      

        super ( nome , endereco, telefone, email);
		this.educacao = educacao;
		this.genero = genero;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
		this.listaVeiculos = new ArrayList<Veiculo>();
    }

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

	
	public String getEducacao(){
		return educacao;
	}
	
	public void setEducacao(String educacao){
		this.educacao = educacao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero){
	    this.genero = genero;
	}


    @Override

	public String toString() {
		return "{" +
			" educacao='" + getEducacao() + "'" +
			", genero='" + getGenero() + "'" +
			", cpf='" + getCpf() + "'" +
			", dataNascimento='" + getDataNascimento() + "'" +
			", listaVeiculos='" + getListaVeiculos() + "'" +
			"}";
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public boolean cadastrarVeiculos(Veiculo veiculo){
		/*
		 * Adiciona um veículo na lista de veículos
		 */

	    listaVeiculos.add(veiculo);
		return true;
	}

	public boolean removerVeiculos(){
		/*
		 * Procura um veículo e o remove da lista
		 */
		Veiculo veiculo = escolherVeiculo();
	    for(Veiculo carro : listaVeiculos){
			if(carro.equals(veiculo)){
				listaVeiculos.remove(veiculo);
				return true;
			}
		}
		return false;
	}

	public void listarVeiculos(){
		/*
		 * Mostra todos os veículos cadastrados
		 */
		int numeroVeiculos = 0;
		for(Veiculo carro: listaVeiculos){
			System.out.println(numeroVeiculos + ") " + carro.getPlaca() + " - " + carro.getModelo());
			numeroVeiculos ++;
		}
		if(numeroVeiculos == 0) System.out.println("Não existem Veículos cadastrados!");
	}

	public Veiculo escolherVeiculo(){
		
		int count = 1;

		System.out.println("Digite o número do veículo desejado: ");
		for(Veiculo veiculosCadastrados : listaVeiculos){
			System.out.println(count + ") " + veiculosCadastrados.getPlaca());
			count ++;
		}

		Scanner sc = new Scanner(System.in);
		int indexVeiculo = sc.nextInt();
		sc.nextLine();
		
		Veiculo veiculoEscolhido = listaVeiculos.get(indexVeiculo - 1);
		sc.close();
		return veiculoEscolhido;
	}

}
