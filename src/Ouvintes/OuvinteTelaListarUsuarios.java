package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Telas.TelaListarUsuarios;
import Telas.menu.adm.TelaDeMenuADM;

public class OuvinteTelaListarUsuarios implements ActionListener{
	
	private TelaListarUsuarios tela;
	
	public OuvinteTelaListarUsuarios(TelaListarUsuarios tela) {
		this.tela=tela;
	}

	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new TelaDeMenuADM(null);
	}

}
