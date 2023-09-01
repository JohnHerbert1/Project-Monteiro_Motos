package entity;

import entity.usuario.MotoTaxista;

// ClASS PRA DEFINIR O VALOR DOS CREDITOS MAIS RECEBE UM MONTOTAX PRA SABER QUEM ESTA PAGANDO
public class ValorCreditos {
	
	private MotoTaxista motoTax;
	private double valorCreditos;
	
	
	public ValorCreditos(MotoTaxista users , double creditos) {
		this.motoTax = users;
		this.valorCreditos = creditos;
	}


	public MotoTaxista getMotoTax() {
		return motoTax;
	}


	public void setMotoTax(MotoTaxista motoTax) {
		this.motoTax = motoTax;
	}


	public double getValorCreditos() {
		return valorCreditos;
	}


	public void setValorCreditos(double valorCreditos) {
		this.valorCreditos = valorCreditos;
	}
	
	
	
	
}
