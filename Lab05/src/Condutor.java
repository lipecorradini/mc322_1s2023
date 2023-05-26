import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
    
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private ArrayList<Sinistro> listaSinistro;
    private boolean autorizado;

    public Condutor(String cpf, String nome, String telefone, String endereco
        , String email, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistro = new ArrayList<Sinistro>();
        this.autorizado = true;
    }

    public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }

    public boolean getAutorizado() {
        return this.autorizado;
    }

    public void setEstaAutorizado(boolean estaAutorizado) {
        this.autorizado = estaAutorizado;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistro() {
        return this.listaSinistro;
    }


    @Override
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", nome='" + getNome() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", email='" + getEmail() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", listaSinistro='" + getListaSinistro() + "'" +
            ", estaAutorizado='" + getAutorizado() + "'" +
            "}";
    }

    public void adicionarSinistro(Sinistro sinistro){
        /*
         * Adiciona um Sinistro à lista de sinistros do condutor
         */
        
        listaSinistro.add(sinistro);
        System.out.println("O Sinistro de código " + sinistro.getId()
         + " foi adicionado ao nosso sistema!");
    }

}
