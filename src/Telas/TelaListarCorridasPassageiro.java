package Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Janelas.JanelaPadrao;
import Ouvintes.OuvinteTelaDeListarCorridasPassageiro;
import Repositorio.CentralDeInformacoes;
import Repositorio.Componentes;
import Repositorio.Persistencia;
import entity.Corrida;
//RYAN PASSOU POR AQUI
import entity.usuario.Passageiro;
import entity.usuario.Usuario;

public class TelaListarCorridasPassageiro extends JanelaPadrao {
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	OuvinteTelaDeListarCorridasPassageiro ouvinte = new OuvinteTelaDeListarCorridasPassageiro(this);
	private JButton voltar;

	public TelaListarCorridasPassageiro(String titulo) {
		super(titulo);
		addButtonVoltar();
		minhasCorridas();
		tituloDaTela();
		imagemFundo();
		setVisible(true);
	}
	
	public void tituloDaTela() {
		ImageIcon icon = new ImageIcon("figuras/logo.png");
		Componentes.adicionarJlabelComImagen(this, "MINHAS CORRIDAS", icon, 0, 30, 750, 95, 50);
	}
	
	public void imagemFundo() {
		Componentes.SortImage(this, 0, 0, 700, 600);
	}
	
	public void minhasCorridas() {
		Usuario b = new Usuario();
		ArrayList<Usuario> usuarios = centralDeInformacoes.getTodosOsUsuarios();
		for(int i = 0;i < usuarios.size();i++) {
			if(usuarios.get(i).getClass().equals(Passageiro.class)) {
				if(usuarios.get(i).isEstaAtivo()) {
					b = usuarios.get(i);
				}
			}
		}
//		for(Usuario c: centralDeInformacoes.getTodosOsUsuarios()) {
//			
//			if(c instanceof Passageiro) {
//				if(c.isEstaAtivo()==true)
//					b = c;
//			}
		DefaultTableModel modelo = new DefaultTableModel();
		// definir colunas
		modelo.setColumnIdentifiers(new String[] { "Email","Ponto de Partida","Ponto de Destino","Status"});
		
		ArrayList<Corrida> corridas = centralDeInformacoes.recuperarCorridaDeUmPassageiro(b.getEmail());
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
//NAO TA PEGANDO ESSE DE BAIXO
	private void addButtonVoltar() {
		voltar = Componentes.adicionarJButton(this, "Voltar", 50, 500, 100, 30);
		voltar.addActionListener(voltar());
	}
	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
	
		};
	}
}
	


