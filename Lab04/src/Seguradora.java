import java.util.*;
import java.time.LocalDate;
public class Seguradora {
    
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList <Sinistro> listaSinistro;
    private ArrayList <Cliente> listaClientes;

    //Construtor

    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSinistro = new ArrayList<Sinistro>();
        
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

    public void setemail(String email){
        this.email = email;
        
    }
    
    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
        
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
    
            }

            if(tipoCliente == "ClientePF" && clienteInfo instanceof ClientePF){
                listaAuxiliar.add(clienteInfo);
    
            }
        }

            return listaAuxiliar;
    }

    public boolean gerarSinistro(Veiculo veiculo, Cliente cliente){
        /*
         * Gera um sinistro para o cliente, recebendo o veículo e o cliente,
         *  e o adiciona na lista dos sinistros
         */

        Seguradora seguradora = new Seguradora(nome, telefone, email,  endereco);
        LocalDate dataAgora = LocalDate.now();
        
        Sinistro sinistro = new Sinistro(dataAgora, endereco, seguradora, veiculo, cliente);
        listaSinistro.add(sinistro);

        return true;
    }

    public boolean visualizarSinistro(String cliente){
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

    public ArrayList<Sinistro> listarSinistros(){
        /*
         * Mostra todos os sinistros cadastrados
         */

        for(Sinistro sinistroCadastrado: listaSinistro){
            System.out.println(sinistroCadastrado);
        }

        return listaSinistro;
    }

    public double calcularPrecoSeguroCliente(Cliente cliente){

        double preco;
        preco = cliente.calculaScore() * (1 + listaSinistro.size());
        //System.out.println("O preço do seguro do " + cliente.getNome() + " é: " + preco);
        return preco;
    }

    public void calcularReceita(){
        
        double receita = 0;
        for(Cliente cliente: listaClientes){
            receita += calcularPrecoSeguroCliente(cliente);
        }

        System.out.println("A receita total é: " + receita);
    }

}
