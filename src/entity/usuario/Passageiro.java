package entity.usuario;

import Enum.AcessoTips;

public class Passageiro extends Usuario {
	
	

	public Passageiro(String nome, String email, String senha, boolean estaAtivo,AcessoTips tipoAcesso,int creditos) {
		super(nome, email, senha, estaAtivo,tipoAcesso,creditos);
//		this.dataNascimento = dataNascimento;
	}

	public Passageiro() {
	}

	public String toString() {
		return "Nome: " + getNome() + "\nSenha: " +  getSenha() ;
	}
	

	public boolean equals(Passageiro passageiro) {
		return getEmail().equals(passageiro.getEmail());
	}


}
