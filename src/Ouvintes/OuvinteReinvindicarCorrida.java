package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import Enum.StatusDaCorrida;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaReinvidicarCorridaEDetalhesDaCorrida;
import Telas.menu.mototax.TelaMenuMototaxista;
import entity.Corrida;

public class OuvinteReinvindicarCorrida implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private TelaReinvidicarCorridaEDetalhesDaCorrida tela;

	public OuvinteReinvindicarCorrida(TelaReinvidicarCorridaEDetalhesDaCorrida tela) {
		this.tela = tela;
	}
	

	public void actionPerformed(ActionEvent e) {
		List<Corrida> corridas = central.getTodosAsCorridas();
		for (int i = 0; i < corridas.size(); i++) {
			if (corridas.get(i).getStatus().equals(StatusDaCorrida.ANDAMENTO)) {
			}
		}
	}
	
	public void actionPerformadConcluir(ActionEvent e) {
		try {
			List<Corrida> corridas = central.getTodosAsCorridas();
			for (int i = 0; i < corridas.size(); i++) {
				if (corridas.get(i).getStatus().equals(StatusDaCorrida.ANDAMENTO))
					corridas.get(i).setStatus(StatusDaCorrida.CONCLUIDO);		
			}
			persistencia.salvarCentral(central);
			tela.dispose();
			new TelaMenuMototaxista(null);
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Concluir corrida antes de voltar");
		}
	}
}
