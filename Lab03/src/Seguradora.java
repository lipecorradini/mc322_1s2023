import java.util.*;

public class Seguradora {
    
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList <Sinistro> listaSinistro;
    private ArrayList <Cliente> listaClientes;

    //Construtor

    public Seguradora(String nome, String telefone, String email, String endereco, List <Sinistro> listaSinistro, ArrayList <Cliente> listaClientes){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistro = listaSinistro;
        this.listaClientes = listaClientes;
        
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
        // verificar se tem alguem com o mesmo cpf ou cnpj, se tiver retornar false
        // verifficar se tem espaco para colocar na lista
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

    public List<Cliente> listarClientes(String tipoCliente){

        List<Cliente> listaAuxiliar = new ArrayList<Cliente>();

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

    public boolean gerarSinistro(){

        Seguradora seguradora = new Seguradora(nome, telefone, email,  endereco, listaSinistro, listaClientes);
        
        Sinistro sinistro = new Sinistro(email, endereco, seguradora, null, null);
        listaSinistro.add(sinistro);

        return true;
        
    }

    public boolean visualizarSinistro(String cliente){ // usar o tostring

        for(Sinistro sinistroCadastrado : listaSinistro){
            if(sinistroCadastrado.toString() == cliente){
                System.out.println(sinistroCadastrado);
                return true;
            }
        }

        return false;
    }

    public List<Sinistro> listarSinistros(){

        for(Sinistro sinistroCadastrado: listaSinistro){
            System.out.println(sinistroCadastrado);
        }

        return listaSinistro;
    }

}
