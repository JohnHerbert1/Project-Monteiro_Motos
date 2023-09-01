package Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Enum.StatusDaCorrida;
import Janelas.JanelaPadrao;
import Ouvintes.OuvinteReinvindicarCorrida;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.Corrida;

public class TelaReinvidicarCorridaEDetalhesDaCorrida extends JanelaPadrao {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();
	OuvinteReinvindicarCorrida ouvinte = new OuvinteReinvindicarCorrida(this);
	
	private JButton buttonConcluirCorrida;

	public TelaReinvidicarCorridaEDetalhesDaCorrida(String titulo) {
		super(titulo);
		ListaDeCorridas();
		adiconarButton();
		titulo();
		imagemDeFundo();
		setVisible(true);
		
		
	}

	public void titulo() {
		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel titulo = Componentes.adicionarJlabelComImagen(this, "Reinvindicar corrida", icon, 0, 30, 750, 95, 50);
	}

	public void imagemDeFundo() {
		JLabel tela = Componentes.SortImage(this, 0, 0, 700, 600);
	}

	public void corridaselecionada() {
		try {
			List<Corrida> corridas = central.getTodosAsCorridas();
			for (int i = 0; i < corridas.size(); i++) {
				if (corridas.get(i).getStatus().equals(StatusDaCorrida.PENDENTE)) {
					corridas.get(i).setStatus(StatusDaCorrida.ANDAMENTO);
					break;
				}
			}
		} catch (Exception e) {
		}
	}
	
	private void adiconarButton() {
		buttonConcluirCorrida = Componentes.adicionarJButton(this, "Concluir corrida Reinvindicada", 230, 480, 220, 40);
		buttonConcluirCorrida.addActionListener(novoConcluircorrida());
	}
	
	public ActionListener novoConcluircorrida() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformadConcluir(e);
		}
		};
	}

	public void ListaDeCorridas() {

		DefaultTableModel modelo = new DefaultTableModel();
		// definir colunas
		modelo.addColumn("ID");
		modelo.addColumn("Ponto de Partida");
		modelo.addColumn("Ponto de Destino");
		modelo.addColumn("Statuts");

		ArrayList<Corrida> corridas = central.getTodosAsCorridas();

		Object[] linhas = new Object[corridas.size()];

		for (int i = 0; i < corridas.size(); i++) {
			if (corridas.get(i).getStatus().equals(StatusDaCorrida.ANDAMENTO)) {
				Object[] linha = new Object[4];
				linha[0] = corridas.get(i).getId();
				linha[1] = corridas.get(i).getEnderecoDePartida();
				linha[2] = corridas.get(i).getEnderecoDeDestino();
				linha[3] = corridas.get(i).getStatus();
				modelo.addRow(linha);
				break;
			}

		}
		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(100, 150, 500, 300);
		painelTabela.setBackground(Color.WHITE);
		add(painelTabela);

	}
}
