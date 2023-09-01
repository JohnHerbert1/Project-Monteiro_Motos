package Telas.tela_de_edicao.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.tela_de_edicao.TelaDeEdicao;
import entity.usuario.Admistrador;
import entity.usuario.Usuario;

public class OuvinteButtonVisible implements ActionListener {
	
	Persistencia persiste = new Persistencia();
	CentralDeInformacoes central = persiste.recuperarCentral();
	
	private	TelaDeEdicao edita;
	
	public OuvinteButtonVisible(TelaDeEdicao tela ) {
	 this.edita = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Usuario> modificador = central.getTodosOsUsuarios();
		for(int i = 0; i < modificador.size();i++ ) {
			if(modificador.get(i).isEstaAtivo()== true) {
				if(modificador.get(i).getClass().equals(Admistrador.class)) {
					edita.getExcluir().setVisible(false);
				}
			}
		}
		
	}


}
