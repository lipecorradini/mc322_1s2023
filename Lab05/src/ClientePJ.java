import java.util.*;
import java.time.LocalDate;

public class ClientePJ extends Cliente{

    private final String CNPJ;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrota;

    public ClientePJ(String nome , String endereco , LocalDate dataLicenca , String CNPJ ,
     LocalDate dataFundacao, double valorSeguro, String telefone, String email){

        super ( nome , endereco , telefone, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrota = new ArrayList<Frota>();
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }


    @Override
    public String toString() {
        return "{" +
            " CNPJ='" + getCNPJ() + "'" +
            ", dataFundacao='" + getDataFundacao() + "'" +
            "}";
    }
    

    public void listarVeiculos(){
        // criar a funcao getVeiculosPorFrota e chamar ela aqui
        getVeiculosPorFrota();
    }


    public void getVeiculosPorFrota(){
        //
    }

    //cadastrarFrota()

	//atulizarFrota()

	//getVeiculosPorFrota()

    }

