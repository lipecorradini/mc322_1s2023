public enum CalcSeguro {
    VALOR_BASE(10.0),
    FATOR_30(1.25),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    public final double fator;

    CalcSeguro(double fator){
        this.fator = fator;
    }

    public double getFator(){
        return fator;
    }

    public static CalcSeguro getFatorIdade(int idade){
        /*
         * Retorna o fator correspondente a idade
         */
        if(idade >= 18 && idade < 30) return FATOR_30;
        else if(idade >= 30 && idade < 60) return FATOR_30_60;
        else return FATOR_60_90;
    }

}
