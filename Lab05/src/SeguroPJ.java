import java.time.LocalDate;
import java.time.Period;

public class SeguroPJ extends Seguro {

    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(LocalDate dataInicio, Seguradora seguradora,
             Frota frota, ClientePJ cliente) {

        super(dataInicio, seguradora);
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

    public double calcularValor() {

        int qtdeSinistroCondutores = 0;
        for (Condutor condutorCadastrado : getListaCondutores()) {
            qtdeSinistroCondutores += condutorCadastrado.getListaSinistro().size();
        }

        return (CalcSeguro.VALOR_BASE.getFator()
                * (10 + getCliente().getQtdeFuncionarios() / 10)
                * (1 + 1 / (frota.getListaVeiculos().size()))
                * (1 + 1 / (Period.between(cliente.getDataFundacao(), LocalDate.now()).getYears()))
                * (2 + getListaSinistros().size() / 10)
                * (5 + qtdeSinistroCondutores / 10));
    }

}
