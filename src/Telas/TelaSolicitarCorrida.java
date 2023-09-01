package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Janelas.JanelaPadrao;
import Model.AdicionarJLabel;
import Ouvintes.OuvinteTelaSolicitarCorridas;
import Repositorio.Componentes;
import entity.SorteioDeTelaImagens;

public class TelaSolicitarCorrida extends JanelaPadrao {
	
	OuvinteTelaSolicitarCorridas ouvinte = new OuvinteTelaSolicitarCorridas(this);
	
	private JTextField pontoDePartida;
	private JTextField destino;
	private JButton voltar;
	private JCheckBox horaDaCorrida;
	private JCheckBox horaDaCorridaDepois;
		
	
	private JButton concluir;
	private JTextField campoIDdaCorrida;

	public TelaSolicitarCorrida(String titulo) {
		super(titulo);
		addChbox();
		adicionarButtonConcluir();
		adicionarButtonVoltar();
		adicionarJlabel();
		adicionarJtextField();
		adicionarTitulo();
		adicionarImagem();

		setVisible(true);
	}
	
	
	private void adicionarJlabel() {
		
		JLabel partida = Componentes.adicionarJLabel(this, "Ponto de Partida:", 150, 150, 150, 30);
		JLabel destino = Componentes.adicionarJLabel(this, "Destino:", 150, 240, 150, 30);
		JLabel prioridade = Componentes.adicionarJLabel(this, "Selecione a Prioridade da Corrida", 150, 320, 150, 30);

	}
	
	public void addChbox() {
		horaDaCorrida = Componentes.adicionarCheckBox(this, "AGORA", 320, 320, 70, 30);
		horaDaCorridaDepois = Componentes.adicionarCheckBox(this,"DEPOIS", 410, 320, 70, 30);
	}
	
	private void adicionarJtextField() {
		pontoDePartida = Componentes.adicionarJtextfield(this, 320, 150, 250, 30);
		destino = Componentes.adicionarJtextfield(this, 320, 240, 260, 30);
	}
	private void adicionarButtonVoltar() {
		
		voltar = Componentes.adicionarJButton(this, "Voltar", 170, 400, 160, 35);
		voltar.addActionListener(voltar());

	}
	private void adicionarButtonConcluir() {
		concluir = Componentes.adicionarJButton(this, "Concluir", 400, 400, 160, 35);
		concluir.addActionListener((concluir()));
	}
	
	public ActionListener concluir() {
		return new ActionListener() {
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
	
	
	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel tituloTela = Componentes.adicionarJlabelComImagen(this, "SOLICITAR CORRIDA", icon, 0, 30, 750, 95, 50);
	}

	public void adicionarImagem() {
		JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
	}



	public JTextField getCampoIDdaCorrida() {
		return campoIDdaCorrida;
	}

	public JTextField getPontoDePartida() {
		return pontoDePartida;
	}

	public JTextField getDestino() {
		return destino;
	}

	public JButton getVoltar() {
		return voltar;
	}

	public JButton getConcluir() {
		return concluir;
	}


	public JCheckBox getHoraDaCorrida() {
		return horaDaCorrida;
	}


	public void setHoraDaCorrida(JCheckBox horaDaCorrida) {
		this.horaDaCorrida = horaDaCorrida;
	}


	public JCheckBox getHoraDaCorridaDepois() {
		return horaDaCorridaDepois;
	}


	public void setHoraDaCorridaDepois(JCheckBox horaDaCorridaDepois) {
		this.horaDaCorridaDepois = horaDaCorridaDepois;
	}
	
	
	
	

}
