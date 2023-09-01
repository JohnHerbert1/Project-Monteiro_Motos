package Telas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Janelas.JanelaPadrao;
import Ouvintes.OuvinteTelaListarUsuarios;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.usuario.Admistrador;
import entity.usuario.MotoTaxista;
import entity.usuario.Usuario;
public class TelaListarUsuarios extends JanelaPadrao {
	
	OuvinteTelaListarUsuarios ouvinte = new OuvinteTelaListarUsuarios(this);
	DefaultTableModel modelo = new DefaultTableModel();
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();
	ArrayList<Usuario> users = central.getTodosOsUsuarios();
	JTextField tfPesquisarPorNome;
	JScrollPane painelTabela;
	

	private JButton buttonVoltar;

	public TelaListarUsuarios(String titulo) {
		super(titulo);
		adicionarCamposDeTexto();
		buttonVoltar();
		tabelaCorridasUsuarios();
		adicionarTitulo();
		setVisible(true);
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("figuras/logo.png");
		Componentes.adicionarJlabelComImagen(this, "LISTA DE USUARIOS", icon, 0, 30, 750, 95, 50);
		Componentes.adicionarJLabel(this, "Filtrar por Nome:", 6, 123, 95, 25); 
		Componentes.SortImage(this, 0, 0, 700, 600);
	}

	private void addLinha(DefaultTableModel modelo2, Usuario a) {
		Object[] linha = new Object[5];
		
		linha[0] = a.getNome();
		
		linha[1] = a.getEmail();
		
		if (a instanceof MotoTaxista) {
			linha[2] = "MOTOTAXISTA";
		} else if (a instanceof Admistrador) {
			linha[2] = "ADMNISTRADOR";
		} else {
			linha[2] = "PASSAGEIRO";
		}linha[3] = a.getTiposDeAcesso();
		
		modelo.addRow(linha);		
		users.add(a);
	}

	private void tabelaCorridasUsuarios() {
		
		// definir colunas
		modelo.setColumnIdentifiers(new String[] {"Usuario:","Email:","Tipo:","Tipo De Acesso:"});	
		for (Usuario a : users) {

			Object[] linha = new Object[4];
			linha[0] = a.getNome();
			linha[1] = a.getEmail();
			if (a instanceof MotoTaxista) {
				linha[2] = "MOTOTAXISTA";
			} else if (a instanceof Admistrador) {
				linha[2] = "ADMNISTRADOR";
			} else {
				linha[2] = "PASSAGEIRO";
			}linha[3] = a.getTiposDeAcesso();
			modelo.addRow(linha);

		}
		JTable tabela = new JTable(modelo);
		painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(104, 160, 496, 300);
		painelTabela.setBackground(Color.WHITE);
		add(painelTabela);
	}
	private class OuvinteFiltro implements KeyListener {

		public void keyTyped(KeyEvent e) {
			
			users = new ArrayList<Usuario>();
			
			String filtro = tfPesquisarPorNome.getText();
			
			char letra = e.getKeyChar();
			
			if (Character.isAlphabetic(letra) || Character.isWhitespace(letra))
				filtro = filtro + letra;
			else if (Character.isDigit(letra)) {
				e.consume();
				return;
			}
			modelo.setRowCount(0);

			for(Usuario p: central.getTodosOsUsuarios()) {
			
				if (p.getNome().contains(filtro)) {
					addLinha(modelo, p);
				}
			}
			
			painelTabela.repaint();
		}
		
		public void keyPressed(KeyEvent e) {}

		public void keyReleased(KeyEvent e) {}
		
	}
	private void adicionarCamposDeTexto() {
		tfPesquisarPorNome = new JTextField("");
		tfPesquisarPorNome.setBounds(104, 125, 496, 25);
		tfPesquisarPorNome.addKeyListener(new OuvinteFiltro());
		add(tfPesquisarPorNome);
	}
	

	private void buttonVoltar() {
		buttonVoltar = Componentes.adicionarJButton(this, "Voltar", 250, 480, 200, 30);
		buttonVoltar.addActionListener(voltar());
	}
	
	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}
	public static void main(String[] args) {
		new TelaListarUsuarios(null);
	}
}
