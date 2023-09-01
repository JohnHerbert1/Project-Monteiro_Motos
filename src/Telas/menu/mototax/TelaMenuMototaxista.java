package Telas.menu.mototax;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import OuvintesTelasDeMenu.OuvinteDeletarDados;
import Repositorio.Componentes;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.mototax.ouvintes.OuvinteMenuMototaxista;

public class TelaMenuMototaxista extends TelaDeMenuADM {
	private JMenuBar menuBar;
	private JMenu menuop;

	OuvinteMenuMototaxista ouvinte = new OuvinteMenuMototaxista(this);
	OuvinteDeletarDados ouveODeletar = new OuvinteDeletarDados(this);
	
	public TelaMenuMototaxista(String titulo) {
		super(titulo);
		menu();
		adicionarImagem();
		AdicionarTextoDeAtalhos();
		setVisible(true);
	}

	public void menu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuop = new JMenu("Opcoes");
		menuop.setBounds(100, 50, 50, 50);
		menuop.setOpaque(true);
		menuop.setBackground(Color.BLACK);
		menuop.setForeground(Color.YELLOW);
		menuop.setMnemonic('o');// aperte alt + o
		menuBar.add(menuop);

		JMenuItem comprarCredito = new JMenuItem("Comprar credito de reivindica��o");
		menuop.add(comprarCredito);
		comprarCredito.setBackground(Color.BLACK);
		comprarCredito.setForeground(Color.YELLOW);
		comprarCredito.addActionListener(ouvinte);

		JMenuItem listarCorrida = new JMenuItem("Listar e Reinvindicar corridas");
		menuop.add(listarCorrida);
		listarCorrida.setBackground(Color.BLACK);
		listarCorrida.setForeground(Color.YELLOW);
		listarCorrida.setMnemonic('l');// aperte alt + l
		listarCorrida.addActionListener(ouvinte);

		JMenuItem desconectar = new JMenuItem("Desconectar");
		desconectar.setMnemonic('f');// ATALHOS: 1° aperte alt + o para acessar as opcoes, e alt + f
		menuop.add(desconectar);
		// desconectar.addActionListener(ouvinteMenuADM);
		desconectar.setBackground(Color.BLACK);
		desconectar.setForeground(Color.RED);
		desconectar.addActionListener(ouvinte);
		buttonEditar();
		
	}
		public void AdicionarTextoDeAtalhos() {
			
			JLabel jLabel = new JLabel("<html>Ola, MOTOTAXISTA" + "<br>Atalhos: "
					+ "<br>alt + 'o' acessa o menu de opcoes cima" + "<br>alt + 'l' Listar Corridas" + "<br>alt + 'f' Desconecta do perfil ");
			jLabel.setBounds(50, 230, 270, 100);
			jLabel.setFont(new Font("Impact", Font.ITALIC, 16));
			jLabel.setOpaque(true);
			jLabel.setBackground(Color.BLACK);
			jLabel.setForeground(Color.YELLOW);
			add(jLabel);
		}
	

	public void adicionarImagem() {
		Componentes.SortImageMotocas(this, 0, 0, 700, 600);
	}

}
