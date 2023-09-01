package entity;

import java.util.Random;

public class SorteioDeTelaImagens {

	public String sorteioDeTela() {

		String imagens[] = {"figuras/Fundo4.png","figuras/Fundo3.jpg"};

		int numero = new Random().nextInt(2);
		String sorteio = imagens[numero];
		return sorteio;
	}
	public String sorteioDeTelaMototaxi() {

		String imagens[] = {"figuras/Colete.jpg","figuras/MotoTaxi.jpg","figuras/Motoboy.jpg"};

		int numero = new Random().nextInt(3);
		String sorteio = imagens[numero];
		return sorteio;
	}
	public String sorteioDeTelaPassageiro() {

		String imagens[] = {"figuras/passageiro.jpeg","figuras/passageiro1.jpg"};

		int numero = new Random().nextInt(2);
		String sorteio = imagens[numero];
		return sorteio;
	}
}


