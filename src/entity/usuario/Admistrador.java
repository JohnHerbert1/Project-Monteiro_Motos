package entity.usuario;


import Enum.AcessoTips;

//CLASS CRIADA PRA IDENTIFCA QUEM E O USUARIO--------
public class Admistrador extends Usuario {
	
	
	
	
	public Admistrador() {
		
	}
	
	public Admistrador(String nome,String email ,String senha, AcessoTips acesso,boolean estaAtivo,int creditos) {
		super(nome,email,senha,estaAtivo,acesso,creditos);
	}
	
	public boolean equals(Admistrador administrador) {
		return	getEmail().equals(administrador.getEmail());
	}
		

	@Override
	public String toString() {
		return "Email :" + getEmail()+ "\nSenha: " + getSenha() + " Esta Ativo: " + isEstaAtivo() ;
	}
	
	
	
	

}

