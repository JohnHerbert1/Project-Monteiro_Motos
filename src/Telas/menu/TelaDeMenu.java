package Telas.menu;

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
import entity.SorteioDeTelaImagens;

// QUANDO FOREM MODIFICAR AS OPCOES COMO E UM OBJECT QUE ESTA CADASTRADO EM USUARIOS DA PRA USAR O STANCEOF

public class TelaDeMenu extends JanelaPadrao {

	//OuvinteTelaDeMenu ouvinte = new OuvinteTelaDeMenu(this);

	private JButton buttonDeletarUsuario;
	private JButton buttonEditarUsuario;
	private JMenuBar jMenuBar;
	private ImageIcon iconButtons;

	public TelaDeMenu(String titulo) {
		super(titulo);
		adicionarImagem();
		//excluirUsuario();
		buttonDeletarUsuario();	
		adicionarMenuPassageiro();
		buttonEditar();
			
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
	

	public void buttonEditar() {
		buttonEditarUsuario = new JButton("Editar Usuario");
		buttonEditarUsuario.setBounds(50, 300, 200, 30);
		buttonEditarUsuario.setBackground(Color.BLACK);
		buttonEditarUsuario.setForeground(Color.YELLOW);
		//buttonEditarUsuario.addActionListener(salvar());
		add(buttonEditarUsuario);
	}
	
	public void buttonDeletarUsuario() {
		buttonDeletarUsuario = new JButton("Apagar Usuario");
		buttonDeletarUsuario.setBounds(400, 300, 200, 30);
		buttonDeletarUsuario.setBackground(Color.BLACK);
		buttonDeletarUsuario.setForeground(Color.YELLOW);
		//buttonEditarUsuario.addActionListener(salvar());
		add(buttonDeletarUsuario);
	}

	public ActionListener excluir() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			//	ouvinte.actionPerformedExcluir(e);
			}
		};
	}

	private void adicionarMenuPassageiro() {

		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);

		JMenu menuOp = new JMenu("Op�oes");
		menuOp.setOpaque(true);
		menuOp.setBackground(Color.BLACK);
		menuOp.setForeground(Color.YELLOW);
		jMenuBar.add(menuOp);

		//JMenuItem cadastroDeCanal = new JMenuItem("Cadastrar Mototaxista");
		//cadastroDeCanal.setBackground(new Color(60, 179, 113));
		//cadastroDeCanal.setForeground(Color.WHITE);
	//	menuOp.add(cadastroDeCanal);
	//	cadastroDeCanal.addActionListener(ouvinte);

		//JMenuItem listarCanal = new JMenuItem("Listar Todos os Usu�rios");
	//	menuOp.add(listarCanal);
		//listarCanal.setBackground(new Color(46, 139, 87));
		//listarCanal.setForeground(Color.WHITE);
	//	listarCanal.addActionListener(ouvinte);

		JMenuItem cadastrarPrograma = new JMenuItem("Cadastrar Passageiro");
		menuOp.add(cadastrarPrograma);
		cadastrarPrograma.setBackground(new Color(60, 179, 113));
		cadastrarPrograma.setForeground(Color.WHITE);
	//	cadastrarPrograma.addActionListener(ouvinte);

		JMenuItem listarPrograma = new JMenuItem("Listar Corridas");
		menuOp.add(listarPrograma);
		listarPrograma.setBackground(new Color(46, 139, 87));
		listarPrograma.setForeground(Color.WHITE);
	//	listarPrograma.addActionListener(ouvinte);

		//JMenuItem gerarPDF = new JMenuItem("Gerar PDF");
	//	menuOp.add(gerarPDF);
	//	gerarPDF.setBackground(new Color(60, 179, 113));
	//	gerarPDF.setForeground(Color.WHITE);
	//	gerarPDF.addActionListener(ouvinte);

		JMenuItem agenda = new JMenuItem("Visualizar detalhes de uma corrida");
		menuOp.add(agenda);
		agenda.setBackground(new Color(60, 179, 113));
		agenda.setForeground(Color.WHITE);
	//	agenda.addActionListener(ouvinte);

		//JMenuItem email = new JMenuItem("Enviar Minha Agenda Por Email");
	//	menuOp.add(email);
	//	email.setBackground(new Color(46, 139, 87));
	//	email.setForeground(Color.WHITE);
		//email.addActionListener(ouvinte);
		
		JMenuItem sair = new JMenuItem("Sair");
		menuOp.add(sair);
		sair.setBackground(new Color(46, 139, 87));
		sair.setForeground(Color.WHITE);
		//sair.addActionListener(ouvinte);

	}
	
	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();

		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
		imagem.setBounds(0, 30, 700, 500);
		add(imagem);
	}

}
