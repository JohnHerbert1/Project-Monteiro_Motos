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
import Ouvintes.OuvinteTelaDestalhesDeUmUsuario;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.SorteioDeTelaImagens;
import entity.usuario.Usuario;

public class TelaVisualizarDetalhesDeUmUsuario extends JanelaPadrao {
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	OuvinteTelaDestalhesDeUmUsuario ouvinte = new OuvinteTelaDestalhesDeUmUsuario(this);
	private JButton buttonVoltar;
	private  JComboBox<String> combo;

	public TelaVisualizarDetalhesDeUmUsuario(String titulo) {
		super(titulo);
		adicionarJButtonVoltar();
		detalharUsuarios();
		adicionarJLabel();
		adicionarTitulo();
		adicionarImagem();
		setVisible(true);

	}
	
	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel tituloTela = Componentes.adicionarJlabelComImagen(this, "VISUALIZAR DETALHES DE UM USUÁRIO", icon, 0, 30, 750, 95, 30);
	}

	public void adicionarImagem() {
		JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
	}
	
	private void adicionarJLabel() {

		AdicionarJLabel escolha = new AdicionarJLabel();
		add(escolha.adicionarJLabel("Selecione o NOme do usuario que desejar, para visualizar detalhes!", 0, 200, 700, 100));
	}
	public void detalharUsuarios() {
		List<Usuario> usuarios = centralDeInformacoes.getTodosOsUsuarios();
        combo = new JComboBox<String>();
        combo.setBounds(450,235,130,30);
        add(combo);
        for(Usuario usuario: usuarios) {
        	combo.addItem(usuario.getNome());
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
	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedVoltar(e);
			}
		};
	}
	private void adicionarJButtonVoltar() {
		buttonVoltar = Componentes.adicionarJButton(this, "Voltar", 30, 430, 130, 30);
		buttonVoltar.addActionListener(voltar());
	}

	public JComboBox<String> getCombo() {
		return combo;
	}
	
	
	

}
