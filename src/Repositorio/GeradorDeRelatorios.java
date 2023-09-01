package Repositorio;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entity.ValorCreditos;
import entity.usuario.MotoTaxista;
import entity.usuario.Passageiro;
import entity.usuario.Usuario;

public class GeradorDeRelatorios {


	public static void gerarBoleto(int quantidadeCreditos, double valor) {
		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);

		try {

			Paragraph linhaEmBranco = new Paragraph("                                     ");

			PdfWriter.getInstance(doc, new FileOutputStream("Boleto.pdf"));
			doc.open();

			Paragraph nome = new Paragraph("Monteiro_Motos_Boleto_De_Pagamento");
			nome.setAlignment(Element.ALIGN_LEFT);

			Paragraph agencia = new Paragraph("00000.00000 00000.00000 00000.00000 0 0000");
			agencia.setAlignment(Element.ALIGN_LEFT);

			LocalDate dataHoje = LocalDate.now();
			Paragraph txtData = new Paragraph("Data da compra");
			Paragraph data = new Paragraph(
					dataHoje.getDayOfMonth() + "/" + dataHoje.getMonthValue() + "/" + dataHoje.getYear());

			Paragraph textoQuantidade = new Paragraph("Quantidade de créditos");
			Paragraph quantidade = new Paragraph("" + quantidadeCreditos);

			Paragraph textoValor = new Paragraph("Valor total");
			Paragraph valorTotal = new Paragraph("" + valor);

			doc.add(nome);
			doc.add(agencia);
			doc.add(linhaEmBranco);
			doc.add(linhaEmBranco);
			doc.add(txtData);
			doc.add(data);
			doc.add(textoQuantidade);
			doc.add(quantidade);
			doc.add(textoValor);
			doc.add(valorTotal);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}

	}

	public static void gerarRelatorioDeCompras(String nomeMototax, int quantidadeCreditos, Double valor) {

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();

		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);

		try {
			Paragraph linhaEmBranco = new Paragraph("                                     ");

			PdfWriter.getInstance(doc, new FileOutputStream("relatorio.pdf"));
			doc.open();

			Paragraph nome = new Paragraph("Relatorio de Compras");
			nome.setAlignment(Element.ALIGN_LEFT);

			Paragraph agencia = new Paragraph("Listacoes de Dos Creditos!");
			agencia.setAlignment(Element.ALIGN_RIGHT);

			LocalDate dataAtual = LocalDate.now();
			Paragraph textoData = new Paragraph("Data da compra");
			Paragraph data = new Paragraph(
					dataAtual.getDayOfMonth() + "/" + dataAtual.getMonthValue() + "/" + dataAtual.getYear());

			Paragraph txtNomes = null;
			Paragraph motoNomes = null;

			Paragraph txtQuantis = null;
			Paragraph credts = null;

			Paragraph txtValor = null;
			Paragraph valors = null;

			Paragraph txtData = null;
			Paragraph dats = null;
			
			ArrayList<ValorCreditos> comprados = central.getCreditosComprados();
			ArrayList<Usuario> listagem = central.getTodosOsUsuarios();
			
			for(int i = 0; i < comprados.size();i++) {
				txtNomes = new Paragraph("Nome do MotoTax: ");
				motoNomes = new Paragraph(comprados.get(i).getMotoTax().getNome());
				

				txtQuantis = new Paragraph("Quantidade De Creditos: ");
				credts = new Paragraph("" + comprados.get(i).getMotoTax().getCreditos());
					
					
				txtValor = new Paragraph("Valor Todal: ");
				valors = new Paragraph("" + comprados.get(i).getValorCreditos());

				txtData = new Paragraph("DAta de Compra: ");
				dats = new Paragraph(
						dataAtual.getDayOfMonth() + "/" + dataAtual.getMonthValue() + "/" + dataAtual.getYear());
				Paragraph divisoria = new Paragraph("------------------------------------------------------------------");
				nome.setAlignment(Element.ALIGN_LEFT);

				doc.add(txtNomes);
				doc.add(motoNomes);
				doc.add(txtQuantis);
				doc.add(credts);
				doc.add(txtValor);
				doc.add(valors);
				doc.add(txtData);
				doc.add(dats);
				doc.add(divisoria);
					
			}

			
//			for (int i = 0; i < listagem.size(); i++) {
//				if (listagem.get(i).getClass().equals(MotoTaxista.class)) {
//
//					txtNomes = new Paragraph("Nome do MotoTax: ");
//					motoNomes = new Paragraph(listagem.get(i).getNome());
//
//					txtQuantis = new Paragraph("Quantidade De Creditos: ");
//					credts = new Paragraph("" + listagem.get(i).getCreditos());
//
//					txtValor = new Paragraph("Valor Todal: ");
//					valors = new Paragraph("" + valor);
//
//					txtData = new Paragraph("DAta de Compra: ");
//					dats = new Paragraph(
//							dataAtual.getDayOfMonth() + "/" + dataAtual.getMonthValue() + "/" + dataAtual.getYear());
//					Paragraph divisoria = new Paragraph("------------------------------------------------------------------");
//					nome.setAlignment(Element.ALIGN_LEFT);
//
//					doc.add(txtNomes);
//					doc.add(motoNomes);
//					doc.add(txtQuantis);
//					doc.add(credts);
//					doc.add(txtValor);
//					doc.add(valors);
//					doc.add(txtData);
//					doc.add(dats);
//					doc.add(divisoria);
//				}
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}

	}


}