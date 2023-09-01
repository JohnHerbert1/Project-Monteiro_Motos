package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Enum.DataDaCorrida;
import Enum.StatusDaCorrida;
import Repositorio.CentralDeInformacoes;
import Repositorio.Persistencia;
import Telas.TelaSolicitarCorrida;
import Telas.menu.passageiro.TelaMenuPassageiro;
import entity.Corrida;
import entity.usuario.Passageiro;
import entity.usuario.Usuario;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemUsuario;
//RYAN PASSOU AQUI
public class OuvinteTelaSolicitarCorridas implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral();

	private TelaSolicitarCorrida telaSolicitarCorrida;

	public TelaSolicitarCorrida getTelaSolicitarCorrida(TelaSolicitarCorrida telaSolicitarCorrida) {
		return telaSolicitarCorrida;
	}

	public OuvinteTelaSolicitarCorridas(TelaSolicitarCorrida tela) {
		this.telaSolicitarCorrida = tela;
	}

	public void actionPerformed(ActionEvent e) {
		try {

			String partida = telaSolicitarCorrida.getPontoDePartida().getText();
			String destino = telaSolicitarCorrida.getDestino().getText();

			StatusDaCorrida status = StatusDaCorrida.PENDENTE;
			if (partida.equals(destino)) {
				MensagemUsuario.lugaresIguais();
			} else if (partida.isBlank() || destino.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {
				Persistencia persistencia = new Persistencia();
				CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
				Usuario b = new Usuario();
				b.setEstaAtivo(true);

				for (int i = 0; i < centralDeInformacoes.getTodosOsUsuarios().size(); i++) {
					if (centralDeInformacoes.getTodosOsUsuarios().get(i).isEstaAtivo()) {
						b = centralDeInformacoes.getTodosOsUsuarios().get(i);
					}
				}
				Passageiro a = (Passageiro) b;
				Corrida corrida = new Corrida(partida, destino,a, status);
				central.adicionarCorrida(corrida);
				if (telaSolicitarCorrida.getHoraDaCorrida().isSelected()) {
					corrida.setHora(DataDaCorrida.AGORA);
				}
				if (telaSolicitarCorrida.getHoraDaCorridaDepois().isSelected()) {
					corrida.setHora(DataDaCorrida.DEPOIS);
				}
				persistencia.salvarCentral(central);
				MensagemUsuario.usuarioSalvo();
				telaSolicitarCorrida.dispose();
				new TelaMenuPassageiro(null);
			}
		} catch (NullPointerException erro) {
			MensagemException.nullPointerException(erro);

		}
	}

	public void actionPerformedVoltar(ActionEvent ev) {
		telaSolicitarCorrida.dispose();
		new TelaMenuPassageiro(null);
	}

}
