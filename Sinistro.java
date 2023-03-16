package mc322_1s2023;
import java.util.Random;

public class Sinistro {

		private int id;
		private String data;
		private String endereco;
		
		public int getId() {
			
			Random gerador = new Random();
			int novoId = 0;
			for(int i = 0; i < 10; i++) {
				
				int digito = gerador.nextInt();
				int expoente = 9 - i;
				novoId += digito*(Math.pow(10, expoente));
		}
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

