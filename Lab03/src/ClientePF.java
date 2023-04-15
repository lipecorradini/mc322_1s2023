import java.util.*;
import java.time.LocalDate;

public class ClientePF extends Cliente {

	private LocalDate dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
    private String cpf;
    private LocalDate dataNascimento;
	

    public ClientePF( String nome , String endereco , LocalDate dataLicenca ,
     String educacao , String genero , String classeEconomica ,
     List < Veiculo > listaVeiculos , String cpf , LocalDate dataNascimento){      

        super ( nome , endereco , listaVeiculos );
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

	public LocalDate getDataLicenca(){
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca){
		this.dataLicenca = dataLicenca;
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

	public String getClasseEconomica() {
		return classeEconomica;
	}
	
	public void setClasseEconomica(String classeEconomica){
	    this.classeEconomica = classeEconomica;
	}


    @Override

    public String toString(){
        String tudo = "\n cpf: " + cpf + "\n data nascimento: " + dataNascimento;
        return tudo;
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
		
		int primeiroDigitoVerificador = Character.getNumericValue(cpfNumerico.charAt(9));

		int segundoDigitoVerificador = Character.getNumericValue(cpfNumerico.charAt(10));
		int somaPrimeiro = 0, somaSegundo = 0;
		
		for(int i = 0; i < 9; i++) {
			int valorInteiro = Character.getNumericValue(cpfNumerico.charAt(i));
			somaPrimeiro += valorInteiro*(10 - i);
		}
		
		int restoPrimeiro = somaPrimeiro % 11;
		int resultadoPrimeiro = 11 - restoPrimeiro;
		if(resultadoPrimeiro >= 10) resultadoPrimeiro = 0;

		if((int)resultadoPrimeiro != (int)primeiroDigitoVerificador) return false;
		
		//calculando o segundo digito
	
		for(int j = 0; j < 10; j++) {
			int valorInteiro = Character.getNumericValue(cpfNumerico.charAt(j));
			somaSegundo += valorInteiro*(11 - j);
		}
		int restoSegundo = somaSegundo % 11;
		int resultadoSegundo = 11 - restoSegundo;
		if(resultadoSegundo >= 10) resultadoSegundo = 0;
		if(resultadoSegundo != segundoDigitoVerificador) return false;
		
		return true;
	}

}
