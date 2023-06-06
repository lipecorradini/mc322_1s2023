import java.util.*;
import java.time.LocalDate;

public class ClientePJ extends Cliente{

    private final String CNPJ;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrota;
    private int qtdeFuncionarios;

    public ClientePJ(String nome , String endereco , LocalDate dataLicenca , String CNPJ ,
     LocalDate dataFundacao, String telefone, String email, int qtdeFuncionarios){

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
        /*
         * Mostra para o cliente todos os veículos de cada frota cadastrada
         */

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
        /*
         * Cadastra uma frota no sistema
         */

        if(listaFrota.contains(frota)){
            System.out.println("A frota de código " + frota.getCode() + "já está cadastrada em nosso sistema!");
            return false;
        } 
        listaFrota.add(frota);
        System.out.println("A frota de código " + frota.getCode() + " foi adicionada com sucesso!\n");
        return true;

    }

    public boolean atualizarFrota(Veiculo veiculo){
        /*
         * Se a frota já contém o veículo, remove-o. Se não, o adiciona no sistema.
         */

        Frota frota = escolherFrota();

        if(frota.getListaVeiculos().contains(veiculo)){
            frota.getListaVeiculos().remove(veiculo);
            System.out.println("Veículo de placa " + veiculo.getPlaca() + " removido da frota de código " + frota.getCode() + "\n");

        }else{
            frota.getListaVeiculos().add(veiculo);
            System.out.println("Veículo de placa " + veiculo.getPlaca() + " adicionado à frota de código " + frota.getCode() + "\n");

        }
        return true;
    }

    public boolean atualizarFrota(){
        /*
         * Remove uma frota do sistema.
         */

        Frota frota = escolherFrota();
        listaFrota.remove(frota);
        System.out.println("Frota de código " + frota.getCode() + " removida do sistema! \n");

        return true;
    }

    public Frota escolherFrota(){
        /*
		 * Passa por todas as frotas para que o cliente possa escolher
		 */
		
		int count = 1;

        System.out.println("Digite o número equivalente à frota que deseja: ");
		for(Frota FrotasCadastrados : listaFrota){
			System.out.println(count + ") " + FrotasCadastrados.getCode());
		}

		Scanner sc = new Scanner(System.in);
		int indexFrota = sc.nextInt();
        //sc.nextLine();

		Frota FrotaEscolhido = listaFrota.get(indexFrota - 1);
       //sc.close();

        return FrotaEscolhido;
	}
}

