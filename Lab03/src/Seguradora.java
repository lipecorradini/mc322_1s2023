import java.util.*;

public class Seguradora {
    
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List <Sinistro> listaSinistro;
    private List <Cliente> listaClientes;



    //Construtor

    public Seguradora(String nome, String telefone, String email, String endereco, List <Sinistro> listaSinistro, List <Cliente> listaClientes){
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
    
        listaClientes.add(cliente);
        return true;
    }
}
