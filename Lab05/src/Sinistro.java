
import java.util.Random;
import java.time.LocalDate;

public class Sinistro {

		private int id;
		private LocalDate data;
		private String endereco;
		private Condutor condutor;
		private Seguro seguro;
		
		
		public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro){
	       
			this.id = generateId();
	        this.data = data;
	        this.endereco = endereco;
			this.condutor = condutor;
			this.seguro = seguro;
	
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
		
		public LocalDate getData() {
			return data;
		}
		
		public void setData(LocalDate data) {
			this.data = data;
		}
		
		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco){
	        this.endereco = endereco;
	    }
		

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", data='" + getData() + "'" +
			", endereco='" + getEndereco() + "'" +
			"}";
	}
		
		
}

