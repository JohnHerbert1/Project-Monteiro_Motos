package personalizedMessage;

import javax.swing.JOptionPane;

public class MensagemUsuario {

	public static void usuarioSalvo() {
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}

	public static void usuarioSenhaErrada() {
		JOptionPane.showMessageDialog(null, "As senhas não são iguais!");
	}

	public static void usuarioCampoVazio() {
		JOptionPane.showMessageDialog(null, "Campo/s vazio/s!");
	}

	public static void usuarioExcluir() {
		JOptionPane.showMessageDialog(null, "Usuário exluido com sucesso!");
	}

	public static void usuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
	}

	public static void usuarioErro() {
		JOptionPane.showMessageDialog(null, "Houve algum erro na criação de sua conta. tente novamente!");
	}
	public static void lugaresIguais() {
		JOptionPane.showMessageDialog(null, "O Destino não pode ser igual ao ponto de partida. tente novamente!");
	}
}
