import java.util.ArrayList;
import java.util.Scanner;

import models.Conta;

public class App {
	public static void main(String[] args) throws Exception {

		ArrayList<Conta> listaContas = new ArrayList<Conta>();
		try (Scanner leitura = new Scanner(System.in)) {
			String nome, cpf, tipoConta;
			int enumConta;

			System.out.println("Quantas contas deseja cadastrar?");

			int qtdContas = leitura.nextInt();

			for (int i = 0; i < qtdContas; i++) {

				System.out.println("Insira seu nome: ");
				nome = leitura.next();

				System.out.println("Insira seu CPF: ");
				cpf = leitura.next();

				System.out.println("Qual conta você deseja criar? ");
				System.out.println("1 para conta corrente!");
				System.out.println("2 para conta poupança!");
				enumConta = leitura.nextInt();

				switch (enumConta) {
					case 1:
						tipoConta = "corrente";

						break;

					case 2:
						tipoConta = "poupança";

						break;

					default:
						tipoConta = "incorreta";
						System.out.println("Opção Inválida");
						break;
				}

				Conta conta = new Conta(nome, cpf, tipoConta);

				System.out.println("Deseja fazer um depósito Inicial?");
				String simOuNao = leitura.next();

				if (simOuNao.equals("sim")) {
					System.out.println("Insira Valor para depósito inicial");
					conta.Deposito(leitura.nextFloat());
				}

				System.out.printf(conta.toString());

				listaContas.add(conta);
			}

			System.out.println("Quantas operações deseja fazer?");

			int qtdOpera = leitura.nextInt();

			for (int i = 0; i < qtdOpera; i++) {
				System.out.println("Qual nome do titular da conta você deseja movimentar");
				String nomeCliente = leitura.next();

				for (Conta conta : listaContas) {
					if (conta.getNome().equals(nomeCliente)) {
						System.out.printf("Qual operação deseja fazer\n" + "1 para Saque \n" + "2 para Depósito \n"
								+ "3 para transferências \n");
						int operacao = leitura.nextInt();

						switch (operacao) {
							case 1: {

								System.out.println("Deseja fazer um saque de quanto?");
								conta.Saque(leitura.nextFloat());
								break;
							}
							case 2: {
								System.out.println("Deseja fazer um depósito de quanto?");
								conta.Deposito(leitura.nextFloat());
								break;
							}
							case 3: {
								System.out.println("Deseja fazer uma transferencia para quem?");
								String contaTranfer = leitura.next();
								for (Conta conta2 : listaContas) {
									if (conta2.getNome().equals(contaTranfer)) {
										System.out.println("Deseja fazer uma transferencia de quanto?");
										float valor = leitura.nextFloat();
										if (conta.getTipoConta().equals(conta2.getTipoConta())) {
											conta.Saque(valor);
											conta2.Deposito(valor);
										}

									}

								}

								break;

							}
							default:
								throw new IllegalArgumentException("Operação incorreta: " + operacao);
						}

						System.out.println(conta.toString());
					}
				}
			}

			System.out.printf(listaContas.toString());
		}
	}
}
