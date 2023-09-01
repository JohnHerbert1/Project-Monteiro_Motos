package Janelas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Enum.AcessoTips;
import Janelas.JanelaCadastroDeUsuario;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaDeLogin;
import entity.usuario.Usuario;
import entity.usuario.Exception.EmailNaoPossuiDominioException;
import entity.usuario.Exception.NomeComApernasNumerosException;
import entity.usuario.Exception.SenhaComEspacoEmBranco;
import entity.usuario.Exception.SenhaSemLetraMaisculaException;
import entity.usuario.Exception.SenhaSemLetraMinusculaException;
import entity.usuario.validador.ValidacaoDeCadastroDeUsuario;
import personalizedMessage.MensagemUsuario;

public class OuvinteTelaDeCadastroDeUsuario implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private JanelaCadastroDeUsuario janelaCadastroDeUsuario;

	public JanelaCadastroDeUsuario getJanelaCadastroDeUsuario() {
		return janelaCadastroDeUsuario;
	}

	public OuvinteTelaDeCadastroDeUsuario(JanelaCadastroDeUsuario janela) {
		this.janelaCadastroDeUsuario = janela;
	}
	
	public void actionPerformedCombo() {
		if(central.getTodosOsUsuarios().size() < 0) {
			janelaCadastroDeUsuario.getCombo().setVisible(false);
		}
	}
	
	public void actionPerformedVoltar(ActionEvent e) {
		janelaCadastroDeUsuario.dispose();
		new TelaDeLogin(null);
	}

	public void actionPerformed(ActionEvent e)  {
		String nome = janelaCadastroDeUsuario.getNome().getText();
		String email = janelaCadastroDeUsuario.getEmailResposta().getText();
		String senha01 = new String(janelaCadastroDeUsuario.getSenhaResposta().getPassword());
		String senha02 = new String(janelaCadastroDeUsuario.getcSenhaResposta().getPassword());
		String tipo = (String) janelaCadastroDeUsuario.getCombo().getSelectedItem(); //VOU VER SE ESTA FUNCIONADO ASSIM, NAO ENCONTREI OUTRA FORMA DE FAZER AO REATAR DADOS DO COMBOBOX
		
		try {
			if (nome.isBlank() || email.isBlank() || senha01.isBlank() || senha02.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else if(!senha01.equals(senha02)) {
				MensagemUsuario.usuarioSenhaErrada();
			} else {
				Usuario usuario = new Usuario(nome, email, senha01, true,AcessoTips.ACESSO_PERMITIDO,0);// COMO CITEI EM USUARIO E PRA TESTAR POIS AINDA NAO ESTA FUNCIONANDO
				ValidacaoDeCadastroDeUsuario validacao = new ValidacaoDeCadastroDeUsuario();
				
				validacao.validarSenha(usuario);
				validacao.validarEmail(usuario);
				validacao.validarNome(usuario);

				if (central.adicionarUsers(usuario,tipo)) {// ESTOU USANDO OUTRO METODO AQUI CASO QUERIA PODE TIRALO----- DEICHEI O MENTODO COMENTADO NA CENTRAL

					persistencia.salvarCentral(central);
					MensagemUsuario.usuarioSalvo();
					new TelaDeLogin (null);
					janelaCadastroDeUsuario.setVisible(false);

				} else {
					MensagemUsuario.usuarioErro();
				} // end else
			} // end else
		} catch (SenhaSemLetraMaisculaException | SenhaComEspacoEmBranco | SenhaSemLetraMinusculaException | NomeComApernasNumerosException | EmailNaoPossuiDominioException erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage());
		}
	}
}
	 // end catch} // end actionPerformed
 // end class
