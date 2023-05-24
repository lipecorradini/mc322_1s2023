import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SeguroPJ extends Seguro {
    
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora
    , ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores,
     int valorMensal,Frota frota, ClientePJ cliente) {

        super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    public Frota getFrota() {
        return this.frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    public boolean gerarSinistro(Seguro seguro, Condutor condutor, String enderecoSinistro){
        /*
         * Gera um sinistro para o cliente, recebendo o veículo e o cliente,
         *  e o adiciona na lista dos sinistros
         */

        LocalDate dataAgora = LocalDate.now();
        Sinistro sinistro = new Sinistro(dataAgora, enderecoSinistro, condutor, seguro);
        getSeguradora().getListaSinistro().add(sinistro);

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

    public double calcularValor(Condutor condutor){

        return(CalcSeguro.VALOR_BASE.getFator() 
        * (1 + 1/(frota.getListaVeiculos().size()))
        * (1 + 1 / (Period.between(cliente.getDataFundacao(),LocalDate.now()).getYears()))
        * (2 + getListaSinistros().size())
        * (5 + condutor.getListaSinistro().size())
        );
    }

}
