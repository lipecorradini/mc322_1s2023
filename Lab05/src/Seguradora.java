import java.util.*;
import java.time.LocalDate;

public class Seguradora {

    private final String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros;
    private ArrayList<Cliente> listaClientes;

    // Construtor

    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSeguros = new ArrayList<Seguro>();
    }

    public String getCnpj() {
        return this.cnpj;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Seguro> getListaSeguro() {
        return listaSeguros;
    }

    public boolean cadastrarCliente(Cliente cliente) {

        /*
         * Se o cliente não estiver cadastrado, o adiciona na lista dos clientes,
         * se tiver, não adiciona e retorna falso
         */

        if (cliente instanceof ClientePF && !Validacao.validarCPF(((ClientePF) (cliente)).getCpf())) {
            System.out.println("O CPF do cliente não é válido! ");
            return false;
        }

        if (cliente instanceof ClientePJ && !Validacao.validarCNPJ(((ClientePJ) (cliente)).getCNPJ())) {
            System.out.println("O CNPJ do cliente não é válido! ");
            return false;
        }

        if (listaClientes.indexOf(cliente) == -1) {
            listaClientes.add(cliente);
            System.out.println("Cliente " + cliente.getNome() + " cadastrado no sistema com sucesso!");
            return true;
        }

        System.out.println("Cliente " + cliente.getNome() + " já está em nosso sistema!");

        return false;
    }

    public boolean removerCliente() {

        /*
         * Remove o cliente da lista dos clientes,
         * e também remove seu respectivo seguro
         */

        Cliente cliente = escolherCliente();
        int tipoCliente = -1;
        if (cliente instanceof ClientePF)
            tipoCliente = 1;
        else
            tipoCliente = 2;

        // Removendo o seguro do respectivo cliente
        for (Seguro seguroCliente : listaSeguros) {
            if (tipoCliente == 1) {
                if (((SeguroPF) (seguroCliente)).getCliente() == (ClientePF) cliente) {
                    listaSeguros.remove(seguroCliente);
                }
            } else {
                if (((SeguroPJ) (seguroCliente)).getCliente() == (ClientePJ) cliente) {
                    listaSeguros.remove(seguroCliente);
                }
            }
        }

        // Removendo o cliente da lista de Clientes
        for (Cliente clienteInfo : listaClientes) {
            if (clienteInfo.getNome().equals(cliente.getNome())) {
                listaClientes.remove(clienteInfo);
                System.out.println("Cliente " + cliente.getNome() + " removido do sistema com sucesso!");
                return true;
            }
        }
        return false; // nunca deve chegar aqui
    }

    public void listarClientes(String tipoCliente) {
        /*
         * Retorna a lista de todos os clientes a depender do tipo
         * que foi passado por parâmetro
         */

        int counter = 0;

        for (Cliente clienteInfo : listaClientes) {
            if (tipoCliente.equals("ClientePJ") && clienteInfo instanceof ClientePJ) {
                counter++;
                System.out.println(counter + ") " + clienteInfo.getNome());
            }

            if (tipoCliente.equals("ClientePF") && clienteInfo instanceof ClientePF) {
                counter++;
                System.out.println(counter + ") " + clienteInfo.getNome());
            }
        }

        if(counter == 0){
            System.out.println("Não existem clientes cadastrados!");
        }
    }

    public boolean gerarSeguro() {

        Cliente cliente = escolherCliente();

        if (cliente instanceof ClientePF) { // Pessoa Física

            Veiculo veiculoEscolhido = ((ClientePF) (cliente)).escolherVeiculo();
            SeguroPF novoSeguroPF = new SeguroPF(LocalDate.now(), this, veiculoEscolhido, (ClientePF) (cliente));
            listaSeguros.add(novoSeguroPF);
            System.out.println("Seguro de código " + novoSeguroPF.getId() + " adicionado com sucesso ao cliente " + cliente.getNome() + "!\n");

        } else {
            Frota frotaEscolhida = ((ClientePJ) (cliente)).escolherFrota();
            SeguroPJ novoSeguroPJ = new SeguroPJ(LocalDate.now(), this,
                    frotaEscolhida, (ClientePJ) (cliente));
            listaSeguros.add(novoSeguroPJ);
            System.out.println("Seguro de código " + novoSeguroPJ.getId() + " adicionado com sucesso ao cliente " + cliente.getNome() + "!\n");

        }

        return true;

    }

    public boolean cancelarSeguro() {

        int cont = 1;
        System.out.println("Digite o número do Seguro que quer cancelar: ");
        for (Seguro seguroCadastrado : listaSeguros) {
            System.out.println(cont + ") " + seguroCadastrado.getId());

        }

        Scanner sc = new Scanner(System.in);
        int indexSeguro = sc.nextInt();
        sc.nextLine();

        // sc.close();

        Seguro seguroCancelado = listaSeguros.get(indexSeguro);
        listaSeguros.remove(seguroCancelado);
        System.out.println("Seguro de índice " + seguroCancelado.getId() + " cancelado!");

        return true;

    }

    public ArrayList<Seguro> getSegurosPorCliente() {

        Cliente cliente = escolherCliente();

        ArrayList<Seguro> listaAuxiliar = new ArrayList<Seguro>();

        System.out.println("Seguros do Cliente " + cliente.getNome() + ": ");
        for (Seguro seguroCadastrado : listaSeguros) {

            if (cliente instanceof ClientePF && seguroCadastrado instanceof SeguroPF
                    && ((SeguroPF) (seguroCadastrado)).getCliente() == ((ClientePF) (cliente))) {
                listaAuxiliar.add(seguroCadastrado);
                System.out.println("- " + seguroCadastrado.getId());
            } else if (cliente instanceof ClientePJ && seguroCadastrado instanceof SeguroPJ
                    && ((SeguroPJ) (seguroCadastrado)).getCliente() == ((ClientePJ) (cliente))) {
                listaAuxiliar.add(seguroCadastrado);
                System.out.println("- " + seguroCadastrado.getId());
            }
        }

        return listaAuxiliar;
    }

    public ArrayList<Sinistro> getSinistrosPorCliente() {

        Cliente cliente = escolherCliente();
        ArrayList<Sinistro> listaAuxiliar = new ArrayList<Sinistro>();

        System.out.println("Sinistros do Cliente " + cliente.getNome() + ": ");
        for (Seguro seguroCadastrado : listaSeguros) {

            if (cliente instanceof ClientePF && seguroCadastrado instanceof SeguroPF
                    && ((SeguroPF) (seguroCadastrado)).getCliente() == ((ClientePF) (cliente))) {
                for (Sinistro sinistro : seguroCadastrado.getListaSinistros()) {
                    listaAuxiliar.add(sinistro);
                    System.out.println("- " + sinistro.getId());
                }
            } else if (cliente instanceof ClientePJ && seguroCadastrado instanceof SeguroPJ
                    && ((SeguroPJ) (seguroCadastrado)).getCliente() == ((ClientePJ) (cliente))) {
                for (Sinistro sinistro : seguroCadastrado.getListaSinistros()) {
                    listaAuxiliar.add(sinistro);
                    System.out.println("- " + sinistro.getId());
                }
            }
        }

        return listaAuxiliar;

    }

    public Cliente escolherCliente() {

        int count = 1;

        System.out.println("Digite o número equivalente ao cliente que deseja: ");
        for (Cliente cliente : listaClientes) {
            System.out.println(count + ") " + cliente.getNome());
            count++;
        }

        Scanner sc = new Scanner(System.in);
        int indexCliente = sc.nextInt();

        Cliente clienteEscolhido = listaClientes.get(indexCliente - 1);
        //sc.close();
        return clienteEscolhido;
    }

    public Seguro escolherSeguro(){

        int count = 1;

        System.out.println("Digite o número equivalente ao Seguro que deseja: ");
        for (Seguro seguro : listaSeguros) {
            System.out.println(count + ") " + seguro.getId());
            count++;
        }

        Scanner sc = new Scanner(System.in);
        int indexSeguro = sc.nextInt();

        Seguro SeguroEscolhido = listaSeguros.get(indexSeguro - 1);
        // sc.close();
        return SeguroEscolhido;
    }

    public void removerSeguro(){
        
        Seguro seguro = escolherSeguro();
        listaSeguros.remove(seguro);
        System.out.println("O Seguro de id " + seguro.getId() + " foi removido com sucesso! ");
    }

    public void calcularReceita() {
        /*
         * Calcula o valor da receita para cada seguro para cada cliente da seguradora
         * 
         */
        int cont = 0;
        System.out.println("Receita de todos os Clientes da Seguradora:  ");
        for (Seguro seguro : listaSeguros) {
            double valorSeguro = seguro.calcularValor();
            System.out.println("[" + cont + "] " + seguro.getId() + " = R$" + valorSeguro);
            cont++;
        }

        if(cont == 0) System.out.println("Não existem Clientes cadastrados na seguradora desejada! ");

    }

}
