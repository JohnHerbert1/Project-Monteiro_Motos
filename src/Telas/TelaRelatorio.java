package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Janelas.JanelaPadrao;
import Ouvintes.OuvintesGerarRelatorio;
import Repositorio.Componentes;

public class TelaRelatorio extends JanelaPadrao {
		
		OuvintesGerarRelatorio ouve = new OuvintesGerarRelatorio(this);
		JButton gerarRelatorio;
		JButton voltar;

		public TelaRelatorio(String titulo) {
			super(titulo);
			butom();
			tituloDaTela();
			imagemFundo();
			setVisible(true);
			
		}
		
		public void tituloDaTela() {
			ImageIcon icon = new ImageIcon("figuras/logo.png");
			JLabel titulo = Componentes.adicionarJlabelComImagen(this, "RELATORIO DE FINANÇAS", icon, 0, 30, 750, 95, 50);
		}
		
		public void imagemFundo() {
			JLabel image = Componentes.SortImage(this, 0, 0, 700, 600);
		}
		
		public void butom() {
			
			gerarRelatorio = Componentes.adicionarJButton(this, "Gerar Relatorio", 400, 300, 200, 30);
			gerarRelatorio.addActionListener(gerar());
			voltar = Componentes.adicionarJButton(this, "Voltar", 50, 300, 200, 30);
			voltar.addActionListener(voltar());
			
		
		}
		public ActionListener voltar() {
			
			return new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ouve.actionPerformedVoltar(e);
				}
			};
		}
	public ActionListener gerar() {
			
			return new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ouve.actionPerformed(e);
				}
			};
		}

		public JButton getGerarRelatorio() {
			return gerarRelatorio;
		}

		public void setGerarRelatorio(JButton gerarRelatorio) {
			this.gerarRelatorio = gerarRelatorio;
		}

		public JButton getVoltar() {
			return voltar;
		}

		public void setVoltar(JButton voltar) {
			this.voltar = voltar;
		}

		
		
	}

