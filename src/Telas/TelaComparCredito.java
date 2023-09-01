package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import Janelas.JanelaPadrao;
import Model.AdicionarJLabel;
import Ouvintes.OuvinteTelaComprarCreditos;
import Ouvintes.OuvinteTelaComrarCreditosSpinner;
import Repositorio.Componentes;
import entity.SorteioDeTelaImagens;

public class TelaComparCredito extends JanelaPadrao {

	OuvinteTelaComprarCreditos ouvinte = new OuvinteTelaComprarCreditos(this);

	private JTextField preco;
	private JSpinner spinner;
	private JButton buttonBoleto;
	private JButton buttonVoltar;

	public TelaComparCredito(String titulo) {
		super(titulo);
		criarButtoes();
		adicionarTitulo();
		comprarCredito();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel tituloTela = Componentes.adicionarJlabelComImagen(this, "COMPRAR CR�DITOS", icon, 0, 30, 750, 95, 50);
	}

	public void adicionarImagem() {
		JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
	}

	private void criarButtoes() {

		buttonBoleto = Componentes.adicionarJButton(this, "Gerar Boleto", 450, 400, 160, 35);
		buttonBoleto.addActionListener(gerarBoleto());

		buttonVoltar = Componentes.adicionarJButton(this, "Voltar", 50, 400, 160, 35);
		buttonVoltar.addActionListener(voltar());

	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerfomedVoltar(e);
			}
		};
	}

	public ActionListener gerarBoleto() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void comprarCredito() {

		JLabel quantidade = Componentes.adicionarJLabel(this, "quantidade de creditos", 150, 150, 350, 23);

		spinner = new JSpinner();
		spinner.setBounds(510, 150, 50, 25);
		spinner.setFont(new Font("Arial", 1, 20));
		spinner.addChangeListener(new OuvinteTelaComrarCreditosSpinner(this));

		JLabel precoTotal = Componentes.adicionarJLabel(this, "valor total", 180, 200, 300, 30);

		preco = Componentes.adicionarJtextfield(this, 230, 250, 200, 30);
		preco.setBackground(Color.BLACK);
		preco.setForeground(Color.YELLOW);
		preco.setEnabled(false);
		preco.setText("R$ : 0,00");

		add(quantidade);
		add(spinner);
		add(precoTotal);
		add(preco);
	}

	public JTextField getPreco() {
		return preco;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JButton getButtonBoleto() {
		return buttonBoleto;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}
	
	public static void main(String[] args) {
		new TelaComparCredito("ss");
	}

}
