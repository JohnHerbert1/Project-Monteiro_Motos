package Telas.menu.mototax.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaComparCredito;
import Telas.TelaDeLogin;
import Telas.TelaListarCorridas;
import Telas.menu.mototax.TelaMenuMototaxista;

public class OuvinteMenuMototaxista implements ActionListener {
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInforamcoes = persistencia.recuperarCentral();

	private TelaMenuMototaxista tela;

	public OuvinteMenuMototaxista(TelaMenuMototaxista tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		tela.dispose();

		switch (comando) {
		case "Comprar credito de reivindicação":
			new TelaComparCredito(null);
			break;
		case "Listar e Reinvindicar corridas":
			new TelaListarCorridas(null);
			break;
		case "Desconectar":
			centralDeInforamcoes.estaDesativado();
			persistencia.salvarCentral(centralDeInforamcoes);
			new TelaDeLogin(null);
			break;
		}
	}

}
