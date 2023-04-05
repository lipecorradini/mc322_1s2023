
import java.util.Random;

public class Sinistro {

		private int id;
		private String data;
		private String endereco;
		private Seguradora seguradora;
		private Veiculo veiculo;
		private Cliente cliente;
		
		public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
	        this.id = generateId();
	        this.data = data;
	        this.endereco = endereco;
			this.seguradora = seguradora;
			this.veiculo = veiculo;
			this.cliente = cliente;
	    }
		
		private int generateId() {
			
			Random gerador = new Random();
			int limite = 999999999;
			int novoId = gerador.nextInt(limite);
			return novoId;
			
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getData() {
			return data;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		
		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco){
	        this.endereco = endereco;
	    }
		
		public Seguradora getSeguradora() {
			return seguradora;
		}

		public void setSeguradora(Seguradora seguradora){
	        this.seguradora = seguradora;
	    }

		public Veiculo getVeiculo() {
			return veiculo;
		}

		public void setVeiculo(Veiculo veiculo){
	        this.veiculo = veiculo;
	    }
		
		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente){
	        this.cliente = cliente;
	    }

		public String toString(){
			String tudo = "\n data: " + data + "\n endereco: " + endereco + "\n seguradora: " + seguradora + "\n veiculo: " + veiculo + "\ncliente:  " + cliente;
			return tudo;
		}
		
}

