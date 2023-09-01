package entity.usuario;

import javax.swing.JOptionPane;

import Enum.AcessoTips;
import Telas.TelaComparCredito;
import Telas.TelaListarCorridas;


public  class Usuario {

	private String nome;
	private String email;
	private String senha;
	private AcessoTips tiposDeAcesso;
	private boolean estaAtivo;
	private int creditos;
	private TelaListarCorridas tela;// PARA QUE ESSE ATRIBUTO ?
	
	
	
	
	public Usuario() {}
	
	public Usuario(String iniciarEmail, String iniciarSenha) {this.email = iniciarEmail; this.senha = iniciarSenha; }
																								
	public Usuario(String nome, String email, String senha, boolean estaAtivo,AcessoTips acessos , int creditos) {//POR ENQUANTO ADICIONEI O TIPODEUSUARIO MAIS SE QUISER USAR O METODO SALVAR E SO RETIRALO DAQUI 
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.estaAtivo = estaAtivo;
		this.setTiposDeAcesso(acessos);
		this.creditos=creditos;
	}
	
	public String detalharPerfil() {
		 return "Nome :" + getNome()+ "\nEmail: " + getEmail() + "\nSenha : " + getSenha();
	}

	public boolean equals(Usuario usuario) {
		return email.equals(usuario.getEmail());
	}

	public  String toString(){
		return "Email :" + email+ "\nSenha: " + senha;
	}


	public int decresimos() {
		if(creditos <= 0) {
			JOptionPane.showMessageDialog(null, "Compre mais Creditos!!");
			tela.dispose();
			new TelaComparCredito(null);
		}
			return -- creditos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isEstaAtivo() {
		return estaAtivo;
	}

	public void setEstaAtivo(boolean estaAtivo) {
		this.estaAtivo = estaAtivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public AcessoTips getTiposDeAcesso() {
		return tiposDeAcesso;
	}

	public void setTiposDeAcesso(AcessoTips tiposDeAcesso) {
		this.tiposDeAcesso = tiposDeAcesso;
	}
	

}
