package entity.usuario.validador;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.usuario.Usuario;
import entity.usuario.Exception.EmailNaoPossuiDominioException;
import entity.usuario.Exception.NomeComApernasNumerosException;
import entity.usuario.Exception.SenhaComEspacoEmBranco;
import entity.usuario.Exception.SenhaSemLetraMaisculaException;
import entity.usuario.Exception.SenhaSemLetraMinusculaException;

public class ValidacaoDeCadastroDeUsuario {

	public void validarEmail(Usuario usuario) throws EmailNaoPossuiDominioException {

		if (!usuario.getEmail().contains("@")) {
			throw new EmailNaoPossuiDominioException();
			
		}
		if (!usuario.getEmail().contains(".com")) {
			throw new EmailNaoPossuiDominioException();
		}

	}
	
	public static boolean validarEmailCodSeguranca(String email){
		if (email.isEmpty());
		       System.out.println("email invalido");

		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		boolean valido = matcher.matches() && email.contains("gmail.com");
		if (!valido)
			return false;
		return true;
	}

	public void validarSenha(Usuario usuario) throws SenhaSemLetraMaisculaException,SenhaSemLetraMinusculaException,SenhaComEspacoEmBranco {

		if (!temLetraMaiuscula(usuario.getSenha())) {
			throw new SenhaSemLetraMaisculaException();
		}
		if (!temLetraMinuscula(usuario.getSenha())) {
			throw new SenhaSemLetraMaisculaException();
		}
		if (usuario.getSenha().contains(" ")) {
			throw new SenhaComEspacoEmBranco();
		}
	}
	
	public void validarNome(Usuario usuario) throws NomeComApernasNumerosException {
		
		if(isNumber(usuario)) {
			throw new NomeComApernasNumerosException();
		}
		
	}
	
	public boolean isNumber(Usuario usuario) {

		try {
			Integer.parseInt(usuario.getNome());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean temLetraMaiuscula(String senha) {

		for (int i = 0; i < senha.length(); i++) {
			if (Character.isUpperCase(senha.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean temLetraMinuscula(String senha) {

		for (int i = 0; i < senha.length(); i++) {
			if (Character.isLowerCase(senha.charAt(i))) {
				return true;
			}
		}
		return false;
	}
}
