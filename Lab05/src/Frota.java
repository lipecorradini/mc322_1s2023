import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Frota {

    private final String code;
    private ArrayList<Veiculo> listaVeiculos;

    public Frota() {
        this.code = generateCode();
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    public String getCode() {
        return this.code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public String generateCode() {

        String code = "";
        int min = 65, limite = 57;
        Random gerador = new Random();

        for (int i = 0; i < 15; i++) {
            int novoId = gerador.nextInt(limite);
            if (novoId > 25 && novoId < 32)
                i--;
            else
                code += (char) (novoId + min);
        }

        return code;
    }

    public boolean addVeiculo(Veiculo veiculo) {

        listaVeiculos.add(veiculo);
        System.out.println("Veículo de placa " + veiculo.getPlaca() + " adicionado!");
        return true;

    }

    public boolean removerVeiculo() {

        Veiculo veiculo = escolherVeiculo();

        listaVeiculos.remove(veiculo);
        System.out.println("Veículo de placa " + veiculo.getPlaca() + " removido!");
        return true;

    }

    public Veiculo escolherVeiculo(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número referente ao Veiculo: \n");
        int cont = 1;
        for(Veiculo veiculoCadastrado : getListaVeiculos()){
            System.out.println(cont + ") " + veiculoCadastrado.getPlaca());
            cont ++;
        }
        
        int numeroVeiculo = sc.nextInt();
        sc.nextLine();
        
        Veiculo VeiculoEscolhido = getListaVeiculos().get(numeroVeiculo - 1);
        sc.close();
        
        return VeiculoEscolhido;

    }
}
