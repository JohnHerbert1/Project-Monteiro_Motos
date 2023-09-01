package Repositorio;

import java.util.ArrayList;

import Enum.AcessoTips;
import entity.Corrida;
import entity.ValorCreditos;
import entity.usuario.Admistrador;
import entity.usuario.MotoTaxista;
import entity.usuario.Passageiro;
import entity.usuario.Usuario;

public class CentralDeInformacoes {
//	VOU CRIAR DUAS ARRYS PRA ALOCADA DE PASSAGEIRO E MOTOTAXI E ADM-------------
	
// N�O SEI SE SERA NESSESARIO USAR ESTAS ARRYLIST, MAIS AS DEIXARI AQUI CASO SEJA DE USO
// ----------------------------------------------------------------------------	
	private ArrayList<ValorCreditos> creditosComprados = new ArrayList<>();
	private ArrayList<Corrida> todosAsCorridas = new ArrayList<>();
	private ArrayList<Usuario> todosOsUsuarios = new ArrayList<>(); // FOI COLOCADO PRA RECEBER A EDI��O----
	

	private double creditos;// ESSE CREDITOS AQUI SAO PRA QUE? E PRA O ADM DEFINILOS EM TEROS DE VALOR AO COMPRALO ?
		//A INDA VOU VER FORMAS DIFERENTES: USANDO O stancOF or ENUM--------------
	public boolean adicionarUsers(Usuario user,String tipos) {// AQUI ESTOU TENTANDO ADICIONAR USANDO POLIMORFISMO DE ACORDO COM SEU TIPO ELE CADASTRA A SUB CLASS----
		
		boolean entrouUsuario = false;
	
		switch (tipos) {
		case "Administrador": 
			user = new Admistrador(user.getNome(),user.getEmail(),user.getSenha(),AcessoTips.ACESSO_PERMITIDO,false,0);
			if(user instanceof Admistrador) {
				for(int i = 0 ; i < todosOsUsuarios.size(); i++) {
					if(todosOsUsuarios.get(i).getNome().equals(user.getNome())) {
						entrouUsuario = false;
					}
				}
				entrouUsuario = true;
				todosOsUsuarios.add(user);
			}
			break;
			
		case "MotoTax":
			user = new MotoTaxista(user.getNome(),user.getEmail(),user.getSenha(),AcessoTips.ACESSO_PERMITIDO,false,0);
			if(user instanceof MotoTaxista) {
				for(int i = 0 ; i < todosOsUsuarios.size(); i++) {
					if(todosOsUsuarios.get(i).getNome().equals(user.getNome())) {
						entrouUsuario = false;
					}
				}
					
				entrouUsuario = true;
				todosOsUsuarios.add(user);
			}
			break;
			
		case "Passageiro":	
			user = new Passageiro(user.getNome(), user.getEmail(),user.getSenha(),false,AcessoTips.ACESSO_PERMITIDO,0);
			if(user instanceof Passageiro){
				for(int i = 0 ; i < todosOsUsuarios.size(); i++) {
					if(todosOsUsuarios.get(i).getNome().equals(user.getNome())) {
						entrouUsuario = false;
					}
				}
				
				entrouUsuario = true;
				todosOsUsuarios.add(user);
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipos);
		}
		return entrouUsuario;
		
		//if(tipos == TipoDeUsuario.ADMINISTRADOR) {
		//if(tipos == TipoDeUsuario.MOTOTAXISTA) {
		//if(tipos == TipoDeUsuario.PASSAGEIRO ) {
	}// VOU VER UMA MELHOR MANEIRA DE ADERIR UM METODO ASSIM: VERIFICAR SE REALMENTE E PRECISSO EXISTIR UMA CLASS ADM JA QUE VAMOS DEFINIR O TIPO COM ENUM.
	//------------------------------------------------------------------------------------------------------------------------------------------------------ |
	
