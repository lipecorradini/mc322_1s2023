public enum MenuOperacoes {
    CADASTRAR(1),
    CADASTRAR_CLIENTE(1.1),
    CADASTRAR_VEICULO(1.2),
    CADASTRAR_SEGURADORA(1.3),
    SAIR_CADASTRAR(1.4),
    
    LISTAR(2),
    LISTAR_CLIENTE_POR_SEGURADORA(2.1),
    LISTAR_SINISTRO_POR_SEGURADORA(2.2),
    LISTAR_SINISTRO_POR_CLIENTE(2.3),
    LISTAR_VEICULO_POR_CLIENTE(2.4),
    LISTAR_VEICULO_POR_SEGURADORA(2.5),
    SAIR_LISTAR(2.6),
    
    EXCLUIR(3),
    EXCLUIR_CLIENTE(3.1),
    EXCLUIR_VEICULO(3.2),
    EXCLUIR_SINISTRO(3.3),
    SAIR_EXCLUIR(3.4),

    SAIR(0),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALCULAR_RECEITA_SEGURADORA(6),
    ERRO(-1);


    public final double operacao;

    MenuOperacoes(double operacao){
        this.operacao = operacao;

    }

    public double getOperacao() {
        return this.operacao;
    }

    public static MenuOperacoes retornarComando(double comando){
        for(MenuOperacoes comandos : values()){
            if(comandos.getOperacao() == comando){
                return comandos;
            }
        }
        return ERRO;
    }
    
}
