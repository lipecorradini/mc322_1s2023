package mc322_1s2023;
import java.util.Random;

public class Sinistro {

		private int id;
		private String data;
		private String endereco;
		
		public Sinistro(String data, String endereco){
	        this.id = generateId();
	        this.data = data;
	        this.endereco = endereco;
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
		
		
}

