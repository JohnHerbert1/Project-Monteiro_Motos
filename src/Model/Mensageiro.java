package Model;


import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

import entity.usuario.MotoTaxista;


public class Mensageiro {

	public static int enviarEmailComCodigoDeVerificacao(String emailDeCodigo) {
		String remetente = "projetomonteiromotos2022@gmail.com";
		String senha = "zraigxiwmwshajwy";

		int min = 1234;
		int max = 9999;

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("C�digo para mudan�a de senha.");
			int codigo = new Random().nextInt((max - min) + 1) + min;
			email.setMsg("Seu c�digo �: " + codigo);
			email.addTo(emailDeCodigo);
			email.send();

			return codigo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}