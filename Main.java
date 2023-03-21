package mc322_1s2023;

public class Main {
	
	public static void main(String[] args) {
		
		Cliente pessoa = new Cliente("claudio", "000.000.000-0", 
		"10/04/2004", 18, "longe");
		boolean valor = pessoa.validarCPF(pessoa.getCpf());
		
		System.out.println(valor);
	}
    
}
