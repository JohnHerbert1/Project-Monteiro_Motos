package Programa;

import Janelas.JanelaCadastroDeUsuario;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaDeLogin;

public class Programa {

	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();
		if(central.getTodosOsUsuarios().size() <= 0) {
			new JanelaCadastroDeUsuario(null);
		}else {
			new TelaDeLogin(null);
		}
			
	}
}
