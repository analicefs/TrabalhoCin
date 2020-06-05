package br.ufpe.cin.ui.tui;

/*import java.util.Scanner;

import br.ufpe.cin.banco.Banco;
import br.ufpe.cin.banco.Conta;
import br.ufpe.cin.banco.ContaAbstrata;
import br.ufpe.cin.banco.ContaEspecial;
import br.ufpe.cin.banco.ContaImposto;
import br.ufpe.cin.banco.ContaJaCadastradaException;
import br.ufpe.cin.banco.OperacaoComValoresNegativoException;
import br.ufpe.cin.banco.Poupanca;
import br.ufpe.cin.banco.PoupancaEsp;
import br.ufpe.cin.banco.RenderBonusContaEspecialException;
import br.ufpe.cin.banco.RenderJurosPoupancaException;
import br.ufpe.cin.banco.SaldoInsuficienteException;
import br.ufpe.cin.dados.ContaNaoEncontradaException;
import br.ufpe.cin.dados.RepositorioArrayList;
import br.ufpe.cin.dados.RepositorioContas;
//import br.ufpe.cin.dados.RepositorioContasArray;

public class Menu {
	//Banco banco= new Banco(new RepositorioContasArray(200));
	 Banco banco= new Banco(new RepositorioArrayList());
	public static void main(String[] args) throws ContaJaCadastradaException, NumberFormatException, 
	OperacaoComValoresNegativoException,ContaNaoEncontradaException{

		//Banco banco = new Banco(null);
		Scanner receber = new Scanner(System.in);
		String number= new String();
		ContaAbstrata conta = null;
		//String msg = new String();
		double valor=0;
		int number1;
		int number2;
	//	int number3;
		//RepositorioContas repositorio = new RepositorioContasArray(100);
		RepositorioArrayList repositorio= new RepositorioArrayList();
		Banco bank = new Banco(repositorio);
		/* Declaração das variáveis*/

	/*	String menuPrincipal =new String("=============Banco============\n"
				+ " 1. Cadastrar uma conta\n"
				+ " 2. Creditar um valor em uma conta \n"
				+ " 3. Debitar  um  valor em uma conta \n"
				+ " 4. Verificar  o Saldo\n"
				+ " 5. Fazer transfência \n"
				+ " 6. Render Juros\n"
				+ " 7. Render Bonus\n"
				+ " 0. Sair\n"
				+ "============================\n"
				+ "Digite sua opção\n"
				+ "============================");
		String menuConta= new String("\n===========Cadastrar Conta============\n"
				+ "Escolha o tipo de conta\n"
				+ "1.Conta corrente \n"
				+ "2.Conta Imposto \n"
				+ "3.Conta Especial \n"
				+ "4.Conta Poupança \n"
				+ "5.Conta Poupança Especial \n"
				+ "0. Deseja fazer voltar ao menu Principal!\n"
				+ "===================================\n\n"
				+ " Digite sua opção abaixo\n"
				+ "====================================");

		String numeroDaconta= new String("Digite número da Conta: ");
		String valorConta= new String("Digite o valor que desejo: ");

		System.out.println(menuPrincipal);
		number1=receber.nextInt();


		while(number1>=0 || number1<=7) {
			
		if(number1==0) {
			System.out.println("Obrigada por utilizar o sistema!!");
			return;
		}	
		
		if(number1==1) {
			System.out.println(menuConta);
			number2=receber.nextInt();

	
			while(number2>0 || number2<6) {
				
				//System.out.println(menuConta);
				//System.out.println(" Digite sua opção!!\n");
				//number2=receber.nextInt();
				
				if(number2==1) {

					System.out.println(numeroDaconta);
					number= receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new Conta(number,valor);

				}else if(number2==2) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new ContaImposto(number, valor);


				}else if(number2==3) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new ContaEspecial(number, valor);
					System.out.println(repositorio);
				}
				else if(number2==4) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new Poupanca(number, valor);
					System.out.println(repositorio);

				}
				else if(number2==5) {
					System.out.println(numeroDaconta);
					number=receber.next();
					System.out.println(valorConta);
					valor=receber.nextDouble();
					conta = new PoupancaEsp(number, valor);

				}	
				else if(number2==0) {	
					System.out.println(menuPrincipal);
					number1=receber.nextInt();
				}

				try {
					bank.cadastrar(new Conta(number));
					System.out.println("Conta Criada com sucesso ! \n"
							+ " =================="
							+ "\n Conta: "+conta.getNumero()+
							"\n "
							+ "Saldo: "+conta.getSaldo());	
					System.out.println(repositorio);

				}

				catch (ContaJaCadastradaException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				} 
				
			}
			System.out.println("Você digitou uma opção inválida\n"
					+ "Digite novamente!\n\n");
			System.out.println(menuConta);
			number2=receber.nextInt();
				
		}
		
		


		if(number1==2) {

			System.out.println(numeroDaconta);
			number= receber.next();
			System.out.println(valorConta);
			valor=receber.nextDouble();
			conta= new Conta(number, valor);
			try {
				bank.creditar(number, valor);
				System.out.println("Credito executado com "
						+ "sucesso\n. A conta é"+conta.getNumero()
						+ " O saldo é "+conta.getSaldo());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (ContaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			} catch (OperacaoComValoresNegativoException e) {
				System.out.println(e.getMessage());
			}
		}
		if(number1==3) {
			System.out.println(numeroDaconta);
			number= receber.next();
			System.out.println(valorConta);
			valor=receber.nextDouble();
			conta=new Conta(number,valor);
			try {

				bank.debitar(number, valor);
				System.out.println("Debito executado com sucesso");

			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (ContaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			} catch (SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
			} catch (OperacaoComValoresNegativoException e) {
				System.out.println(e.getMessage());
			}
		}
		if(number1==4) {
			System.out.println(numeroDaconta);
			number= receber.next();
			conta=new Conta(number);
			try {
				bank.getSaldo(number);
				System.out.println("O saldo da conta "+conta.getNumero()+" eh "+conta.getSaldo());
			} catch (ContaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			}
			
		}
		if(number1==5) {
			String destino = new String();
			System.out.println(numeroDaconta);
			number=receber.next();
			System.out.println("Digite o valor que deseja transferir");
			valor=receber.nextDouble();
	
			try {
				double v = (valor);
				do {
					System.out.println("Informe o numero da conta de destino");
					destino=receber.next();
				} while (destino.equals(""));
				bank.transferir(number, destino, valor);
				System.out.println("Transferencia executada com sucesso");
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (ContaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			} catch (SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
			}
			 	
		}
		
		//Render Juros
		
		if(number1==6) {
			System.out.println(numeroDaconta);
			number= receber.next();
			System.out.println(valorConta);
			valor=receber.nextDouble();
			conta= new Conta(number);
			try {
				bank.renderJuros(number);
				System.out.println("Juros creditado com sucesso");
			} catch (ContaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			} catch (RenderJurosPoupancaException e) {
				System.out.println(e.getMessage());
			}
		}
		if(number1==7) {
			System.out.println(numeroDaconta);
			number= receber.next();
			System.out.println(valorConta);
			valor=receber.nextDouble();
			conta= new Conta(number);
			try {
				bank.renderBonus(number);
				System.out.println("Bonus creditado com sucesso");
			} catch (ContaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			} catch (RenderBonusContaEspecialException e) {
				System.out.println(e.getMessage());
			}
		}

		}
		System.out.println(menuPrincipal);
		number1=receber.nextInt();

	}
	
	}



*/




