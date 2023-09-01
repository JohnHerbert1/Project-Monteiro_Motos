package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaVisualizarDetalhesDeUmaCorrida;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.passageiro.TelaMenuPassageiro;
import entity.Corrida;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;

public class OuvinteTelaDetalhesDeUmaCorrida implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private TelaVisualizarDetalhesDeUmaCorrida telaDetalhes;

	public TelaVisualizarDetalhesDeUmaCorrida getTelaVisualizarDetalhesDeUmaCorrida() {
		return telaDetalhes;
	}

	public OuvinteTelaDetalhesDeUmaCorrida(TelaVisualizarDetalhesDeUmaCorrida tela) {
		this.telaDetalhes = tela;
	}
	
	public void actionPerformedVoltar(ActionEvent e) {
		telaDetalhes.dispose();
		new TelaDeMenuADM(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			Long tipo = (Long) telaDetalhes.getCombo().getSelectedItem(); // VOU VER SE ESTA FUNCIONADO ASSIM, NAO															// DADOS DO COMBOBOX
			Corrida c = central.recuperarCorridaPeloId(tipo);
			if (c != null) {
				MensagemPrograma.detalharCorrida(c);
				telaDetalhes.dispose();
				new TelaDeMenuADM(null);
			} else {
				
			} // end else
		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);
		} // end catch
	} // end actionPerformed
}



