package br.ufpe.cin.ui.tui;

public class Menus {
	
	static void Principal() {
		System.out.println("______Bem vindo a aplicação bancária____");
		System.out.println("Digite a opção desejada:				");
		System.out.println("(1) - CADASTRAR							");
		System.out.println("(2) - CREDITAR							");
		System.out.println("(3) - DEBITAR							");
		System.out.println("(4) - SALDO								");
		System.out.println("(5) - TRANSFERÊNCIA						");
		System.out.println("(6) - RENDER BONUS						");
		System.out.println("(7) - RENDER JUROS						");
		System.out.println("(0) - SAIR DO SISTEMA					");
		System.out.println("________________________________________");
	};
	
	static void Cadastrar() {
		System.out.println("_____Bem vindo a aplicação bancária____");
		System.out.println("Você escolheu a opção 1 - cadastrar. 	");
		System.out.println("O que você deseja cadastrar?. 			");
		System.out.println("Digite a opção desejada:				");
		System.out.println("(1) - CONTA								");
		System.out.println("(2) - CONTA ESPECIAL					");
		System.out.println("(3) - POUPANÇA							");
		System.out.println("(4) - POUPANÇA ESPECIAL					");
		System.out.println("(5) - CONTA IMPOSTO						");
		System.out.println("(0) - VOLTAR PRO MENU INICIAL			");
		System.out.println("________________________________________");

	};
	
	static void CadastroRealizado() {
		System.out.println("Cadastro Realizado com sucesso!");	
	};
	
	static void PosCadastro() {
		System.out.println("O que deseja fazer agora? \\n (1) Cadastrar outra conta? \\n (2) Menu inicial?\\n");
	}
	
	static void Creditar() {
		System.out.println("______Bem vindo a aplicação bancária____");
		System.out.println("Você escolheu a opção 2 - Creditar.\n 	");
		System.out.println("Digite o número da conta e o valor 		");
		System.out.println("que deseja creditar  Ou	\n				");
		System.out.println("(0) - VOLTAR PRO MENU INICIAL			");
		System.out.println("________________________________________");

	};
	
	static void Debitar() {
		System.out.println("______Bem vindo a aplicação bancária____");
		System.out.println("Você escolheu a opção 3 - Deditar.\n 	");
		System.out.println("Digite o número da conta e o valor 		");
		System.out.println("que deseja deditar  Ou \n				");
		System.out.println("(0) - VOLTAR PRO MENU INICIAL			");
		System.out.println("________________________________________");

	};
	
	static void Saldo() {
		System.out.println("______Bem vindo a aplicação bancária____");
		System.out.println("Você escolheu a opção 4 - Saldo.\n	 	");
		System.out.println("Digite o número da conta 				");
		System.out.println("que deseja ver o saldo  Ou		\n		");
		System.out.println("(0) - VOLTAR PRO MENU INICIAL			");
		System.out.println("________________________________________");


	};
	static void Transferencia() {
		System.out.println("______Bem vindo a aplicação bancária____");
		System.out.println("Você escolheu a opção 5 - transferencia\n	");
		System.out.println("Digite o número da conta e o valor 		");
		System.out.println("que deseja transferir  Ou		\n		");
		System.out.println("(0) - VOLTAR PRO MENU INICIAL			");
		System.out.println("________________________________________");


	};
	static void RenderBonus() {
		System.out.println("______Bem vindo a aplicação bancária____");
		System.out.println("Você escolheu a opção 6 - Render Bonus.\n");
		System.out.println("Digite o número da conta e o valor 		");
		System.out.println("que deseja render bonus  Ou		\n		");
		System.out.println("(0) - VOLTAR PRO MENU INICIAL			");
		System.out.println("________________________________________");


	};
	static void RenderJuros() {
		System.out.println("______Bem vindo a aplicação bancária____");
		System.out.println("Você escolheu a opção 7 - Render Juros.\n");
		System.out.println("Digite o número da conta e o valor 		");
		System.out.println("que deseja render juros  Ou				");
		System.out.println("(0) - VOLTAR PRO MENU INICIAL			");
		System.out.println("________________________________________");


	};
	

}
