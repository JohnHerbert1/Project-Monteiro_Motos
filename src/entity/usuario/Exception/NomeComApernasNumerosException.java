package entity.usuario.Exception;

public class NomeComApernasNumerosException extends Exception {
	
	public NomeComApernasNumerosException() {
		super("N�o � permitido nome de usuario com apenas numero.");
	}
	
	public NomeComApernasNumerosException(String mensagem) {
		super(mensagem);
	}

}
