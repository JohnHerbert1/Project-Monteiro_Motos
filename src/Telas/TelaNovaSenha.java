package Telas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Janelas.JanelaPadrao;
import Ouvintes.OuvinteTelaNovaSenha;
import Repositorio.Componentes;

public class TelaNovaSenha extends JanelaPadrao {
	
	private JTextField novaSenha;
	private JTextField confirmarSenha;
	private JButton concluir;
	
	OuvinteTelaNovaSenha ouvinte = new OuvinteTelaNovaSenha(this);

	public TelaNovaSenha(String titulo) {
		super(titulo);
		adicionarButtonConcluir();
		addJlabel();
		addTXT();
		titulo();
		imagemDeFundo();
		
		setVisible(true);
	}
	
	public void titulo() {
		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel titulo = Componentes.adicionarJlabelComImagen(this, "NOVA SENHA", icon, 0, 30, 750, 95, 50);
	}
	
	public void imagemDeFundo() {
		JLabel tela = Componentes.SortImage(this, 0, 0, 700, 600);
	}
	
	public void addJlabel() {
		JLabel senha = Componentes.adicionarJLabel(this, "Nova senha:", 150, 200, 150, 30);
		JLabel confirmarSenha = Componentes.adicionarJLabel(this, "Confirmar Senha", 150, 300, 150, 30);
	}
	
	public void addTXT() {
		
		 novaSenha = Componentes.adicionarJtextfield(this, 310, 200, 200, 30);
		 confirmarSenha = Componentes.adicionarJtextfield(this, 310, 300, 200, 30);
		
	}
	private void adicionarButtonConcluir() {
		
		concluir = Componentes.adicionarJButton(this, "Concluir", 250, 400, 160, 35);
		concluir.addActionListener((concluir()));

	}
	public ActionListener concluir() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}
	

	public JTextField getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(JTextField novaSenha) {
		this.novaSenha = novaSenha;
	}

	public JTextField getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(JTextField confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	


	

}
