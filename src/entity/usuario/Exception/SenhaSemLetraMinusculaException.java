package entity.usuario.Exception;

public class SenhaSemLetraMinusculaException extends Exception{
	
	public SenhaSemLetraMinusculaException() {
		super("Senha tem que ter letra minuscula");
	}
	
	public SenhaSemLetraMinusculaException(String mensagem) {
		super(mensagem);
	}
}
