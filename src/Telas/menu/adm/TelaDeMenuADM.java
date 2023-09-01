package Telas.menu.adm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Janelas.JanelaPadrao;
import Telas.menu.adm.ouvintes.OuvinteMenuADM;
import Telas.tela_de_edicao.ouvintes.OuvinteTelaDeEdicao;
import entity.SorteioDeTelaImagens;

public class TelaDeMenuADM extends JanelaPadrao {

	OuvinteTelaDeEdicao telaDeEdicao = new OuvinteTelaDeEdicao(this);
	private JMenuBar menuBar;
	private JMenu menuop;
	private JButton buttonDeletarUsuario;
	private JButton buttonEditarUsuario;
	
	
	OuvinteMenuADM ouvinte = new OuvinteMenuADM(this);

	public TelaDeMenuADM(String titulo) {
		super(titulo);
		AdicionarTextoDeAtalhos();
		buttonEditar();
		tituloDaTela(titulo);
		menu();
		adicionarImagem();
		setVisible(true);

	}

	public void tituloDaTela(String nome) {
		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel jLabel = new JLabel("BEM-VINDO", icon, JLabel.CENTER);
		jLabel.setBounds(0, 30, 750, 95);
		jLabel.setFont(new Font("Impact", Font.ITALIC, 50));
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.BLACK);
		jLabel.setForeground(Color.YELLOW);
		add(jLabel);
	}

	public void menu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuop = new JMenu("Opcoes");
		menuop.setBounds(100,50,50,50 );
        menuop.setOpaque(true);
		menuop.setBackground(Color.BLACK);
		menuop.setForeground(Color.YELLOW);
		menuop.setMnemonic('o');//aperte alt + o		
		menuBar.add(menuop);

		//add no passageiro tb
		JMenuItem visualizarUmaCorrida = new JMenuItem("Visualizar detalhes de uma corrida");
		menuop.add(visualizarUmaCorrida);
		visualizarUmaCorrida.setBackground(Color.BLACK);
		visualizarUmaCorrida.setForeground(Color.YELLOW);
		visualizarUmaCorrida.addActionListener(ouvinte);
		
		JMenuItem visualizarUmUsuario = new JMenuItem("Visualizar detalhes do perfil de um usuario");
		menuop.add(visualizarUmUsuario);
		visualizarUmUsuario.setBackground(Color.BLACK);
		visualizarUmUsuario.setForeground(Color.YELLOW);
		visualizarUmUsuario.addActionListener(ouvinte);
		
		JMenuItem listarUsuarios = new JMenuItem("Listar todos os usuario");
		menuop.add(listarUsuarios);
		listarUsuarios.setBackground(Color.BLACK);
		listarUsuarios.setForeground(Color.YELLOW);
		listarUsuarios.addActionListener(ouvinte);
		
		JMenuItem relatorio = new JMenuItem("Relatorio de financas");
		menuop.add(relatorio);
		relatorio.setBackground(Color.BLACK);
		relatorio.setForeground(Color.YELLOW);
		relatorio.addActionListener(ouvinte);
		//add nos 3 menus
		JMenuItem listarCorrida = new JMenuItem("Listar Corridas");
		menuop.add(listarCorrida);
		listarCorrida.setBackground(Color.BLACK);
		listarCorrida.setForeground(Color.YELLOW);
		listarCorrida.addActionListener(ouvinte);
		
		JMenuItem desconectar = new JMenuItem("Desconectar");
		desconectar.setMnemonic('f');//ATALHOS:	1° aperte alt + o para acessar as opcoes, e alt + f
		menuop.add(desconectar);
		//desconectar.addActionListener(ouvinteMenuADM);
		desconectar.setBackground(Color.BLACK);
		desconectar.setForeground(Color.RED);
		desconectar.addActionListener(ouvinte);
	}

	public void AdicionarTextoDeAtalhos() {
		JLabel jLabel = new JLabel("<html>Ola, ADM" + "<br>Atalhos: "
				+ "<br>alt + 'o' acessa o menu de opcoes cima" + "<br>alt + 'f' Desconecta do perfil ");
		jLabel.setBounds(50, 230, 270, 100);
		jLabel.setFont(new Font("Impact", Font.ITALIC, 16));
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.BLACK);
		jLabel.setForeground(Color.YELLOW);
		add(jLabel);
	}

	public void buttonEditar() {
		buttonEditarUsuario = new JButton("Editar Usuario");
		buttonEditarUsuario.setBounds(400, 300, 200, 30);
		buttonEditarUsuario.setBackground(Color.BLACK);
		buttonEditarUsuario.setForeground(Color.YELLOW);
		// buttonEditarUsuario.addActionListener(salvar());
		add(buttonEditarUsuario);
		buttonEditarUsuario.addActionListener(editar());

	}

	public ActionListener editar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaDeEdicao.actionButtonTelaDeEdicao(e);

			}
		};
	}
//	public void buttonApagar() {
//		buttonDeletarUsuario = new JButton("Apagar Usuario");
//		buttonDeletarUsuario.setBounds(400, 300, 200, 30);
//		buttonDeletarUsuario.setBackground(Color.BLACK);
//		buttonDeletarUsuario.setForeground(Color.YELLOW);
//		//buttonEditarUsuario.addActionListener(salvar());
//		add(buttonDeletarUsuario);
//	}

	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();

		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
		imagem.setBounds(0, 0, 700, 600);
		add(imagem);
	}

}
