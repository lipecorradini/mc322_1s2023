import java.time.LocalDate;
import java.time.Period;

public class SeguroPF extends Seguro {
    
    private Veiculo veiculo;
    private ClientePF cliente;


    public SeguroPF( LocalDate dataInicio, Seguradora seguradora
    , Veiculo veiculo, ClientePF cliente) {

        super(dataInicio, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    public double calcularValor(){
        /*
         * Calcula o valor do Seguro PF
         */

        int qtdeSinistroCondutores = 0;
        for(Condutor condutorCadastrado : getListaCondutores()){
            qtdeSinistroCondutores += condutorCadastrado.getListaSinistro().size();
        }

        int idade = (Period.between(getCliente().getDataNascimento(), LocalDate.now())).getYears();

        double fatorIdade;
        if(idade < 30){
            fatorIdade = CalcSeguro.FATOR_30.getFator();
        }else if(idade < 60){
            fatorIdade = CalcSeguro.FATOR_30_60.getFator();
        }else{
            fatorIdade = CalcSeguro.FATOR_60_90.getFator();
        }
        
        return (CalcSeguro.VALOR_BASE.getFator() 
        * fatorIdade
        * (1 + 1/(cliente.getListaVeiculos().size() + 2)
        * (2 + getListaSinistros().size()/10) 
        * (5 + qtdeSinistroCondutores/10))
        );
    }

}
