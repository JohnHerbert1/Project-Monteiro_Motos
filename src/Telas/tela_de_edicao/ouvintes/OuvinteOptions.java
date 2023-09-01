package Telas.tela_de_edicao.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Telas.tela_de_edicao.TelaDeEdicao;


/* ESTA TELA DE EDIÇÃO DOS DADOS DO USUARIO 
 * EDITA COM BASE A SELEÇAO DA CLASS JCHECKBOX
 */

public class OuvinteOptions implements ActionListener {
	TelaDeEdicao telaEdicao;
	
	
	public OuvinteOptions(TelaDeEdicao tela) {
		this.telaEdicao = tela;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> options = telaEdicao.getOptions();
		
		if(telaEdicao.getjCheckBoxNome().isSelected()) {
			options.add("1");
			telaEdicao.getNomeField().setVisible(true);
			telaEdicao.getNomeLeibol().setVisible(true);
			}else {
				if(options.contains("1")) {
				options.remove("1");
			}
				telaEdicao.getNomeField().setVisible(false);
				telaEdicao.getNomeLeibol().setVisible(false);
		}
					
		if(telaEdicao.getjCheckBoxE_mail().isSelected()) {
				options.add("2");
				telaEdicao.getEmailField().setVisible(true);
				telaEdicao.getEmailLeibol().setVisible(true);
			}else {
				if(options.contains("2")) {
					options.remove("2");
				}
				telaEdicao.getEmailField().setVisible(false);
				telaEdicao.getEmailLeibol().setVisible(false);
			}
		
		if(telaEdicao.getjCheckBoxSenha().isSelected()) {
			options.add("3");
			telaEdicao.getSenhaPassword().setVisible(true);
			telaEdicao.getSenhaLeibol().setVisible(true);
			
		}else {
			if(options.contains("3")) {
				options.remove("3");
			}
			telaEdicao.getSenhaPassword().setVisible(false);
			telaEdicao.getSenhaLeibol().setVisible(false);
		}
	
	
		
				
			
			
			
		
		
		
	}
	
}
