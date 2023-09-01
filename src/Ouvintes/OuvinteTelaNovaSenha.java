package Ouvintes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaDeLogin;
import Telas.TelaNovaSenha;
import entity.usuario.Usuario;

public class OuvinteTelaNovaSenha implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private TelaNovaSenha tela;

	public OuvinteTelaNovaSenha(TelaNovaSenha tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {

		String novaSenha = tela.getNovaSenha().getText();
		String confirmarSenha = tela.getConfirmarSenha().getText();
		try {
			if (novaSenha.equals(confirmarSenha)) {
				ArrayList<Usuario> alterado = central.getTodosOsUsuarios();
				for(int i = 0; i < alterado.size(); i++) {
					if(alterado.get(i).isEstaAtivo() == true) {
						alterado.get(i).setSenha(novaSenha);	
					}
				}
				System.out.println("senha alterada");
				persistencia.salvarCentral(central);
				tela.dispose();
				new TelaDeLogin(null);
				
			}
		} catch (Exception erro) {
			System.out.println("erro");
		}
	}
}
