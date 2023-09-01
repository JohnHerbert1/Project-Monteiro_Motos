package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Janelas.JanelaPadrao;
import Model.AdicionarJLabel;
import Ouvintes.OuvinteTelaDetalhesDeUmaCorrida;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.Corrida;
import entity.SorteioDeTelaImagens;

public class TelaVisualizarDetalhesDeUmaCorrida extends JanelaPadrao {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	OuvinteTelaDetalhesDeUmaCorrida ouvinte = new OuvinteTelaDetalhesDeUmaCorrida(this);

	private JButton buttonVoltar;
	private JComboBox<Long> combo;

	public TelaVisualizarDetalhesDeUmaCorrida(String titulo) {
		super(titulo);
		detalharCorridas();
		adicionarJLabel();
		adicionarJButtonVoltar();
		adicionarTitulo();
		adicionarImagem();

		setVisible(true);
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel tituloTela = Componentes.adicionarJlabelComImagen(this, "VISUALIZAR DETALHES DE UMA CORRIDA", icon, 0,
				30, 750, 95, 30);
	}

	public void adicionarImagem() {
		JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
	}

	private void adicionarJLabel() {
		JLabel escolhaDeID = Componentes.adicionarJLabel(this,
				"Selecione o ID da corrida que desejar, para visualizar detalhes!", 0, 200, 700, 100);
	}

	public JComboBox<Long> getCombo() {
		return combo;
	}

	private void adicionarJButtonVoltar() {
		buttonVoltar = Componentes.adicionarJButton(this, "Voltar", 30, 430, 130, 30);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.addActionListener(voltar());

	}

	public ActionListener voltar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedVoltar(e);
			}
		};
	}

	public void detalharCorridas() {
		List<Corrida> corridas = centralDeInformacoes.getTodosAsCorridas();
		combo = new JComboBox<Long>();
		combo.setBounds(450, 235, 130, 30);
		add(combo);
		for (Corrida corrida : corridas) {
			combo.addItem(corrida.getId());
		}
		combo.addActionListener(detalhar());
	}

	public ActionListener detalhar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}
}
