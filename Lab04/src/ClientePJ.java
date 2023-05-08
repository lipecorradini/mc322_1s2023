import java.util.*;
import java.time.LocalDate;

public class ClientePJ extends Cliente{

    private String CNPJ;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;

    public ClientePJ(String nome , String endereco , LocalDate dataLicenca , String CNPJ , LocalDate dataFundacao, int qtdeFuncionarios, double valorSeguro){

        super ( nome , endereco , valorSeguro);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public int getQtdeFuncionarios() {
        return this.qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    @Override

    public String toString(){
        String tudo = "\n CNPJ: " + CNPJ + "\n data fundacao: " + dataFundacao;
        return tudo;
    }

    
        public double calculaScore(){

            ArrayList<Veiculo> listaVeiculos = getListaVeiculos();
            return (1 + (qtdeFuncionarios)/100) * listaVeiculos.size();

        }
    }