	public Usuario deslogarTela() {
		Usuario u;
		
		for(int i = 0; i< todosOsUsuarios.size();i++) {
			if(todosOsUsuarios.get(i).isEstaAtivo() == true) {
			  return u = todosOsUsuarios.get(i);
			}
			
		}
		return null;
	}
	
	public Usuario estaAtivo (Usuario metodo, String Email) {// ESSE METODO VAI EDITAR OS ESTADOS DO USUARIO PRA APTALO COMO TRUE PRA ALGUMAS COISAS ---;
	Usuario	u = userLogado(Email);
		
		if(entradaClass(metodo,Email) != null) {
			u.setEstaAtivo(true);
			}
		return u;
	}
	
	public void estaDesativado() {
		
		for(int i = 0; i < todosOsUsuarios.size();i++) {
			if(todosOsUsuarios.get(i).isEstaAtivo() == true) {
				todosOsUsuarios.get(i).setEstaAtivo(false);
				break;
			}
		}
	}
	
	public void funcaoEdicao(ArrayList<String> optiList,String nome, String E_mail,String senha) {
		
//		 Usuario user = userLogado(entrada);
	for(int i = 0; i< todosOsUsuarios.size();i++) {
		if(todosOsUsuarios.get(i).isEstaAtivo() == true) {	
	
		if(optiList.contains("1")) {
//			user.setNome(nome);
			todosOsUsuarios.get(i).setNome(nome);
		}
		if(optiList.contains("2")) {
//			user.setEmail(E_mail);
			todosOsUsuarios.get(i).setEmail(E_mail);
		}
		if(optiList.contains("3")) {
//			user.setSenha(senha);
			todosOsUsuarios.get(i).setSenha(senha);
		}
		}
	}
//		return user;
	}
	
	public Usuario entradaClass(Usuario u, String email) {// this is Method was create for final type user -------------------
		
		for(int i = 0; i < getTodosOsUsuarios().size(); i++) {
			if(todosOsUsuarios.get(i).getEmail().equals(email)) {
				if(todosOsUsuarios.get(i).getClass().equals(Admistrador.class)) {
					//u = new Admistrador(u.getNome(),u.getEmail(),u.getSenha(),Sexo.MASCULINO,TipoDeUsuario.ADMINISTRADOR,u.isEstaAtivo());
					u =	todosOsUsuarios.get(i);
				}
				if(todosOsUsuarios.get(i).getEmail().equals(email)) {
					if(todosOsUsuarios.get(i).getClass().equals(Passageiro.class)) {
//						u = new Passageiro();
					u = todosOsUsuarios.get(i);	

					}
				if(todosOsUsuarios.get(i).getEmail().equals(email)) {
					if(todosOsUsuarios.get(i).getClass().equals(MotoTaxista.class)) {
//						u = new MotoTaxista();
						u = todosOsUsuarios.get(i);
					}
				}
				}
			}
		}
		return u;
	}
	
	// AQUI EU ADICIONO OS CREDITOS COMPRADOS:
	public boolean adicionarCompraCreditos(ValorCreditos v) {
		for(int i = 0; i < creditosComprados.size();i++) {
			if(creditosComprados.get(i) == null) {
				return false;
			}
		}
		this.creditosComprados.add(v);
		return true;
		
	}
	
	
	// METOD DE RECUPERAR OS CREDITOS COMPRADOS: 
	public ValorCreditos recuperarCreditosDeCompra(String email){
		
		for(int i = 0; i < creditosComprados.size(); i++) {
			if(creditosComprados.get(i).getMotoTax().getEmail().equals(email)) {
				return creditosComprados.get(i);
			}
		}
		return null;
		
	}

//	public boolean salvarUsuario(Usuario usuario) {
//		for (int i = 0; i < todosOsUsuarios.size(); i++) {
//			if (todosOsUsuarios.get(i).getNome().equals(usuario.getNome())) {
//				return false;
//			}
//		}
//		todosOsUsuarios.add(usuario);
//		return true;
//	}
//
//	public boolean adicionarPassageiro(Passageiro p) {
//
//		Passageiro passageiro = this.recuperarPassageiro(p.getEmail());
//
//		if (passageiro != null) {
//			return false;
//		}
//		this.todosOsPassageiros.add(p);
//		return true;
//	}
//
//	public Passageiro recuperarPassageiro(String email) {
//		for (int i = 0; i < todosOsPassageiros.size(); i++) {
//			if (todosOsPassageiros.get(i).getEmail().equals(email)) {
//				return todosOsPassageiros.get(i);
//			}
//		}
//		return null;

