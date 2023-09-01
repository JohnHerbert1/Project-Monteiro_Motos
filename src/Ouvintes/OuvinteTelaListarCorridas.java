package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Enum.StatusDaCorrida;
import Model.Mensageiro;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaListarCorridas;
import Telas.TelaReinvidicarCorridaEDetalhesDaCorrida;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.mototax.TelaMenuMototaxista;
import entity.Corrida;

public class OuvinteTelaListarCorridas implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private TelaListarCorridas telaListarCorridas;

	public TelaListarCorridas getTelaListarCorridas() {
		return telaListarCorridas;
	}

	public OuvinteTelaListarCorridas(TelaListarCorridas tela) {
		this.telaListarCorridas = tela;
	}
	
	public void actionPerformedVoltar(ActionEvent e) {
		telaListarCorridas.dispose();
		new TelaMenuMototaxista(null);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		try {
			List<Corrida> corridas = central.getTodosAsCorridas();
			for (int i = 0; i < corridas.size(); i++) {
				if (corridas.get(i).getStatus().equals(StatusDaCorrida.PENDENTE)) {
					corridas.get(i).setStatus(StatusDaCorrida.ANDAMENTO);
					break;
				}
			}
			
			central.decresimoDeCreditos();
			persistencia.salvarCentral(central);
			telaListarCorridas.dispose();
			new TelaReinvidicarCorridaEDetalhesDaCorrida(null);
			
		} catch (Exception erro) {
		}

	}

}
