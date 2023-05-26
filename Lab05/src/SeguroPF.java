import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SeguroPF extends Seguro {
    
    private Veiculo veiculo;
    private ClientePF cliente;


    public SeguroPF(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora
    , ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores,
     int valorMensal, Veiculo veiculo, ClientePF cliente) {

        super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
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

    public boolean gerarSinistro(Seguro seguro, Condutor condutor, String enderecoSinistro){
        /*
         * Gera um sinistro para o cliente, recebendo o seguro e o condutor,
         *  e o adiciona na lista dos sinistros do seguro
         */

        LocalDate dataAgora = LocalDate.now();
        Sinistro sinistro = new Sinistro(dataAgora, enderecoSinistro, condutor, seguro);
        getListaSinistros().add(sinistro);

        return true;
    }

    public boolean autorizarCondutor(Condutor condutor){

        if(getListaCondutores().contains(condutor)){
            condutor.setEstaAutorizado(true);
            System.out.println("O condutor " + condutor.getNome() + " está autorizado!");
            return true;

        }
        System.out.println("Não foi possível achar o condutor " + condutor.getNome());
        return false;

    }
    
    public boolean desautorizarCondutor(Condutor condutor){
        
        if(getListaCondutores().contains(condutor)){
            condutor.setEstaAutorizado(false);
            System.out.println("O condutor " + condutor.getNome() + " está desautorizado!");
            return true;

        }
        System.out.println("Não foi possível achar o condutor " + condutor.getNome());
        return false;
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