	//RYAN PASSOU AQUI
		public ArrayList<Corrida> recuperarCorridaDeUmPassageiro(String email){
			ArrayList<Corrida> passageiroCorridas = new ArrayList<Corrida>();
			for(int i = 0; i < todosAsCorridas.size(); i++) {
				if(todosAsCorridas.get(i).getPassageiro().getEmail().equals(email)) {
					passageiroCorridas.add(todosAsCorridas.get(i));				
				}
			}return passageiroCorridas;
		}

	
	public boolean adicionarCorrida(Corrida c) {

		Corrida corrida = this.recuperarCorridaPeloId(c.getId());

		if (corrida != null) {
			return false;
		}
		this.todosAsCorridas.add(c);
		return true;

	}

	public Corrida recuperarCorridaPeloId(long id) {
		for (int i = 0; i < todosAsCorridas.size(); i++) {
			if (todosAsCorridas.get(i).getId() == id) {
				return todosAsCorridas.get(i);
			}
		}
		return null;
	}

	
	
	public Usuario userLogado(String eMaiString) {
		
		for(int i = 0; i < todosOsUsuarios.size();i++) {
			if (todosOsUsuarios.get(i).getEmail().equals(eMaiString)) {
				return todosOsUsuarios.get(i);
			}
		}
		return null;
	}
	
	public Usuario recuperarUsuario(String nome) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getNome().equals(nome)) {
				return todosOsUsuarios.get(i);
			}
		}
		return null;
	}
	public boolean isLogin(String email, String senha) {
		for (int i = 0; i < todosOsUsuarios.size() ; i++) {
			if (todosOsUsuarios.get(i).getEmail().equals(email) && todosOsUsuarios.get(i).getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	
	public void editorDeCreditos(int quantidadeSetada) {// NESSE METODO VOU VERIFICAR S� E UM MOTOTAXISTA E MUDAR OS CREDITOS DELE //-----------------------//
		 
		for(int i = 0; i < todosOsUsuarios.size(); i++) {
			if(todosOsUsuarios.get(i).isEstaAtivo() == true) {
				if(todosOsUsuarios.get(i).getClass().equals(MotoTaxista.class)) {
					todosOsUsuarios.get(i).setCreditos(quantidadeSetada);
					break;
				// LEMBRAR DE AJEITA O CODIGO JOHN
			}
			}
		}
		
		
	}
	
	public void decresimoDeCreditos() {
		
		for(int i = 0; i < todosOsUsuarios.size(); i++) {
			if(todosOsUsuarios.get(i).isEstaAtivo() == true) {
				if(todosOsUsuarios.get(i).getClass().equals(MotoTaxista.class)) {
					todosOsUsuarios.get(i).decresimos();
					break;
				}
				}
				
				}
		
	}
	

	public ArrayList<Corrida> getTodosAsCorridas() {
		return todosAsCorridas;
	}

	public void setTodosAsCorridas(ArrayList<Corrida> todosAsCorridas) {
		this.todosAsCorridas = todosAsCorridas;
	}

	
	public ArrayList<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}

	public void setTodosOsUsuarios(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}



	public double getCreditos() {
		return creditos;
	}


	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	
	public String toString() {
		return "Minhas corridas : " + getTodosAsCorridas();
	}

	public ArrayList<ValorCreditos> getCreditosComprados() {
		return creditosComprados;
	}

	public void setCreditosComprados(ArrayList<ValorCreditos> creditosComprados) {
		this.creditosComprados = creditosComprados;
	}
	

}
