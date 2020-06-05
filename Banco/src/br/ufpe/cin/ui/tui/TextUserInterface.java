package br.ufpe.cin.ui.tui;

import java.util.Scanner;

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
import br.ufpe.cin.dados.RepositorioContas;
import br.ufpe.cin.dados.RepositorioContasArray;

public class TextUserInterface{
	
	


	private static final Banco fachada = null;
	//Banco fachada = new Banco (null);
	
	static RepositorioContas repositorio = new RepositorioContasArray(100);
	static Banco contas = new Banco(repositorio);
	
	public static void main(String[] args) throws SaldoInsuficienteException, RenderBonusContaEspecialException, RenderJurosPoupancaException  {

		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		int option = 0, typeAccount = 0;
		String numberAccount, numberAccountDestiny;
		ContaAbstrata conta = null;
		double valueAccount = 0.0;
		String InputNumberAccount = new String("Digite o número da conta: \n");
		String InputValue=new String ("Digite o valor desejado: ");
		{
			do{
				try {
					Menus.Principal();
					option = teclado.nextInt();
					switch (option) {
					case 1:
						Menus.Cadastrar();
						typeAccount = teclado.nextInt();
						switch(typeAccount) {
						case 1:
							System.out.println(InputNumberAccount);
							numberAccount = teclado.next();
							System.out.println(InputValue);
							valueAccount=teclado.nextDouble();
							 conta = new Conta(numberAccount,valueAccount);
							cadastrar(conta);

							break;
						case 2:
							System.out.println(InputNumberAccount + "CONTA ESPECIAL");
							numberAccount = teclado.next();System.out.println(InputValue);
							System.out.println(InputValue);
							valueAccount=teclado.nextDouble();
							conta = new ContaEspecial(numberAccount, valueAccount);
							cadastrar(conta);
							break;
						case 3:
							System.out.println(InputNumberAccount + "POUPANÇA");
							numberAccount = teclado.next();
							System.out.println(InputValue);
							valueAccount=teclado.nextDouble();
							conta = new Poupanca(numberAccount, valueAccount);
							cadastrar(conta);

							break;
						case 4:
							System.out.println(InputNumberAccount + "POUPANÇA ESPECIAL");
							numberAccount = teclado.next();
							System.out.println(InputValue);
							valueAccount=teclado.nextDouble();
							conta = new PoupancaEsp(numberAccount, valueAccount);
							cadastrar(conta);
							break;
						case 5:
							System.out.println(InputNumberAccount + "CONTA IMPOSTO");
							numberAccount = teclado.next();
							System.out.println(InputValue);
							valueAccount=teclado.nextDouble();
							conta = new ContaImposto(numberAccount, valueAccount);
							cadastrar(conta);

							break;
						case 0:
							Menus.Cadastrar();
							break;
						default:
							System.out.println("Opção inválida - Tente novamente!");

						}

						break;
					case 2:
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println("Digite o valor a ser creditado: ");
						valueAccount = teclado.nextDouble();
						creditar(numberAccount, valueAccount);
						break;
					case 3:
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						System.out.println("Digite o valor a ser debitado: ");
						valueAccount = teclado.nextDouble();
						debitar(numberAccount, valueAccount);
						break;
					case 4:
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						saldo(numberAccount);
						break;
					case 5:
						System.out.println(InputNumberAccount + " de origem: ");
						numberAccount = teclado.next();
						System.out.println(InputNumberAccount + " de destino: ");
						numberAccountDestiny = teclado.next();
						System.out.println("Digite o valor a ser transferido: ");
						valueAccount = teclado.nextDouble();
						transferir(numberAccount, numberAccountDestiny, valueAccount);
						break;
					case 6:
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						renderBonus(numberAccount);

						break;
					case 7:
						System.out.println(InputNumberAccount);
						numberAccount = teclado.next();
						renderJuros(numberAccount);

						break;

					case 0:
						System.out.println("Obrigado por utilizar o sistema!");
						break;
					default:
						System.out.println("Opção inválida! Digite um valor entre 0 e 7");
						break;

					}

				}catch(ContaJaCadastradaException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}

			}while (option != 0);
		}

		}
	
	
		public static void creditar(String numberAccount, double valueAccount){
			if(numberAccount.equals("")) {
				System.out.println("Por favor, insira o número da Conta!");
			}else {
				try {
					contas.creditar(numberAccount, valueAccount);
					System.out.println("Crédito inserido com sucesso!");
				
					
				}catch(ContaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				}catch(OperacaoComValoresNegativoException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		public static void cadastrar(ContaAbstrata numberAccount) throws ContaJaCadastradaException {
			if(numberAccount.equals(null)) {
				System.out.println("Por favor, insira o número da Conta!");
			}else {
				Banco fachada = new Banco (null);
				contas.cadastrar(numberAccount);
				System.out.println("Conta cadastrada com sucesso!");
			}
		}

		public static void debitar(String numberAccount, double valueAccount) throws SaldoInsuficienteException {
			if(numberAccount.equals("")) {
				System.out.println("Por favor, insira o número da Conta!");
			}else {
				try {
					contas.debitar(numberAccount, valueAccount);
					System.out.println("Conta debitada com sucesso!");
					System.out.println("Seu saldo é: " +contas.getSaldo(numberAccount));
					
				}catch(ContaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				}catch(OperacaoComValoresNegativoException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		public static void transferir(String numberAccount, String numberAccountDestiny, double valueAccount) throws SaldoInsuficienteException {
			if(numberAccount.equals("")) {
				System.out.println("Por favor, insira o número da Conta!");
			}else {
				try {
					contas.transferir(numberAccount, numberAccountDestiny, valueAccount);
					System.out.println("Transferencia realizada com sucesso!");
					System.out.println("Seu saldo é: " +contas.getSaldo(numberAccount));
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				} catch (ContaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				} catch (SaldoInsuficienteException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		public static void saldo(String numberAccount) throws SaldoInsuficienteException {
			if(numberAccount.equals("")) {
				System.out.println("Por favor, insira o número da Conta!");
			}else {
				try {
					contas.getSaldo(numberAccount);
					System.out.println("Seu saldo é: " +contas.getSaldo(numberAccount));
				}catch(ContaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		public static void renderBonus(String numberAccount) throws SaldoInsuficienteException, RenderBonusContaEspecialException {
			if(numberAccount.equals("")) {
				System.out.println("Por favor, insira o número da Conta!");
			}else {
				try {
					contas.renderBonus(numberAccount);
					System.out.println("O bônus de sua conta é: "+contas.getSaldo(numberAccount));
				} catch (ContaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				} catch (RenderBonusContaEspecialException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		public static void renderJuros(String numberAccount) throws SaldoInsuficienteException, RenderBonusContaEspecialException, RenderJurosPoupancaException {
			if(numberAccount.equals("")) {
				System.out.println("Por favor, insira o número da Conta!");
			}else {
				try {
					contas.renderJuros(numberAccount);
					System.out.println("O bônus de sua conta é: "+contas.getSaldo(numberAccount));
				} catch (ContaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				} catch (RenderJurosPoupancaException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		

	}
