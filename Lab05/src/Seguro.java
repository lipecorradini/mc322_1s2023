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

    public Seguro(LocalDate dataInicio, Seguradora seguradora) {
        this.id = generateId();
        this.dataInicio = dataInicio;
        this.dataFim = dataInicio.plusYears(5);
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = 0;
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

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
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
        /*
         * Autoriza o condutor
         */

        if (getListaCondutores().contains(condutor)) {
            condutor.setEstaAutorizado(true);
            System.out.println("O condutor " + condutor.getNome() + " está autorizado!");
            return true;

        }
        System.out.println("Não foi possível achar o condutor " + condutor.getNome());
        return false;

    }

    public boolean desautorizarCondutor(Condutor condutor) {
        /*
         * Desautoriza o condutor
         */

        if (getListaCondutores().contains(condutor)) {
            condutor.setEstaAutorizado(false);
            System.out.println("O condutor " + condutor.getNome() + " está desautorizado!");
            return true;

        }
        System.out.println("Não foi possível achar o condutor " + condutor.getNome());
        return false;
    }

    public abstract double calcularValor();

    public boolean gerarSinistro(Condutor condutor, String enderecoSinistro){
        /*
         * Gera um sinistro para o cliente, recebendo o seguro e o condutor,
         *  e o adiciona na lista dos sinistros do seguro
         */

        LocalDate dataAgora = LocalDate.now();
        Sinistro sinistro = new Sinistro(dataAgora, enderecoSinistro, condutor, this);
        condutor.adicionarSinistro(sinistro);
        getListaSinistros().add(sinistro);

        return true;
    }
    
    public Condutor escolherCondutor() {
        /*
		 * Passa por todos os condutores para que o cliente possa escolher
		*/

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
        //sc.close();
        return condutorEscolhido;

    }

    public void listarSinistros(){
        /*
         * Lista todos os sinistros de um seguro
         */

        for(Sinistro sinistro : listaSinistros){
            System.out.println("    -" + sinistro.getId() + " do condutor " + sinistro.getCondutor());
        }
    }

    public void excluirSinistro(){
        /*
         * Exclui um sinistro do seguro
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número referente ao Sinistro: \n");
        int cont = 1;
        for (Sinistro SinistroCadastrado : getListaSinistros()) {
            
            System.out.println(cont + ") " + SinistroCadastrado.getId());
            cont++;
        }

        int numeroSinistro = sc.nextInt();
        sc.nextLine();

        Sinistro sinistroEscolhido = getListaSinistros().get(numeroSinistro - 1);
        //sc.close();
        
        listaSinistros.remove(sinistroEscolhido);
        System.out.println("Sinistro de código " + sinistroEscolhido.getId() + " removido com sucesso! ");
    }

    public void excluirCondutor(){
        /*
         * Exclui um condutor do Seguro
         */

        Condutor condutor = escolherCondutor();
        listaCondutores.remove(condutor);
        System.out.println("O condutor " + condutor.getNome() + " foi removido do sistema! ");


    }

    public void cadastrarCondutor(Condutor condutor){
        /*
         * Cadastra um condutor no Seguro
         */

        listaCondutores.add(condutor);
        System.out.println("O condutor " + condutor.getNome() + " foi adicionado ao sistema! ");
        
        
    }
}
