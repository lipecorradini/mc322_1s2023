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
		 * Adiciona um veículo na lista de veículos, e mostra o tamanho da lista
		 */
	    listaVeiculos.add(veiculo);
		//System.out.println("o numero de veiculos é: " + listaVeiculos.size());
		return true;
	}

	public boolean removerVeiculos(Veiculo veiculo){
		/*
		 * Procura um veículo e o remove da lista
		 */
	    for(Veiculo carro : listaVeiculos){
			if(carro == veiculo){
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
			System.out.println(carro.toString());
			numeroVeiculos ++;
		}
		if(numeroVeiculos == 0) System.out.println("Não existem Veículos cadastrados!");
	}

}
