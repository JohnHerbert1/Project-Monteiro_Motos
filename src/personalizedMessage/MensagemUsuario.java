package personalizedMessage;

import javax.swing.JOptionPane;

public class MensagemUsuario {

	public static void usuarioSalvo() {
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}

	public static void usuarioSenhaErrada() {
		JOptionPane.showMessageDialog(null, "As senhas n�o s�o iguais!");
	}

	public static void usuarioCampoVazio() {
		JOptionPane.showMessageDialog(null, "Campo/s vazio/s!");
	}

	public static void usuarioExcluir() {
		JOptionPane.showMessageDialog(null, "Usu�rio exluido com sucesso!");
	}

	public static void usuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!");
	}

	public static void usuarioErro() {
		JOptionPane.showMessageDialog(null, "Houve algum erro na cria��o de sua conta. tente novamente!");
	}
	public static void lugaresIguais() {
		JOptionPane.showMessageDialog(null, "O Destino n�o pode ser igual ao ponto de partida. tente novamente!");
	}
}
