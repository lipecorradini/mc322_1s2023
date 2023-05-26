import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Seguro {

    private int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;

    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        this.id = generateId();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = calcularValor();
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

    public double getValorMensal() {
        return this.valorMensal;
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

    public boolean autorizarCondutor(Condutor condutor) {

        if (getListaCondutores().contains(condutor)) {
            condutor.setEstaAutorizado(true);
            System.out.println("O condutor " + condutor.getNome() + " está autorizado!");
            return true;

        }
        System.out.println("Não foi possível achar o condutor " + condutor.getNome());
        return false;

    }

    public boolean desautorizarCondutor(Condutor condutor) {

        if (getListaCondutores().contains(condutor)) {
            condutor.setEstaAutorizado(false);
            System.out.println("O condutor " + condutor.getNome() + " está desautorizado!");
            return true;

        }
        System.out.println("Não foi possível achar o condutor " + condutor.getNome());
        return false;
    }

    public abstract double calcularValor();

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
    
    public Condutor escolherCondutor() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número referente ao Condutor: \n");
        int cont = 1;
        for (Condutor condutorCadastrado : getListaCondutores()) {
            System.out.println(cont + ") " + condutorCadastrado.getNome());
            cont++;
        }

        int numeroCondutor = sc.nextInt();
        sc.nextLine();

        Condutor condutorEscolhido = getListaCondutores().get(numeroCondutor - 1);
        sc.close();
        return condutorEscolhido;

    }
}
