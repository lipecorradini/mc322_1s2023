import java.util.*;
import java.time.LocalDate;
public class Seguradora {
    
    private final String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList <Sinistro> listaSinistro;
    private ArrayList <Cliente> listaClientes;

    //Construtor

    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco){
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSinistro = new ArrayList<Sinistro>();
    }

    public String getCnpj() {
        return this.cnpj;
    }
    
    
    //Getters e Setters

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
        
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
        
    }

    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }

    public ArrayList<Sinistro> getListaSinistro(){
        return listaSinistro;
    }
    
    public boolean cadastrarCliente(Cliente cliente){
        /*
         * Se o cliente não estiver cadastrado, o adiciona na lista dos clientes, 
         * se tiver, não adiciona e retorna falso
         */
        
        if (listaClientes.indexOf(cliente) == -1){
            listaClientes.add(cliente);
            return true;
        }
        
        return false;    
    }

    public boolean removerCliente(String cliente){

        /*Remove o cliente da lista dos clientes, 
        e também remove seu respectivo sinistro */
        
        
        for(Sinistro sinistroCadastrado : listaSinistro){
            if(sinistroCadastrado.getCliente().getNome() == cliente){
                listaSinistro.remove(sinistroCadastrado);
            }
        }

        for(Cliente clienteInfo : listaClientes){
            if(clienteInfo.getNome() == cliente){
                listaClientes.remove(clienteInfo);
                return true;
            }
        }
        
        return false;

    }

    public ArrayList<Cliente> listarClientes(String tipoCliente){
        /*
         * Retorna a lista de todos os clientes a depender do tipo
         * que foi passado por parâmetro
         */

        ArrayList<Cliente> listaAuxiliar = new ArrayList<Cliente>();

        for(Cliente clienteInfo : listaClientes){
            if(tipoCliente == "ClientePJ" && clienteInfo instanceof ClientePJ){
                listaAuxiliar.add(clienteInfo);
                System.out.println(clienteInfo);
    
            }

            if(tipoCliente == "ClientePF" && clienteInfo instanceof ClientePF){
                listaAuxiliar.add(clienteInfo);
                System.out.println(clienteInfo);
    
            }
        
        }

            return listaAuxiliar;
    }


 

    public boolean visualizarSinistro(String cliente){ // vai pro seguro
        /*
         * Percorre os sinistros comparando os nomes dos clientes
         *  até achar o sinistro do respectivo cliente, depois mostra o sinistro na tela
         */

        for(Sinistro sinistroCadastrado : listaSinistro){
            if(sinistroCadastrado.getCliente().getNome() == cliente){
                System.out.println("O sinistro do cliente é: " + sinistroCadastrado + "\n");
                return true;
            }
        }

        return false;
    }

    public boolean removerSinistro(int id){ // vai pro seguro
        /*
         * Remove um sinistro a partir de seu id
         */
        
        for(Sinistro sinistroCadastrado : listaSinistro){
            if(sinistroCadastrado.getId() == id){
                listaSinistro.remove(sinistroCadastrado);
                System.out.println("Sinistro de id " + id + " removido com sucesso!");
                return true;
                
            }
        }
        return false;
    }

    public ArrayList<Sinistro> listarSinistros(){ // vai pro seguro
        /*
         * Mostra todos os sinistros cadastrados
         */

        for(Sinistro sinistroCadastrado: listaSinistro){
            System.out.println(sinistroCadastrado);
        }

        return listaSinistro;
    }

    public void listarVeiculos(){ // nao precisa estar aqui
        for(Cliente cliente: listaClientes){
            cliente.listarVeiculos();
             
            // vai ter que verificar se é pf ou pj, pra listar da frota ou do proprio cliente
        }
    }

    public double calcularPrecoSeguroCliente(Cliente cliente){ // vai pra seguro
        /*
         * Calcula o preço do seguro de um cliente conforme a formula passada
         */

        double preco;

        preco = cliente.calculaScore() * (1 + listaSinistro.size());
        return preco;
    }

    public void calcularReceita(){
        /*
         * Calcula o valor da receita total da seguradora
         * 
         */
        
        double receita = 0;
        for(Cliente cliente: listaClientes){
            receita += calcularPrecoSeguroCliente(cliente);
        }

        System.out.println("A receita total é: " + receita);
    }

    //cancelarSeguro() -> boolean
    
    //gerarSeguro() -> boolean

    //getSegurosPorCliente() -> arraylist

    //getSinistrosPorCliente() -> arraylist


}
