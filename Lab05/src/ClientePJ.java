import java.util.*;
import java.time.LocalDate;

public class ClientePJ extends Cliente{

    private final String CNPJ;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrota;
    private int qtdeFuncionarios;

    public ClientePJ(String nome , String endereco , LocalDate dataLicenca , String CNPJ ,
     LocalDate dataFundacao, double valorSeguro, String telefone, String email, int qtdeFuncionarios){

        super ( nome , endereco , telefone, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrota = new ArrayList<Frota>();
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public int getQtdeFuncionarios(){
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
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
        getVeiculosPorFrota();
    }

    public void getVeiculosPorFrota(){

        int contFrota = 0, contVeiculos = 0;
        for(Frota frotaCadastrada: listaFrota){
            contVeiculos = 0;
            contFrota += 1;
            System.out.println("Frota " + contFrota + ":");
            for(Veiculo veiculoCadastrado : frotaCadastrada.getListaVeiculos()){
                contVeiculos += 1;
                System.out.println(contVeiculos + ") " + veiculoCadastrado.getModelo()
                 + " de placa " + veiculoCadastrado.getPlaca());
            }
        }
    }

    public boolean cadastrarFrota(Frota frota){

        if(listaFrota.contains(frota)){
            System.out.println("A frota de código " + frota.getCode() + "já está cadastrada em nosso sistema!");
            return false;
        } 
        listaFrota.add(frota);
        System.out.println("A frota de código " + frota.getCode() + "foi adicionada com sucesso!");
        return true;

    }
}

