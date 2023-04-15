import java.util.*;;

public class ClientePJ extends Cliente{

    private String CNPJ;
    private Date dataFundacao;

    public ClientePJ(String nome , String endereco , Date dataLicenca ,
     String educacao , String genero , String classeEconomica ,
     List < Veiculo > listaVeiculos , String CNPJ , Date dataFundacao){

        super ( nome , endereco , listaVeiculos );
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    @Override

    public String toString(){
        String tudo = "\n CNPJ: " + CNPJ + "\n data fundacao: " + dataFundacao;
        return tudo;
    }

    public boolean validarCNPJ(String CNPJ){
        // check if the cnpj itself is valid or not

        String CNPJNumerico = CNPJ.replaceAll( "[^\\d]", "" );
		if (CNPJNumerico.length() != 14) return false;
	
		// Verificando se todos os dígitos não são iguais
		char firstDigit = CNPJNumerico.charAt(0);
		int validador = 0;
		for (int i = 0; i < 14; i++) {
			if(CNPJNumerico.charAt(i) != firstDigit) {
				validador = 1;
				break;
			}
		}
		if (validador == 0) return false;
		
		//Calculando e validando os dígitos verificadores
		// calculando o primeiro digito
		
		int primeiroDigitoVerificador = Character.getNumericValue(CNPJNumerico.charAt(9));

		int segundoDigitoVerificador = Character.getNumericValue(CNPJNumerico.charAt(10));
		int somaPrimeiro = 0, somaSegundo = 0;
        int[] sequenciaVerificacao1 = new int[]{ 5,4,3,2,9,8,7,6,5,4,3,2 }; 
        int[] sequenciaVerificacao2 = new int[]{ 6,5,4,3,2,9,8,7,6,5,4,3,2}; 
		
		for(int i = 0; i < 12; i++) {
            int numeroSequencia = sequenciaVerificacao1[i];
			int valorInteiro = Character.getNumericValue(CNPJNumerico.charAt(i))*numeroSequencia;
			somaPrimeiro += valorInteiro;
		}
		
		int restoPrimeiro = somaPrimeiro % 11;
		int resultadoPrimeiro = 11 - restoPrimeiro;
        if(resultadoPrimeiro < 2) resultadoPrimeiro = 0;

		if((int)resultadoPrimeiro != (int)primeiroDigitoVerificador) return false;
		
		//calculando o segundo digito
	
		for(int j = 0; j < 13; j++) {
            int numeroSequencia = sequenciaVerificacao2[j];
			int valorInteiro = Character.getNumericValue(CNPJNumerico.charAt(j)) * numeroSequencia;
			somaSegundo += valorInteiro;
		}
		int restoSegundo = somaSegundo % 11;
		int resultadoSegundo = 11 - restoSegundo;
		if(resultadoSegundo < 2) resultadoSegundo = 0;
		if(resultadoSegundo != segundoDigitoVerificador) return false;
		
		return true;
    	}
    }

