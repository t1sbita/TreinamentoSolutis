import java.util.ArrayList;
import java.util.Scanner;

import models.Conta;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Conta> listaContas = new ArrayList<Conta>();
		try (Scanner leitura = new Scanner(System.in))
		{
			String nome, cpf, tipoConta;
			int enumConta;
			
			System.out.println("Quantas contas deseja cadastrar?");
			
			int qtdContas = leitura.nextInt();
			
			for (int i = 0; i < qtdContas; i++)
			{
				
				System.out.println("Insira seu nome: ");
				nome = leitura.next();
				
				System.out.println("Insira seu CPF: ");
				cpf = leitura.next();
				
				System.out.println("Qual conta voc� deseja criar? ");
				System.out.println("1 para conta corrente!");
				System.out.println("2 para conta poupan�a!");
				enumConta = leitura.nextInt();
				
				switch (enumConta)
				{
					case 1:
						tipoConta = "corrente";
						
						break;
					
					case 2:
						tipoConta = "poupan�a";
						
						break;
					
					default:
						tipoConta = "incorreta";
						System.out.println("Op��o Inv�lida");
						break;
				}
				
				Conta conta = new Conta(nome, cpf, tipoConta);
				
				System.out.println("Deseja fazer um dep�sito Inicial?");
				String SimOuNao = leitura.next();
				
				if (SimOuNao.equals("sim"))
				{
					System.out.println("Insira Valor para dep�sito inicial");
					conta.setSaldo(leitura.nextFloat());
				}
				
				System.out.printf("%s %s %s \n", conta.getNomeCliente(), conta.getCpf(), conta.getSaldo());
				
				listaContas.add(conta);
			}
			
			System.out.println("Quantas opera��es deseja fazer?");
			
			int qtdOpera = leitura.nextInt();
			
			for (int i = 0; i < qtdOpera; i++)
			{
				System.out.println("Qual nome do titular da conta voc� deseja movimentar");
				String nomeCliente = leitura.next();
				
				for (Conta conta : listaContas)
				{
					if (conta.getNomeCliente().equals(nomeCliente))
					{
						System.out.printf("Qual opera��o deseja fazer\n" + "1 para Saque \n" + "2 para Dep�sito \n"
								+ "3 para transfer�ncias \n");
						int operacao = leitura.nextInt();
						
						switch (operacao)
						{
							case 1:
							{
								
								System.out.println("Deseja fazer um saque de quanto?");
								conta.Saque(leitura.nextFloat());
								break;
							}
							case 2:
							{
								System.out.println("Deseja fazer um dep�sito de quanto?");
								conta.Deposito(leitura.nextFloat());
								break;
							}
							case 3:
							{
								System.out.println("Deseja fazer uma transferencia para quem?");
								String contaTranfer = leitura.next();
								for (Conta conta2 : listaContas)
								{
									if (conta2.getNomeCliente().equals(contaTranfer))
									{
										System.out.println("Deseja fazer uma transferencia de quanto?");
										float valor = leitura.nextFloat();
										if (conta.getTipoConta().equals(conta2.getTipoConta()))
										{
											conta.Saque(valor);
											conta2.Deposito(valor);
										}
										
									}
									
								}
								
								break;
								
							}
							default:
								throw new IllegalArgumentException("Opera��o incorreta: " + operacao);
						}
						System.out.printf("Conta %s pertence a Nome: %s, CPF: %s, Saldo: %.2f, Limite: %.2f ",
								conta.getTipoConta(), conta.getNomeCliente(), conta.getCpf(), conta.getSaldo(),
								conta.getLimite());
						
					}
				}
			}
			
		}
		
	}
}
