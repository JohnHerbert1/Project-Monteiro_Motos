package Ouvintes;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import Repositorio.CentralDeInformacoes;
import Repositorio.GeradorDeRelatorios;
import Repositorio.Persistencia;
import Telas.TelaComparCredito;
import Telas.TelaDeLogin;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.mototax.TelaMenuMototaxista;
import entity.ValorCreditos;
import entity.usuario.MotoTaxista;
import entity.usuario.Passageiro;
import entity.usuario.Usuario;

public class OuvinteTelaComprarCreditos implements ActionListener {
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private TelaDeLogin telaLogin;
	private TelaComparCredito tela;

	public OuvinteTelaComprarCreditos(TelaComparCredito tela) {
		this.tela = tela;
	}

	public void actionPerfomedVoltar(ActionEvent e) {
		tela.dispose();
		new TelaMenuMototaxista(null);
	}

	public void actionPerformed(ActionEvent e) {
		int qtd = (Integer) tela.getSpinner().getValue();
		if (qtd > 0) {
			try {
				File arquivo = new File("boleto.pdf");
				Desktop.getDesktop().open(arquivo);
				String valorString = tela.getPreco().getText().replace(',', '.');
				double valor = Double.parseDouble(valorString);
				
				
				Usuario b = new Usuario();
				b.setEstaAtivo(true);

				for (int i = 0; i < central.getTodosOsUsuarios().size(); i++) {
					if (central.getTodosOsUsuarios().get(i).isEstaAtivo()) {
						b = central.getTodosOsUsuarios().get(i);
					}
				}
				MotoTaxista a = (MotoTaxista) b;
				
				ValorCreditos compras = new ValorCreditos(a,valor);
				
				GeradorDeRelatorios.gerarBoleto(qtd, valor);
				central.adicionarCompraCreditos(compras);
				central.editorDeCreditos(qtd);
				persistencia.salvarCentral(central);
				JOptionPane.showMessageDialog(null, "Boleto gerado com sucesso!");
			} catch (Exception erro) {
				erro.printStackTrace();			}

		}
	}
}
