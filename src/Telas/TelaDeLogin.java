package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Janelas.JanelaPadrao;
import Ouvintes.OuvinteTelaDeLogin;
import Repositorio.Componentes;

public class TelaDeLogin extends JanelaPadrao{
	
	OuvinteTelaDeLogin ouvinte = new OuvinteTelaDeLogin(this);
	
	private JTextField campoEmail;
	private JPasswordField campoSenha;
	private JButton buttonProseguir;
	private JButton buttonEsqueciSenha;
	private ImageIcon iconButton;
	private JButton ButtonNovoCadastro;
	
	
	
	public TelaDeLogin(String titulo) {
		super(titulo);	
		
		adicionarTitulo();
		adicionarJLabel();
		adicionarJTextFiled();
		adicionarButtonProseguir();
		adicionarButtonEsqueciSenha();
		adicionarButtonNovoCadastro();
		adicionarImagem();
		setVisible(true);
	}
	private void adicionarTitulo() {
		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel tituloTela = Componentes.adicionarJlabelComImagen(this, "TELA DE LOGIN", icon, 0, 30, 750, 95, 50);
	}


	private void adicionarJLabel() {
		
		JLabel email = Componentes.adicionarJLabel(this, "Email:", 200, 200, 95, 30);
		JLabel senha01 = Componentes.adicionarJLabel(this, "Senha:", 200, 270, 95, 30);
	
	}

	private void adicionarJTextFiled() {
		
		campoEmail = Componentes.adicionarJtextfield(this, 330, 200, 200, 30);
		campoSenha = Componentes.addJPswordField(this, 330, 270, 200, 30);
	}
	
	private void adicionarButtonNovoCadastro() {
		ButtonNovoCadastro = Componentes.adicionarJButton(this, "Novo Cadastro", 280, 400, 160, 35);
		ButtonNovoCadastro.addActionListener(novoCadastro());
	}
	public ActionListener novoCadastro() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedNovoCadastro(e);
		}
		};
	}

	private void adicionarButtonProseguir() {
		
		buttonProseguir = Componentes.adicionarJButton(this, "Prosseguir", 500, 400, 160, 35);
		buttonProseguir.addActionListener(proseguir());
	}

	public ActionListener proseguir() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
		}
		};
	}

	public void adicionarButtonEsqueciSenha() {
		
		buttonEsqueciSenha = Componentes.adicionarJButton(this, "Esqueci Senha", 30, 400, 200, 35);
		buttonEsqueciSenha.addActionListener(senha());
	}

	public ActionListener senha() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedSenha(e);
			}
		};
	}

	public void adicionarImagem() {
		JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public JButton getButtonProseguir() {
		return buttonProseguir;
	}

	public JButton getButtonEsqueciSenha() {
		return buttonEsqueciSenha;
	}



}


