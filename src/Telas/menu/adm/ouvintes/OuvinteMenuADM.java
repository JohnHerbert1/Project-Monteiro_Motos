package Telas.menu.adm.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaDeLogin;
import Telas.TelaListarCorridasADM;
import Telas.TelaListarUsuarios;
import Telas.TelaRelatorio;
import Telas.TelaVisualizarDetalhesDeUmUsuario;
import Telas.TelaVisualizarDetalhesDeUmaCorrida;
import Telas.menu.adm.TelaDeMenuADM;

public class OuvinteMenuADM  implements ActionListener{
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInforamcoes = persistencia.recuperarCentral();
	
	private TelaDeMenuADM tela;
	
	public OuvinteMenuADM(TelaDeMenuADM tela) {
		this.tela=tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		tela.dispose();
		switch(comando) {
		case "Visualizar detalhes de uma corrida":
			new TelaVisualizarDetalhesDeUmaCorrida(null);
			break;
		case "Visualizar detalhes do perfil de um usuario":
			new TelaVisualizarDetalhesDeUmUsuario(null);
			break;
		case "Listar todos os usuario":
			new TelaListarUsuarios(null);
			break;
		case "Relatorio de financas":
			new TelaRelatorio(null);
			break;
		case "Listar Corridas":
			new TelaListarCorridasADM(null);
			break;
		case"Desconectar":
			centralDeInforamcoes.estaDesativado();
			persistencia.salvarCentral(centralDeInforamcoes);
			new TelaDeLogin(null);
			break;
		}
	}

}
