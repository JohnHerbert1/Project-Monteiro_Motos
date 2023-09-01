package entity.usuario.Exception;

public class SenhaSemLetraMaisculaException extends Exception{

	public SenhaSemLetraMaisculaException() {
		super("As senhas tem que ter uma ou mais caracter com letras maiusculas");
	}
	
	public SenhaSemLetraMaisculaException(String mensagem) {
		super(mensagem);
	}
}
