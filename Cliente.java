package mc322_1s2023;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome){
        this.nome = nome;
    }
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento){
	    this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade){
	    this.idade = idade;
	}
	
	public String getEndereco() {
		return endereco;
	} 

	public void setEndereco(String endereco){
	    this.endereco = endereco;
	} 
	
	public String toString() {
		return nome;
	}
	
	public boolean validarCPF(String cpf) {
		
		// Removendo caracteres nao numericos
		String cpfNumerico = cpf.replaceAll( "[^\\d]", "" );
		if (cpfNumerico.length() != 11) return false;
	
		// Verificando se todos os dígitos não são iguais
		char firstDigit = cpfNumerico.charAt(0);
		int validador = 0;
		for (int i = 0; i < 11; i++) {
			if(cpfNumerico.charAt(i) != firstDigit) {
				validador = 1;
				break;
			}
		}
		if (validador == 0) return false;
		
		//Calculando e validando os dígitos verificadores
		// calculando o primeiro digito
		// falta verificar se o resto for maior que 10 o numero vira 0
		
		char primeiroDigitoVerificador = cpfNumerico.charAt(9);
		char segundoDigitoVerificador = cpfNumerico.charAt(10);
		int somaPrimeiro = 0, somaSegundo = 0;
		
		for(int i = 0; i < 9; i++) {
			somaPrimeiro += cpfNumerico.charAt(i)*(10 - i);
		}
		
		int restoPrimeiro = somaPrimeiro % 11;
		int resultadoPrimeiro = 11 - restoPrimeiro;
		if(resultadoPrimeiro != primeiroDigitoVerificador) return false;
		
		//calculando o segundo digito
		
		for(int j = 0; j < 10; j++) {
			somaSegundo += cpfNumerico.charAt(j)*(11 - j);
		}
		int restoSegundo = somaSegundo % 11;
		int resultadoSegundo = 11 - restoSegundo;
		if(resultadoSegundo != segundoDigitoVerificador) return false;
		
		
		
	}
	

	
}
