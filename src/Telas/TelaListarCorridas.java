package Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Enum.StatusDaCorrida;
import Janelas.JanelaPadrao;
import Ouvintes.OuvinteTelaListarCorridas;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.Corrida;
import entity.SorteioDeTelaImagens;

public class TelaListarCorridas extends JanelaPadrao {
//RYAN PASSOU AQUI
	OuvinteTelaListarCorridas ouvinte = new OuvinteTelaListarCorridas(this);
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private JButton buttonVoltar;
	private JButton buttonReinvindicar;

	public TelaListarCorridas(String titulo) {
		super(titulo);
		adicionarTitulo();
		criarButtoes();
		ListaDeCorridas();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel tituloTela = Componentes.adicionarJlabelComImagen(this, "LISTA DE CORRIDAS", icon, 0, 30, 750, 95, 50);
	}

	public void adicionarImagem() {
		JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
	}

public void ListaDeCorridas() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		//definir colunas
		modelo.setColumnIdentifiers(new String[] { "Email", "ID","Ponto de Partida","Ponto de Destino","Status"});
		
		
		ArrayList<Corrida> corridas = central.getTodosAsCorridas();
		

		for(Corrida corrida: corridas) {
			Object [] linha = new Object[5];
			if(corrida.getStatus() == StatusDaCorrida.PENDENTE) {
			 linha[0] = corrida.getPassageiro().getEmail();
			 linha[1] = corrida.getId();
			 linha[2] = corrida.getEnderecoDePartida();
		  	 linha[3] = corrida.getEnderecoDeDestino();
			 linha[4] = corrida.getStatus();
			modelo.addRow(linha);
		}
		
		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
	    painelTabela.setBounds(32, 150, 620, 300);
		painelTabela.setBackground(Color.WHITE);
		add(painelTabela);
		}
	}
	private void criarButtoes() {

		buttonReinvindicar = Componentes.adicionarJButton(this, "Reinvindicar corrida", 450, 500, 160, 35);
		buttonReinvindicar.addActionListener(ouvinte);

		buttonVoltar = Componentes.adicionarJButton(this, "Voltar", 50, 500, 160, 35);
		buttonVoltar.addActionListener(voltar());

	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedVoltar(e);
				;
			}
		};
	}

	public ActionListener reinvindincar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

}
