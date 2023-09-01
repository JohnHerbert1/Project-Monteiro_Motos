package entity.usuario.Exception;

public class EmailNaoPossuiDominioException extends Exception {
	
	public EmailNaoPossuiDominioException() {
		super("Seu Email tem que possuir o @ e n�o tem .com");
	}
	
	public EmailNaoPossuiDominioException(String mensagem) {
		super(mensagem);
	}

}
