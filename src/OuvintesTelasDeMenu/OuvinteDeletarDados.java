package OuvintesTelasDeMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Enum.AcessoTips;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.menu.adm.TelaDeMenuADM;
import Telas.menu.mototax.TelaMenuMototaxista;
import Telas.menu.passageiro.TelaMenuPassageiro;
import entity.usuario.Usuario;

public class OuvinteDeletarDados implements  ActionListener {
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();
	
	private TelaMenuMototaxista motototax;
	private TelaMenuPassageiro passageiro;
	private TelaDeMenuADM adm;
	
	public OuvinteDeletarDados(TelaMenuMototaxista motoTelas) {
		this.motototax = motoTelas;
	}
	public OuvinteDeletarDados(TelaMenuPassageiro passaTelas) {
		this.passageiro = passaTelas;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		
		if(	JOptionPane.showConfirmDialog(null, "Quer realmente apagar seu perfil", "Excluir usuário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			ArrayList<Usuario> modificador = central.getTodosOsUsuarios();
			
			for(int i = 0 ; i < modificador.size(); i++ ) {
				if(modificador.get(i).isEstaAtivo()) {
					if(modificador.get(i).getTiposDeAcesso() == AcessoTips.ACESSO_PERMITIDO) {
						modificador.get(i).setTiposDeAcesso(AcessoTips.BLOOK_ACESSO);
						central.estaDesativado();
						persistencia.salvarCentral(central);	
					}
				}
				
			}
			System.out.println("funfou");
		}else {
			System.out.println(" Não quero Deletar");
		}
		 
			
		
		
	}

}
