import java.util.*;;

public class ClientePJ extends Cliente{

    private String CNPJ;
    private Date dataFundacao;

    public ClientePJ(String nome , String endereco , Date dataLicenca ,
     String educacao , String genero , String classeEconomica ,
     List < Veiculo > listaVeiculos , String CNPJ , Date dataFundacao){

        super ( nome , endereco , dataLicenca , educacao , genero , classeEconomica , listaVeiculos );
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

    


    
}
