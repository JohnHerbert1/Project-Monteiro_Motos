package entity;

import Enum.DataDaCorrida;
import Enum.StatusDaCorrida;
import entity.usuario.Passageiro;
//RYAN PASSOU AQUI
public class Corrida {

	private long id;
	private String enderecoDePartida;
	private String enderecoDeDestino;
	private int totalDeCorridas;
	private Passageiro passageiro;
	private StatusDaCorrida status;
	private DataDaCorrida hora;

	public Corrida(String enderecoDePartida, String enderecoDeDestino,Passageiro p,StatusDaCorrida status) {
		this.id = System.currentTimeMillis();
		this.enderecoDePartida = enderecoDePartida;
		this.enderecoDeDestino = enderecoDeDestino;
		this.passageiro=p;
		this.status=status;
		//this.usuario=usuario;
		
		//this.hora=hora;
	}

	public String toString() {
		return "ID da corrida : " + id + "\nEndere�o de Partida : " + enderecoDePartida + "\nEndere�o de Destino : "
				+ enderecoDeDestino + "\nStatus : " + status;
	}
	
	public String corridaReinvindicadaComSucesso() {
		//setStatus(StatusDaCorrida.ANDAMENTO);
		return "Corrida de ID : " + id + "Reinvindicada com sucesso!";
		}

	public StatusDaCorrida getStatus() {
		return status;
	}

	public void setStatus(StatusDaCorrida status) {
		this.status = status;
	}

	public int getTotalDeCorridas() {
		return totalDeCorridas;
	}

	public void setTotalDeCorridas(int totalDeCorridas) {
		this.totalDeCorridas = totalDeCorridas;
	}

	public String getEnderecoDePartida() {
		return enderecoDePartida;
	}

	public void setEnderecoDePartida(String enderecoDePartida) {
		this.enderecoDePartida = enderecoDePartida;
	}

	public String getEnderecoDeDestino() {
		return enderecoDeDestino;
	}

	public void setEnderecoDeDestino(String enderecoDeDestino) {
		this.enderecoDeDestino = enderecoDeDestino;
	}
	
	



	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public long getId() {
		return id;
	}

	public String detalhes() {
		return "ID da corrida : " + id + "\nEndere�o de Partida : " + enderecoDePartida + "\nEndere�o de Destino : "
				+ enderecoDeDestino + "\nStatus : " + status;
	}

	public DataDaCorrida getHora() {
		return hora;
	}

	public void setHora(DataDaCorrida hora) {
		this.hora = hora;
	}
	

}
