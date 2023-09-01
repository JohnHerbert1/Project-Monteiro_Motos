package Model;

import java.awt.Color;

import javax.swing.JLabel;

public class AdicionarJLabel extends JLabel {
	
	public JLabel adicionarJLabel(String nomeCampo, int x, int y, int z, int w) {
		
		JLabel nome = new JLabel(nomeCampo);
		nome.setBounds(x, y, z, w);
	    nome.setOpaque(true);
		nome.setBackground(Color.BLACK);
		nome.setForeground(Color.YELLOW);
		return (JLabel) add(nome);	
	}
}
