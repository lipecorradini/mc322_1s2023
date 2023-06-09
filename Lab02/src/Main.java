public class Main {
	
	public static void main(String[] args) {

		//Cliente
		
		Cliente pessoa = new Cliente("claudio", "120.102.984-89", 
		"10/04/2004", 18, "longe");

		pessoa.setNome("jorge camargo de almeida");
		System.out.println(pessoa.getNome());

		pessoa.setCpf("531.655.028-54");
		System.out.println(pessoa.getCpf());

		pessoa.setDataNascimento("15/06/1975");
		System.out.println(pessoa.getDataNascimento());

		pessoa.setIdade(47);
		System.out.println(pessoa.getIdade());

		pessoa.setEndereco("rua francisco humberto zuppi");
		System.out.println(pessoa.getEndereco());

		String tudo = pessoa.toString();
        System.out.println(tudo);

		boolean ehValido = pessoa.validarCPF(pessoa.getCpf());
		System.out.println("o cpf eh valido: " + ehValido);


		//Veiculo
		
		Veiculo carro = new Veiculo("NNT-4822", "Suzuki", "Gran Vitara");

		carro.setPlaca("NNT-4821");
		System.out.println(carro.getPlaca());


		//Seguradora

		Seguradora informacoesSeguradora = new Seguradora("jose claudio fonseca teles", "81 997282004"
		, "luizcorradini@gmail.com", "av zuppi 27");

		informacoesSeguradora.setNome("marcos jose silva");
		System.out.println(informacoesSeguradora.getNome());


		//Sinistro

		Sinistro sinistroDaSeguradora = new Sinistro("21/03/2023", "av zuppi 27");

		System.out.println(sinistroDaSeguradora.getId());
		
		sinistroDaSeguradora.setData("11/11/2011");
		System.out.println(sinistroDaSeguradora.getData());
	
	}
    
}
