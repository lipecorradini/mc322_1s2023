import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Seguro {
    
    private int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;


    public Seguro(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros
                    , ArrayList<Condutor> listaCondutores, int valorMensal) {
        this.id = generateId();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = valorMensal;
    }

    private int generateId() {
			
        Random gerador = new Random();
        int limite = 999999999;
        int novoId = gerador.nextInt(limite);
        return novoId;
        
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return this.listaCondutores;
    }

    public int getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", dataInicio='" + getDataInicio() + "'" +
            ", dataFim='" + getDataFim() + "'" +
            ", seguradora='" + getSeguradora() + "'" +
            ", listaSinistros='" + getListaSinistros() + "'" +
            ", listaCondutores='" + getListaCondutores() + "'" +
            ", valorMensal='" + getValorMensal() + "'" +
            "}";
    }


    // abstract desautorizarCondutor() -> opcional
    public abstract boolean desautorizarCondutor(Condutor condutor);

    // abstract autorizarCondutor() -> opcional
    public abstract boolean autorizarCondutor(Condutor condutor);

    // abstract calcularValor() -> opcional
    public abstract double calcularValor(Condutor condutor);

    // abstract gerarSinistro() -> opcional
    public abstract boolean gerarSinistro(Seguro seguro, Condutor condutor, String enderecoSinistro);
}
