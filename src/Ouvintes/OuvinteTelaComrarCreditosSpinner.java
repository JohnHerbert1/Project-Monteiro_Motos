package Ouvintes;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaComparCredito;

public class OuvinteTelaComrarCreditosSpinner implements ChangeListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaComparCredito tela;

	public OuvinteTelaComrarCreditosSpinner(TelaComparCredito tela) {
		this.tela = tela;
	}

	public void stateChanged(ChangeEvent e) {
		int valor = (Integer) tela.getSpinner().getValue();

		if (valor < 0) {
			tela.getSpinner().setValue(0);
		} else {
			double valorTotal = valor * 0.50;
			tela.getPreco().setText(String.format("%.2f", valorTotal));
		}
	}
}
