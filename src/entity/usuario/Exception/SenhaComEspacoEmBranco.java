package entity.usuario.Exception;

public class SenhaComEspacoEmBranco extends Exception {
	
	public SenhaComEspacoEmBranco() {
		super("As senhas n�o podem conter espa�o em branco");
	}
	public SenhaComEspacoEmBranco(String mensagem) {
		super(mensagem);
	}
	
	

}
