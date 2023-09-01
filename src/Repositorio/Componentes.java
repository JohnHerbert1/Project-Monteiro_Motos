package Repositorio;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.itextpdf.text.Font;

import Telas.TelaListarUsuarios;
import entity.SorteioDeTelaImagens;

// AQUI ADICIONEM OS BUT�ES OU JCLASS QUE FOREM USAR. JA EXISTEM ALGUMS QUE EU CRIEI AQUI PRA FACILITAR.
public class Componentes {
/* @author John
 * @version 02/12/2022
 * 
 * 
 * 
 * 
 */
	
	public static JMenuItem adicionaMenuIten(JFrame janela,String nomeMenu) {
		
		JMenuItem opcao = new JMenuItem(nomeMenu);
		opcao.setBackground(Color.BLACK);
		opcao.setForeground(Color.YELLOW);
		janela.add(opcao);
		return opcao;
		
	}
	
	public static JCheckBox adicionarCheckBox(JFrame janela, String nome, int x, int y ,int cumprimento,int altura) {
		JCheckBox jCheckBox = new JCheckBox(nome);
		jCheckBox.setBounds(x, y, cumprimento, altura);
		janela.add(jCheckBox);
		return jCheckBox;
		
	}
	
	
/*
 * 
 */
	
	public static JComboBox<String> adicionarComboBox(JFrame janela, ArrayList<String> texto ,int x,int y, int cumprimento , int altura) {
		
		Vector<String> arryText = new Vector <String>(texto);
		JComboBox<String> jComboBox = new JComboBox<>(arryText);
		jComboBox.setBounds(x,y,cumprimento,altura);
		janela.add(jComboBox);
		return jComboBox;
		
	}
	
/*
 * 	
 */
	
	
	public static JLabel SortImage(JFrame janela,int x,int y,int cumprimento,int altura) {//FIZZ ISSO PARA N�O SER PRECISO STANCIA AS CLASS
		
		SorteioDeTelaImagens imagenSorteada = new SorteioDeTelaImagens();
		
		JLabel jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon(imagenSorteada.sorteioDeTela()));
		jLabel.setBounds(x, y, cumprimento, altura);
		janela.add(jLabel);
		
		return jLabel;
	}

	public static JLabel SortImageMotocas(JFrame janela,int x,int y,int cumprimento,int altura) {//FIZZ ISSO PARA N�O SER PRECISO STANCIA AS CLASS
		
		SorteioDeTelaImagens imagenSorteada = new SorteioDeTelaImagens();
		
		JLabel jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon(imagenSorteada.sorteioDeTelaMototaxi()));
		jLabel.setBounds(x, y, cumprimento, altura);
		janela.add(jLabel);
		
		return jLabel;
	}

	/*
	 * 
	 */

	public static JButton adicionarJButton(JFrame janela,String texto, int x, int y , int cumprimento , int altura) {
		JButton jButton = new JButton(texto);
		jButton.setBounds(x,y,cumprimento,altura);
	//	jButton.setVerticalTextPosition(SwingConstants.CENTER);
	//	jButton.setHorizontalTextPosition(SwingConstants.BOTTOM);
		jButton.setBackground(Color.BLACK);
		jButton.setForeground(Color.YELLOW);
		janela.add(jButton);
		return jButton;
	}
	
	/*
	 * 
	 */
	
	public static JTextField adicionarJtextfield(JFrame janela, int x, int y , int cumprimento , int altura) {
		JTextField jTextField = new JTextField();
		jTextField.setBounds(x, y, cumprimento, altura);
		janela.add(jTextField);
		return jTextField;
	}
	
/*
 * 	
 */
	
	public static  JLabel adicionarJLabel(JFrame janela,String nomeCampo, int x, int y, int cumprimento, int altura) {
		JLabel nome = new JLabel(nomeCampo);
		nome.setBounds(x, y, cumprimento, altura);
		//nome.setFont(Util.FONT_KG);
	    nome.setOpaque(true);
		nome.setBackground(Color.BLACK);
		nome.setForeground(Color.YELLOW);
		janela.add(nome);
		return nome ;	
	} 
	
	/*
	 * 
	 */
	
	public static JLabel adicionarJlabelComImagen(JFrame janela,String texto,ImageIcon imagen,int x, int y, int cumprimento, int altura, int tamanhoFonte ) {
	JLabel jLabel = new JLabel(texto, imagen, JLabel.LEFT);
	jLabel.setBounds(x, y, cumprimento, altura);
	jLabel.setFont( new java.awt.Font("Impact",Font.ITALIC,tamanhoFonte));
	jLabel.setOpaque(true);
	jLabel.setBackground(Color.BLACK);
	jLabel.setForeground(Color.YELLOW);
	janela.add(jLabel);
	return jLabel;
	
	}
	
	/*
	 * 
	 */public static JLabel SortImagePassageiro(JFrame janela,int x,int y,int cumprimento,int altura) {//FIZZ ISSO PARA N�O SER PRECISO STANCIA AS CLASS
			
			SorteioDeTelaImagens imagenSorteada = new SorteioDeTelaImagens();
			
			JLabel jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(imagenSorteada.sorteioDeTelaPassageiro()));
			jLabel.setBounds(x, y, cumprimento, altura);
			janela.add(jLabel);
			
			return jLabel;
		}
	 public static JPasswordField addJPswordField(JFrame tela, int x, int y, int comprimento, int altura) {
		JPasswordField paswordField = new JPasswordField();
		paswordField.setBounds(x, y, comprimento, altura);
		tela.add(paswordField);
		return paswordField;
	}
}
