package Telas.tela_de_edicao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Janelas.JanelaPadrao;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import Telas.tela_de_edicao.ouvintes.OuvinteButtonVisible;
import Telas.tela_de_edicao.ouvintes.OuvinteOptions;
import Telas.tela_de_edicao.ouvintes.OuvinteTelaDeEdicao;
import entity.usuario.Admistrador;
import entity.usuario.Usuario;

// VOU USAR ESTA TELA PARA TAL EDCAO DE DADOS DE TODOS OS USUARIOS. VER DEPOIS PERMICAO DO ADMINISTRADO EM QUE PODEMOS REUTILIZAR ALGUMAS COISAS.
public class TelaDeEdicao extends JanelaPadrao  {
	
	OuvinteTelaDeEdicao ouve = new OuvinteTelaDeEdicao(this);
	OuvinteButtonVisible desabilitaADM = new OuvinteButtonVisible(this);
	
	Persistencia persiste = new Persistencia();
	CentralDeInformacoes central = persiste.recuperarCentral();
	
	
	private ArrayList<String> options;
	private JCheckBox jCheckBoxNome;
	private JCheckBox jCheckBoxE_mail;
	private JCheckBox jCheckBoxSenha;
	private JTextField nomeField;
	private JTextField emailField;
	private JPasswordField senhaPassword;
	private JButton salvar;
	private JButton cancelar;
	private JButton excluir;
	private	JLabel	nomeLeibol;
	private	JLabel	emailLeibol;
	private JLabel	senhaLeibol;
	
	public TelaDeEdicao(String titulo) {
		super(titulo);
		tituTela();
		butaoSalvar();
		butaoExcluir();
		butaoCancelar();
		representadoDeTexto();
		texto();
		checkBox();
		imagenTela();
		
		this.options = new ArrayList<>();
		
		repaint();
		setVisible(true);
	}
	
	public void checkBox() {
		jCheckBoxNome = Componentes.adicionarCheckBox(this, "nome", 400, 160, 70, 20);
		jCheckBoxE_mail = Componentes.adicionarCheckBox(this, "E-mail", 400, 225, 70, 20);
		jCheckBoxSenha = Componentes.adicionarCheckBox(this, "Senha", 400, 290, 70, 20);
		
		OuvinteOptions ouveOptions = new OuvinteOptions(this);
		
		jCheckBoxNome.addActionListener(ouveOptions);
		jCheckBoxE_mail.addActionListener(ouveOptions);
		jCheckBoxSenha.addActionListener(ouveOptions);
	}

	
	public void tituTela() {
		ImageIcon icon = new ImageIcon ("figuras/logo.png");
		JLabel titulo = Componentes.adicionarJlabelComImagen(this,"EDIÇÃO DE USUÁRIO",icon,0, 30, 650, 95, 50);
		
	}
	
	public void butaoSalvar() {	
		salvar = Componentes.adicionarJButton(this,"Salvar", 100, 450, 130, 35);
		salvar.addActionListener(salvando());
		
	}
	public ActionListener salvando() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ouve.actionPerformed(e);
				
			}
		};
	}
	
	public void butaoExcluir() {
		excluir = Componentes.adicionarJButton(this,"Excluir Usuário", 490, 450, 135, 35);	
		excluir.addActionListener(excluir());
		
		ArrayList<Usuario> modificador = central.getTodosOsUsuarios();
		
		for(int i = 0; i < modificador.size();i++ ) {
			if(modificador.get(i).isEstaAtivo()== true) {
				if(modificador.get(i).getClass().equals(Admistrador.class)) {
					excluir.setVisible(false);
				}
			}
		}
		
	}

	
	public ActionListener excluir() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouve.actionPerfomedExluir(e);
				
			}
		};
	}
	public ActionListener visibilidade() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desabilitaADM.actionPerformed(e);
				
			}
		};
	}
	
	
	public void butaoCancelar() {
		cancelar = Componentes.adicionarJButton(this,"cancelar", 300, 450, 135, 35);	
		cancelar.addActionListener(cancelando());
	}
	
	public ActionListener cancelando() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ouve.actionPerformedCancelar(e);
				
			}
		};
	}
	
	public void representadoDeTexto() {
		nomeLeibol = Componentes.adicionarJLabel(this,"Nome", 30, 160,95, 30);
		emailLeibol = Componentes.adicionarJLabel(this,"E_mail" ,30, 225, 95, 30);
		senhaLeibol = Componentes.adicionarJLabel(this, "Senha", 30, 290, 95, 30); 
		
		nomeLeibol.setVisible(false);
		emailLeibol.setVisible(false);
		senhaLeibol.setVisible(false);
	}
	
	public void texto() {
		nomeField = Componentes.adicionarJtextfield(this, 130, 160,260 , 30);
		emailField = Componentes.adicionarJtextfield(this, 130, 225, 260, 30);
		senhaPassword = Componentes.addJPswordField(this,130 , 290, 260, 30);
		
		nomeField.setVisible(false);
		emailField.setVisible(false);
		senhaPassword.setVisible(false);
		
	}
	
	public void imagenTela() {
		JLabel imagenTela = Componentes.SortImage(this, 0, 0, 700, 600);
		
	}
	
	
	
	
	public JButton getExcluir() {
		return excluir;
	}

	public JLabel getNomeLeibol() {
		return nomeLeibol;
	}

	public JLabel getEmailLeibol() {
		return emailLeibol;
	}

	public JLabel getSenhaLeibol() {
		return senhaLeibol;
	}

	public JCheckBox getjCheckBoxNome() {
		return jCheckBoxNome;
	}

	public JCheckBox getjCheckBoxE_mail() {
		return jCheckBoxE_mail;
	}

	public JCheckBox getjCheckBoxSenha() {
		return jCheckBoxSenha;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public JPasswordField getSenhaPassword() {
		return senhaPassword;
	}

	public static void main( String[] args) {
		new TelaDeEdicao("");
	}
	
}
