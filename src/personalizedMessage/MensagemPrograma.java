package personalizedMessage;


import javax.swing.JOptionPane;

import entity.Corrida;
import entity.usuario.Usuario;

public class MensagemPrograma {


	//public static void detalharCorrida(Corrida corrida) {
		//JOptionPane.showMessageDialog(null, corrida.toString());
	//}
	public static void detalharUsuario(Usuario usuario) {
		JOptionPane.showMessageDialog(null, usuario.detalharPerfil());
	}
	public static void detalharCorrida(Corrida corrida) {
		JOptionPane.showMessageDialog(null,corrida.detalhes());
	}
	public static void corridaReinvindicada(Corrida corrida) {
		JOptionPane.showMessageDialog(null,corrida.corridaReinvindicadaComSucesso());
	}
	public static int criarMensagem(String msg) {
		String cod = JOptionPane.showInputDialog(msg);
		return Integer.parseInt(cod);
	}
	
	
	

}
