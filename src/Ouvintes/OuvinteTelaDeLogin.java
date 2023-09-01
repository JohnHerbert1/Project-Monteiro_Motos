package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Enum.AcessoTips;
import Janelas.JanelaCadastroDeUsuario;
import Model.Mensageiro;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaDeLogin;
import Telas.TelaNovaSenha;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.mototax.TelaMenuMototaxista;
import Telas.menu.passageiro.TelaMenuPassageiro;
import entity.usuario.Admistrador;
import entity.usuario.MotoTaxista;
import entity.usuario.Passageiro;
import entity.usuario.Usuario;
import entity.usuario.validador.ValidacaoDeCadastroDeUsuario;
import personalizedMessage.MensagemEmail;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;
import personalizedMessage.MensagemUsuario;

public class OuvinteTelaDeLogin implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaDeLogin telaDeLogin;

	public TelaDeLogin getTelaDeLogin() {
		return telaDeLogin;
	}

	public OuvinteTelaDeLogin(TelaDeLogin tela) {
		this.telaDeLogin = tela;
	}

	public void actionPerformedNovoCadastro(ActionEvent novoCadastro) {
		// novoCadastro.getActionCommand();
		new JanelaCadastroDeUsuario(null);
		telaDeLogin.setVisible(false);

	}

	public void actionPerformed(ActionEvent proseguir) {

		String email = telaDeLogin.getCampoEmail().getText();
		String senha = new String(telaDeLogin.getCampoSenha().getPassword());

		try {

			if (email.isBlank() || senha.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {
				if (centralDeInformacoes.isLogin(email, senha)) {

					Usuario user = new Usuario();
					user = centralDeInformacoes.entradaClass(user, email);
				if(user.getTiposDeAcesso() == AcessoTips.ACESSO_PERMITIDO) {	
					if (user instanceof Admistrador && user.getTiposDeAcesso() == AcessoTips.ACESSO_PERMITIDO) {
						telaDeLogin.setVisible(false);
						new TelaDeMenuADM("Administrador");
					} else if (user instanceof Passageiro && user.getTiposDeAcesso() == AcessoTips.ACESSO_PERMITIDO) {
						telaDeLogin.setVisible(false);
						new TelaMenuPassageiro("Passageiro");
					} else if (user instanceof MotoTaxista && user.getTiposDeAcesso() == AcessoTips.ACESSO_PERMITIDO) {
						telaDeLogin.setVisible(false);
						new TelaMenuMototaxista("Mototax");
					}
				}
					if(user.getTiposDeAcesso() == AcessoTips.ACESSO_PERMITIDO){ {
					centralDeInformacoes.estaAtivo(user, email);
					persistencia.salvarCentral(centralDeInformacoes);
					}
					
					}
				} else {
					MensagemUsuario.usuarioNaoEncontrado();
				} // end else
			} // end else
		} catch (NullPointerException e) {
			MensagemException.nullPointerException(e);
		} // end catch
	} // actionPerformed

	public void actionPerformedSenha(ActionEvent senha) {
		String Email = telaDeLogin.getCampoEmail().getText();
		Usuario usuario = centralDeInformacoes.recuperarUsuario(Email);
		try {
			boolean valido = ValidacaoDeCadastroDeUsuario.validarEmailCodSeguranca(Email);
			
			
			if (valido) {
				int codigo = Mensageiro.enviarEmailComCodigoDeVerificacao(Email);
				int codigo2 = MensagemPrograma.criarMensagem("Digite o codigo recebido no seu email:");
				if (codigo == codigo2) {	
					
					Usuario atividade = centralDeInformacoes.estaAtivo(usuario, Email);
					centralDeInformacoes.getTodosOsUsuarios().add(atividade);
					
					persistencia.salvarCentral(centralDeInformacoes);
					telaDeLogin.dispose();
					new TelaNovaSenha(null);
				} else {
					System.out.println("invalido");
				}
			}

		} catch (Exception e) {
			MensagemEmail.emailErro();
		}
	} // end actionPerformedSenha
} // end class
