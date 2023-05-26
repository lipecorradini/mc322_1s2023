import java.util.ArrayList;
import java.util.Random;

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

    public boolean removerVeiculo(Veiculo veiculo) {

        if (listaVeiculos.contains(veiculo)) {
            listaVeiculos.remove(veiculo);
            System.out.println("Veículo de placa " + veiculo.getPlaca() + " removido!");
            return true;

        } else {
            System.out.println("Desculpe, não encontramos o veículo de placa "
                    + veiculo.getPlaca() + " em nosso Sistema.");
            return false;
        }

    }
}
