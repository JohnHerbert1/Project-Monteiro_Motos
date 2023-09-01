package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaVisualizarDetalhesDeUmUsuario;
import Telas.menu.adm.TelaDeMenuADM;
import entity.usuario.Usuario;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;

public class OuvinteTelaDestalhesDeUmUsuario implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private TelaVisualizarDetalhesDeUmUsuario telaDetalhesUsuario;

	public TelaVisualizarDetalhesDeUmUsuario getTelaVisualizarDetalhesDeUmUsuario() {
		return telaDetalhesUsuario;
	}

	public OuvinteTelaDestalhesDeUmUsuario(TelaVisualizarDetalhesDeUmUsuario tela) {
		this.telaDetalhesUsuario = tela;
	}

	public void actionPerformedVoltar(ActionEvent e) {
		telaDetalhesUsuario.dispose();
		new TelaDeMenuADM(null);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			String nome = (String) telaDetalhesUsuario.getCombo().getSelectedItem();
			Usuario usuario = central.recuperarUsuario(nome);

			if (usuario != null) {
				MensagemPrograma.detalharUsuario(usuario);
			}
		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);

		}

	}

}
