package Telas;
//RYAN PASSOU AQUI 

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Janelas.JanelaPadrao;
import Ouvintes.OuvinteTelaListarCorridasADM;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.Corrida;
import entity.usuario.Passageiro;
import entity.usuario.Usuario;

public class TelaListarCorridasADM extends JanelaPadrao {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();
	OuvinteTelaListarCorridasADM ouvinte = new OuvinteTelaListarCorridasADM(this);
	private JButton voltar;

	public TelaListarCorridasADM(String titulo) {
		super(titulo);
		addButtonVoltar();
		ListaDeCorridas();
		adicionarTitulo();
		adicionarImagem();
		
		setVisible(true);
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("figuras/logo.png");
		JLabel tituloTela = Componentes.adicionarJlabelComImagen(this, "LISTAR CORRIDAS", icon, 0, 30, 750, 95, 50);
	}

	public void adicionarImagem() {
		JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
	}

	public void ListaDeCorridas() {
		Usuario b = new Passageiro();
		
		for(Usuario c: central.getTodosOsUsuarios()) {
			
			if(c instanceof Passageiro) {
				if(c.isEstaAtivo())
					b = c;
			}
		DefaultTableModel modelo = new DefaultTableModel();
		// definir colunas
		modelo.setColumnIdentifiers(new String[] { "Email","ID","Ponto de Partida","Ponto de Destino","Status"});
		
		ArrayList<Corrida> corridas = central.getTodosAsCorridas();
		
		for(Corrida corrida : corridas) {
			Object[] linha = new Object[5];
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
	
	private void addButtonVoltar() {
		voltar = Componentes.adicionarJButton(this, "Voltar", 50, 500, 100, 30);
		voltar.addActionListener(voltar());
	}
	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
				;
			}
		};
	}
}

