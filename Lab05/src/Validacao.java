public class Validacao {
        
        public static boolean validarCNPJ(String CNPJ){
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
            
            int primeiroDigitoVerificador = Character.getNumericValue(CNPJNumerico.charAt(12));
    
            int segundoDigitoVerificador = Character.getNumericValue(CNPJNumerico.charAt(13));
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
            
            //Verificando se o resultado do primeiro digito verificador é realmente igual ao primeiro digito
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
            
            //Verificando se o resultado calculado do segundo dígito condiz com o segundo digito
            if(resultadoSegundo != segundoDigitoVerificador) return false;
            
            return true;
            }
    

    public static boolean validarCPF(String cpf) {
		/*
		 * Recebe um cpf e verifica se é válido
		 */
		
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

    public static boolean validarNome(String nome){
        /*
         * Valida o nome, verifica se so sao caracteres
         */
        for(int i = 0; i < nome.length(); i++){
            char letra = nome.charAt(i);
            if(!Character.isAlphabetic(letra) && letra != '_'){
                return false;
            }

        }

        return true;
    }
}
