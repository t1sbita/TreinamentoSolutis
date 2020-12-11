import java.util.Scanner;

public class Teste
{
	public static void main(String[] args)
	{
		Scanner leitura = new Scanner(System.in);
		
		String nome, cpf, tipoConta;
		
		System.out.println("Insira seu nome: ");
		nome = leitura.next();
		System.out.println("Insira seu CPF: ");
		cpf = leitura.next();
		System.out.println("Insira tipo de conta: ");
		tipoConta = leitura.next();
		Conta conta1 = new Conta(nome, cpf, tipoConta);
		
		Conta conta2 = new Conta("Etinevaldo", "01458524", "teste");
		
		System.out.println("Deseja fazer um depósito Inicial?");
		String SimOuNao = leitura.next();
		
		if (SimOuNao.equals("sim"))
		{
			System.out.println("Insira Valor para depósito inicial");
			conta1.setSaldo(leitura.nextFloat());
		}
		
		System.out.printf("%s %s %s \n", conta1.getNomeCliente(), conta1.getCpf(), conta1.getSaldo());
		
		System.out.println("Deseja fazer um depósito de quanto?");
		conta1.Deposito(leitura.nextFloat());
		
		System.out.println("Deseja fazer um saque de quanto?");
		conta1.Saque(leitura.nextFloat());
		
		System.out.printf("%s %s %.2f %.2f", conta1.getNomeCliente(), conta1.getCpf(), conta1.getSaldo(),
				conta1.getLimite());
		
		System.out.println("Deseja fazer uma transferencia para qual conta??");
		float valor = leitura.nextFloat();
		if (conta1.getTipoConta().equals(conta2.getTipoConta()))
		{
			conta1.Saque(valor);
			conta2.Deposito(valor);
		}
		
	}
}
