package br.ufpe.cin.banco;

public class OperacaoComValoresNegativoException extends Exception {
	
	public OperacaoComValoresNegativoException(double valor) {
	super("S� aceita valor maiores que Zero.");
		
	}
 
}