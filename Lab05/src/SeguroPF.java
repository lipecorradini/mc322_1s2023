import java.time.LocalDate;
import java.time.Period;

public class SeguroPF extends Seguro {
    
    private Veiculo veiculo;
    private ClientePF cliente;


    public SeguroPF( LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora
    , Veiculo veiculo, ClientePF cliente) {

        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
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

        int qtdeSinistroCondutores = 0;
        for(Condutor condutorCadastrado : getListaCondutores()){
            qtdeSinistroCondutores += condutorCadastrado.getListaSinistro().size();
        }
        
        return (CalcSeguro.VALOR_BASE.getFator() 
        * CalcSeguro.getFatorIdade(Period.between(cliente.getDataNascimento(), LocalDate.now()).getYears()).getFator()
        * (1 + 1/(cliente.getListaVeiculos().size() + 2)
        * (2 + getListaSinistros().size()/10) 
        * (5 + qtdeSinistroCondutores/10))
        );
    }

}
