public enum MenuOperacoes {
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
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

    public MenuOperacoes retornarComando(double comando){
        for(MenuOperacoes comandos : values()){
            if(comandos.getOperacao() == comando){
                return comandos;
            }
        }
        return ERRO;
    }
    
}
