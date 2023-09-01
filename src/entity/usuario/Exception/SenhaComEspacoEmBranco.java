package entity.usuario.Exception;

public class SenhaComEspacoEmBranco extends Exception {
	
	public SenhaComEspacoEmBranco() {
		super("As senhas não podem conter espaço em branco");
	}
	public SenhaComEspacoEmBranco(String mensagem) {
		super(mensagem);
	}
	
	

}
