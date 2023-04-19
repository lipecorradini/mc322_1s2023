
import java.util.*;

public class Cliente {
	
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica; 
	private ArrayList<Veiculo> listaVeiculos;

	
	public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();

    }
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome){
        this.nome = nome;
    }

	public String getEndereco() {
		return endereco;
	} 

	public void setEndereco(String endereco){
	    this.endereco = endereco;
	} 
	
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public boolean cadastrarVeiculos(Veiculo veiculo){
	    listaVeiculos.add(veiculo);
		System.out.println("o numero de veiculos é: " + listaVeiculos.size());
		return true;
	}

	public boolean removerVeiculos(Veiculo veiculo){
	    for(Veiculo carro : listaVeiculos){
			if(carro == veiculo){
				listaVeiculos.remove(veiculo);
				return true;
			}
		}
		return false;
	}

	public void listarVeiculos(){
		int numeroVeiculos = 0;
		for(Veiculo carro: listaVeiculos){
			System.out.println(carro.toString());
			System.out.println("-------------------------");
			numeroVeiculos ++;
		}
		if(numeroVeiculos == 0) System.out.println("Não existem Veículos cadastrados!");
	}

	public String toString() {
		String tudo = "nome: " + nome + "\n endereco: " + endereco ;
		return tudo;
	}
	
}
