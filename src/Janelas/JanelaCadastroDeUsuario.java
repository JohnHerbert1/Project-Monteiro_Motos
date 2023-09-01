package Janelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Janelas.ouvintes.OuvinteTelaDeCadastroDeUsuario;
import Model.AdicionarJLabel;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.SorteioDeTelaImagens;

public class JanelaCadastroDeUsuario extends JanelaPadrao {
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();
	private JTextField nome;
	private JTextField emailResposta;
	private JPasswordField senhaResposta;
	private JPasswordField cSenhaResposta;
	private JButton buttonSalvar;
	private JMenuBar menu;
	private JComboBox<String> combo;
	private JButton buttonVoltar;
	
	
	OuvinteTelaDeCadastroDeUsuario ouvinte = new OuvinteTelaDeCadastroDeUsuario(this);

	public JanelaCadastroDeUsuario(String titulo) {
		super(titulo);
		tituloDaTela(titulo);
		opcoes();
		adicionarJButtonVoltar();
		buttonSalvar();
		adicionarJLabel();
		adicionarJTextFiled();
		adicionarImagem();
		setVisible(true);
		repaint();

	}
	
	
	
	public void opcoes() {// ESTOU ADICIONANDO E REMOVENDO DO COMBOBOX AQUI.....
		String [] tiposDeCadastro = {"Administrador"};
		ArrayList<String> cadastro = new ArrayList<>(Arrays.asList(tiposDeCadastro));
		
		if(central.getTodosOsUsuarios().size() > 0) {
			cadastro.remove(0);
			cadastro.add("MotoTax");
			cadastro.add("Passageiro");
		}
		combo = Componentes.adicionarComboBox(this,cadastro, 140, 400, 130, 30);
		}

	public void tituloDaTela(String nome) {
		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel jLabel = new JLabel("CADASTRO DE USUÁRIO", icon, JLabel.LEFT);
		jLabel.setBounds(0, 30, 750, 95);
		jLabel.setFont(new Font("Impact", Font.ITALIC, 50));
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.BLACK);
		jLabel.setForeground(Color.YELLOW);
		add(jLabel);
	}
	private void buttonSalvar() {
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(200, 450, 130, 35);
		buttonSalvar.setBackground(Color.BLACK);
		buttonSalvar.setForeground(Color.YELLOW);
		buttonSalvar.addActionListener(salvar());
		add(buttonSalvar);
	}
	public ActionListener salvar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}
	public ActionListener op() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedCombo();
			}
		};
	}
	private void adicionarJLabel() {

		AdicionarJLabel nome = new AdicionarJLabel();
		add(nome.adicionarJLabel("Nome:", 30, 160, 95, 30));

		AdicionarJLabel email = new AdicionarJLabel();
		add(email.adicionarJLabel("Email:", 30, 225, 95, 30));

		AdicionarJLabel senha01 = new AdicionarJLabel();
		add(senha01.adicionarJLabel("Senha:", 30, 290, 95, 30));

		AdicionarJLabel senha02 = new AdicionarJLabel();
		add(senha02.adicionarJLabel("Confirmar Senha:", 30, 350, 100, 30));
		
		AdicionarJLabel op = new AdicionarJLabel();
		add(op.adicionarJLabel("Tipo de Usuário", 30, 400, 100, 30));
	}

	private void adicionarJTextFiled() {
		nome = new JTextField();
		nome.setBounds(130, 160, 260, 30);
		add(nome);

		emailResposta = new JTextField();
		emailResposta.setBounds(130, 225, 260, 30);
		add(emailResposta);

		senhaResposta = new JPasswordField();
		senhaResposta.setBounds(130, 290, 260, 30);
		add(senhaResposta);

		cSenhaResposta = new JPasswordField();
		cSenhaResposta.setBounds(135, 350, 260, 30);
		add(cSenhaResposta);
	}
	public JTextField getNome() {
		return nome;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public JTextField getEmailResposta() {
		return emailResposta;
	}

	public JPasswordField getSenhaResposta() {
		return senhaResposta;
	}

	public JPasswordField getcSenhaResposta() {
		return cSenhaResposta;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();
		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
		imagem.setBounds(0, 0, 700, 600);
		add(imagem);
	}
	
	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedVoltar(e);
			}
		};
	}
	private void adicionarJButtonVoltar() {
		buttonVoltar = Componentes.adicionarJButton(this, "Voltar", 50, 450, 130, 35);
		buttonVoltar.addActionListener(voltar());
	}

}
