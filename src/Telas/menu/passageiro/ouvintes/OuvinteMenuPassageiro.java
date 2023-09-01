package Telas.menu.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.itextpdf.text.List;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaDeLogin;
import Telas.TelaListarCorridas;
import Telas.TelaListarCorridasPassageiro;
import Telas.TelaSolicitarCorrida;
import Telas.TelaVisualizarDetalhesDeUmaCorrida;
import Telas.menu.passageiro.TelaMenuPassageiro;

public class OuvinteMenuPassageiro implements ActionListener {
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInforamcoes = persistencia.recuperarCentral();
	
	
	private TelaMenuPassageiro tela;

	public OuvinteMenuPassageiro(TelaMenuPassageiro tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		tela.dispose();

		switch (comando) {
		case "Solicitar Corrida":
			new TelaSolicitarCorrida(null);
			break;
		case"Visualizar detalhes de uma corrida":
			new TelaVisualizarDetalhesDeUmaCorrida(null);
			break;
		case"Listar Corridas":
			//tem q criar uma nova tela pra listar as corridas do passageiro em especifico
			new TelaListarCorridasPassageiro(null);
			break;
		case"Desconectar":
			centralDeInforamcoes.estaDesativado();
			persistencia.salvarCentral(centralDeInforamcoes);
			tela.dispose();
			new TelaDeLogin(null);
			break;
			
		}
		

	}

}
