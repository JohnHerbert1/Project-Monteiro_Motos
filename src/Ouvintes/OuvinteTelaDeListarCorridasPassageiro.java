package Ouvintes;
//RYAN PASSOU AQUI
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Telas.TelaListarCorridasPassageiro;
import Telas.menu.passageiro.TelaMenuPassageiro;

public class OuvinteTelaDeListarCorridasPassageiro implements ActionListener{

	private TelaListarCorridasPassageiro tela;

	public OuvinteTelaDeListarCorridasPassageiro(TelaListarCorridasPassageiro tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new TelaMenuPassageiro(null);

	}
}
