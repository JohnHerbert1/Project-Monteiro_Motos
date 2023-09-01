package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Telas.TelaListarCorridasADM;
import Telas.menu.adm.TelaDeMenuADM;

public class OuvinteTelaListarCorridasADM implements ActionListener {

	private TelaListarCorridasADM tela;

	public OuvinteTelaListarCorridasADM(TelaListarCorridasADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new TelaDeMenuADM(null);

	}

}
