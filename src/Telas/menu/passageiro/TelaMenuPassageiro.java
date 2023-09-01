package Telas.menu.passageiro;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import OuvintesTelasDeMenu.OuvinteDeletarDados;
import Repositorio.Componentes;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.passageiro.ouvintes.OuvinteMenuPassageiro;
import entity.SorteioDeTelaImagens;

public class TelaMenuPassageiro extends TelaDeMenuADM {

	private JMenuBar menuBar;
	private JMenu menuop;

	OuvinteMenuPassageiro ouvinte = new OuvinteMenuPassageiro(this);
	OuvinteDeletarDados ouveDeletar = new OuvinteDeletarDados(this);

	public TelaMenuPassageiro(String titulo) {
		super(titulo);
		menu();
		AdicionarTextoDeAtalhos();
		adicionarImagem();
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
		buttonEditar();

		JMenuItem solicitarCorrida = new JMenuItem("Solicitar Corrida");
		menuop.add(solicitarCorrida);
		solicitarCorrida.setBackground(Color.BLACK);
		solicitarCorrida.setForeground(Color.YELLOW);
		solicitarCorrida.addActionListener(ouvinte);


		JMenuItem listarCorrida = new JMenuItem("Listar Corridas");
		menuop.add(listarCorrida);
		listarCorrida.setBackground(Color.BLACK);
		listarCorrida.setForeground(Color.YELLOW);
		listarCorrida.addActionListener(ouvinte);

		JMenuItem deletarUsuario = Componentes.adicionaMenuIten(this, "Deletar Conta");
		menuop.add(deletarUsuario);
		deletarUsuario.addActionListener(ouveDeletar);

		JMenuItem desconectar = new JMenuItem("Desconectar");
		desconectar.setMnemonic('f');// ATALHOS: 1° aperte alt + o para acessar as opcoes, e alt + f
		menuop.add(desconectar);
		// desconectar.addActionListener(ouvinteMenuADM);
		desconectar.setBackground(Color.BLACK);
		desconectar.setForeground(Color.RED);
		desconectar.addActionListener(ouvinte);

	}

	public void AdicionarTextoDeAtalhos() {
		JLabel jLabel = new JLabel("<html>Ola, PASSAGEIRO" + "<br>Atalhos: "
				+ "<br>alt + 'o' acessa o menu de opcoes cima" + "<br>alt + 'f' Desconecta do perfil ");
		jLabel.setBounds(50, 230, 270, 100);
		jLabel.setFont(new Font("Impact", Font.ITALIC, 16));
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.BLACK);
		jLabel.setForeground(Color.YELLOW);
		add(jLabel);
	}

	public void adicionarImagem() {

		Componentes.SortImagePassageiro(this, 0, 0, 700, 600);

	}
	public static void main(String[] args) {
		new TelaMenuPassageiro(null); 
	}
}
