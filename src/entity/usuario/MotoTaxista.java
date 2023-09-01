package entity.usuario;

import Enum.AcessoTips;

//CLASS CRIADA PRA IDENTIFCA QUEM E O USUARIO--------
//VOU MODIFICAR A CLASS PARA TAMBEM RECEBER UMA SENHA  E VER UMA FORMA DE ORGANIZA MELHOR 
//CLASS MOTO TAXISTA SO SERVE PRA DEFINIR QUEM E O ENTITY
public class MotoTaxista extends Usuario {


	public MotoTaxista() {
	}

	public MotoTaxista(String nome, String eMail, String senha, AcessoTips acessos, boolean estaAtivo,int creditos) {
		super(nome,eMail,senha,estaAtivo,acessos,creditos);
	}

	public boolean equals(MotoTaxista motoTaxis) {
		return getEmail().equals(motoTaxis.getEmail());

	}

	public String toString() {
		return "nome: " + this.getNome() + " Email: " + this.getEmail() + " Senha: " + getSenha() + " Creditos: "
				+ getCreditos();
	}


}
