
import java.util.*;

public class Cliente {
	
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica; 
	private List<Veiculo> listaVeiculos;

	
	public Cliente(String nome, String endereco, List<Veiculo> listaVeiculos){
        this.nome = nome;
        this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;

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

	
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veiculo> listaVeiculos){
	    this.listaVeiculos = listaVeiculos;
	}

	public String toString() {
		String tudo = "nome: " + nome + "\n endereco: " + endereco + "\n Educacao: " + educacao + "\n genero: " + genero + "\n classe economica: " + classeEconomica +
		 "\n lista de veiculos: " + listaVeiculos;
		return tudo;
	}
	
}
