import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public class ClientePF extends Cliente {

	private LocalDate dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
    private String cpf;
    private LocalDate dataNascimento;
	

    public ClientePF( String nome , String endereco , LocalDate dataLicenca ,
     String educacao , String genero , String classeEconomica , String cpf , LocalDate dataNascimento, double valorSeguro){      

        super ( nome , endereco, valorSeguro );
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
        String tudo = "\n cpf: " + cpf +  "\n Educacao: " + educacao + "\n genero: " + genero + "\n classe economica: " + classeEconomica +
		 "\n data nascimento: " + dataNascimento + "\n data licenca: " + dataLicenca;
        return tudo;
    }


	public double calculaScore(){

		LocalDate hoje = LocalDate.now();
		int idade =	Period.between(dataNascimento, hoje).getYears();
		ArrayList<Veiculo> listaVeiculos = getListaVeiculos();
		int numeroVeiculos = listaVeiculos.size();
		
		if(idade < 30){
			return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * numeroVeiculos;
		
		}else if(idade < 60){
			return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * numeroVeiculos;
		
		}else{
			return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * numeroVeiculos;

		}
	}
}
