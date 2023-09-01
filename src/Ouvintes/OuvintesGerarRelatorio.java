package Ouvintes;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import Repositorio.GeradorDeRelatorios;
import Telas.TelaComparCredito;
import Telas.TelaRelatorio;
import Telas.menu.adm.TelaDeMenuADM;

public class OuvintesGerarRelatorio implements ActionListener {

	private TelaRelatorio telaRelatorio;

	public OuvintesGerarRelatorio(TelaRelatorio telaRelatorio) {
		this.telaRelatorio = telaRelatorio;
	}
	


	public void actionPerformedVoltar(ActionEvent e) {
		telaRelatorio.dispose();
		new TelaDeMenuADM(null);
	}

	public void actionPerformed(ActionEvent e) {

	
			GeradorDeRelatorios.gerarRelatorioDeCompras("gerar", 0, 0.05);
			JOptionPane.showMessageDialog(telaRelatorio, "relatorio gerado");
	
			
		}
	}

