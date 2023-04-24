
import java.util.*;

public class Cliente {
	
	private String nome;
	private String endereco;
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
		/*
		 * Adiciona um veículo na lista de veículos, e mostra o tamanho da lista
		 */
	    listaVeiculos.add(veiculo);
		System.out.println("o numero de veiculos é: " + listaVeiculos.size());
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

	public String toString() {
		String tudo = "nome: " + nome + "\n endereco: " + endereco ;
		return tudo;
	}
	
}
