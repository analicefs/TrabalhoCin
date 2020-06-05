/*package br.ufpe.cin.dados;

import java.util.ArrayList;
import java.util.Iterator;

import br.ufpe.cin.banco.ContaAbstrata;
import br.ufpe.cin.banco.ContaJaCadastradaException;

public class RepositorioArrayList  implements RepositorioContas {

		private ArrayList<ContaAbstrata> array;
		
		public RepositorioArrayList() {
			this.array= new ArrayList<>();
			
		}

		public void inserir(ContaAbstrata conta) {
				array.add(conta);
		}

		public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException {
			ContaAbstrata resposta = null;
			for (Iterator<ContaAbstrata> iterator = array.iterator(); iterator.hasNext();) {
				ContaAbstrata contaAbstrata =  iterator.next();
				if(contaAbstrata.getNumero().equals(numero)) {
					resposta= contaAbstrata;
					break;					
				}	
			} if(resposta!=null) {
				return resposta;
			} else {
				throw new ContaNaoEncontradaException();
			
			}
}
		
		@Override
		public void remover(String numero) throws ContaNaoEncontradaException {
			array.remove(numero);
	
			} 
		@Override
		public void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException {
			ContaAbstrata encontrar=procurar(conta.getNumero());
			
		int i=0;
			for (Iterator<ContaAbstrata> iterator = array.iterator(); iterator.hasNext();) {
				ContaAbstrata contaAbstrata =  iterator.next();	
				if(contaAbstrata.getNumero().equals(encontrar.getNumero())) {
					break;
				}else {
					i++;
				}
				}
			array.set(i,conta);
		}
		@Override
		public boolean existe(String numero)  {
			boolean existir = array.contains(numero);
			return existir;
		
}
	
	/*}*/

