package Telas.tela_de_edicao.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Enum.AcessoTips;
import Ouvintes.OuvinteTelaDeLogin;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaDeLogin;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.mototax.TelaMenuMototaxista;
import Telas.menu.passageiro.TelaMenuPassageiro;
import Telas.tela_de_edicao.TelaDeEdicao;
import entity.usuario.Admistrador;
import entity.usuario.MotoTaxista;
import entity.usuario.Passageiro;
import entity.usuario.Usuario;

public class OuvinteTelaDeEdicao implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();
	private OuvinteTelaDeLogin login;
	private TelaDeLogin telaLogin;
	private TelaDeMenuADM telaAdm;
	private TelaDeEdicao telaDeEdicao;

	public OuvinteTelaDeEdicao(TelaDeEdicao tela) {
		this.telaDeEdicao = tela;
	}

	public OuvinteTelaDeEdicao(TelaDeMenuADM tela) {
		this.telaAdm = tela;
	}

	public void actionButtonTelaDeEdicao(ActionEvent e) {
		telaAdm.dispose();
		new TelaDeEdicao(null);
	}

	public void actionPerformed(ActionEvent salvar) {

		String nome = telaDeEdicao.getNomeField().getText();
		String E_mail = telaDeEdicao.getEmailField().getText();
		String senha = new String(telaDeEdicao.getSenhaPassword().getPassword());

		central.funcaoEdicao(telaDeEdicao.getOptions(), nome, E_mail, senha);

//	central.getTodosOsUsuarios().add(editado);
		persistencia.salvarCentral(central);

//	if(central.entradaClass(editado, quemEstaFazendoEdicao) != null ) {

//		editado = central.entradaClass(editado, quemEstaFazendoEdicao);
		Usuario editado = central.deslogarTela();

		if (editado instanceof Admistrador) {
			telaDeEdicao.dispose();
			new TelaDeMenuADM("Administrador");
		} else if (editado instanceof Passageiro) {
			telaDeEdicao.dispose();
			new TelaMenuPassageiro("Passageiro");
		} else if (editado instanceof MotoTaxista) {
			telaDeEdicao.dispose();
			new TelaMenuMototaxista("Mototax");
		}

	}

	public void actionPerfomedExluir(ActionEvent e) {
		
		
		if (JOptionPane.showConfirmDialog(null, "Quer realmente apagar seu perfil", "Excluir usuário",	JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			ArrayList<Usuario> modificador = central.getTodosOsUsuarios();
			for (int i = 0; i < modificador.size(); i++) {
				if (modificador.get(i).isEstaAtivo()) {
					if (modificador.get(i).getTiposDeAcesso() == AcessoTips.ACESSO_PERMITIDO) {
						modificador.get(i).setTiposDeAcesso(AcessoTips.BLOOK_ACESSO);
						central.estaDesativado();
						persistencia.salvarCentral(central);
					}

				}

			}
			telaDeEdicao.dispose();
			new TelaDeLogin(null);
			System.out.println("funfou");
		} else {
			System.out.println(" Não quero Deletar");
		}

	}

	public void actionPerformedCancelar(ActionEvent cancelar) {
		Usuario editado = central.deslogarTela();

		if (editado instanceof Admistrador) {
			telaDeEdicao.dispose();
			new TelaDeMenuADM("Administrador");
		} else if (editado instanceof Passageiro) {
			telaDeEdicao.dispose();
			new TelaMenuPassageiro("Passageiro");
		} else if (editado instanceof MotoTaxista) {
			telaDeEdicao.dispose();
			new TelaMenuMototaxista("Mototax");
		}

	}

}
