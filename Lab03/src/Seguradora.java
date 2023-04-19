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
        
        if (listaClientes.indexOf(cliente) == -1){
            listaClientes.add(cliente);
            return true;
        }
        
        return false;    
    }

    public boolean removerCliente(String cliente){ // usar o to string

        for(Cliente clienteInfo : listaClientes){
            if(clienteInfo.toString() == cliente){
                listaClientes.remove(clienteInfo);
                return true;
            }
        }
        return false;

    }

    public ArrayList<Cliente> listarClientes(String tipoCliente){

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

        Seguradora seguradora = new Seguradora(nome, telefone, email,  endereco);
        LocalDate dataAgora = LocalDate.now();
        
        Sinistro sinistro = new Sinistro(dataAgora, endereco, seguradora, veiculo, cliente);
        listaSinistro.add(sinistro);

        return true;
    }

    public boolean visualizarSinistro(String cliente){ // usar o tostring

        for(Sinistro sinistroCadastrado : listaSinistro){
            if(sinistroCadastrado.getCliente().getNome() == cliente){
                System.out.println("O sinistro do cliente é: " + sinistroCadastrado + "\n");
                return true;
            }
        }

        return false;
    }

    public ArrayList<Sinistro> listarSinistros(){

        for(Sinistro sinistroCadastrado: listaSinistro){
            System.out.println(sinistroCadastrado);
        }

        return listaSinistro;
    }

}
