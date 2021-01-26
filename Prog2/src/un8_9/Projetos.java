package un8_9;

import java.util.*;
import java.text.*;
import javax.swing.JOptionPane;

public class Projetos {
	// Atributos da Classe
	private int idProjeto;
	private String vDescricao;
	private String dDataInicio, dDataFinal;
	private int nPercentual;
	private String vSituacao;
	private boolean bConsistencia;

	public Projetos() {
		setIdProjeto(0);
		setDescricao("");
		setDataInicio("01/01/2000");
		setDataFinal("01/01/2000");
		setPercentual(0);
		setSituacao("Em aberto");
		setConsistencia(false);
	}// Modifcadores

	public void setIdProjeto(int idProjeto) {
		if (idProjeto >= 0)
			this.idProjeto = idProjeto;
		else {
			this.idProjeto = -1;
			JOptionPane.showMessageDialog(null, "Código Incorreto.", "", JOptionPane.WARNING_MESSAGE);
			setConsistencia(false);
			return;
		}
		setConsistencia(true);
		;
	}

	public void setDescricao(String descricao) {
		if (descricao.length() > 0)
			vDescricao = descricao;
		else {
			vDescricao = "Anônimo";
			setConsistencia(false);
			return;
		}
		setConsistencia(true);
	}

	public void setDataInicio(String dataInicio) {
		if (DataCorreta(dataInicio))
			dDataInicio = dataInicio;
		else {
			DateFormat df = DateFormat.getDateInstance();
			dDataInicio = df.format(new Date());
		}
	}

	public void setDataFinal(String dataFinal) {
		if (DataCorreta(dataFinal))
			dDataFinal = dataFinal;
		else {
			DateFormat df = DateFormat.getDateInstance();
			dDataFinal = df.format(new Date());
		}
	}

	public void setPercentual(int percentual) {
		if (percentual >= 0)
			nPercentual = percentual;
		else {
			nPercentual = 0;
			JOptionPane.showMessageDialog(null, "Percentual Inválido.", "", JOptionPane.WARNING_MESSAGE);
			setConsistencia(false);
			return;
		}
		setConsistencia(true);
	}

	public void setSituacao(String situacao) {
		if (SituacaoCorreta(situacao))
			vSituacao = situacao;
		else {
			vSituacao = "Em aberto";
			JOptionPane.showMessageDialog(null, "Opção Inválida.", "", JOptionPane.WARNING_MESSAGE);
			setConsistencia(false);
			return;
		}
		setConsistencia(true);
	}

	public void setConsistencia(boolean consistencia) {
		bConsistencia = consistencia;
	}

	// Recuperadores
	public String getDataFinal() {
		return dDataFinal;
	}

	public String getDataInicio() {
		return dDataInicio;
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public int getPercentual() {
		return nPercentual;
	}

	public String getDescricao() {
		return vDescricao;
	}

	public String getSituacao() {
		return vSituacao;
	}

	public boolean getConsistencia() {
		return bConsistencia;
	}

	// ---- Regras de Negócio
	// Verifca se a data informada esta correta
	private boolean DataCorreta(String Data) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			Date d = sdf.parse(Data);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Formato incorreto " + Data, "", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	// Verifca se a situação esta dentro das opções válidas
	private boolean SituacaoCorreta(String opcao) {
		Vector opcoes = new Vector();
		opcoes.add("FINALIZADO");
		opcoes.add("EM ABERTO");
		opcoes.add("EM EXECUÇÃO");
		return opcoes.contains(opcao.toUpperCase());
	}

	// Realiza o cadastro dos dados do Projeto
	public void LeiaDados() {
		setIdProjeto(Integer.parseInt(JOptionPane.showInputDialog("Código do Projeto")));
		if (getConsistencia())
			setDescricao(JOptionPane.showInputDialog("Descrição do Projeto"));
		if (getConsistencia())
			setDataInicio(JOptionPane.showInputDialog("Data de Início do Projeto"));
		if (getConsistencia())
			setDataFinal(JOptionPane.showInputDialog("Data de Encerramento do Projeto"));
		if (getConsistencia())
			setPercentual(Integer.parseInt(JOptionPane.showInputDialog("Percentual do Projeto")));
		if (getConsistencia())
			setSituacao(JOptionPane.showInputDialog("Situação do Projeto"));
		if (!getConsistencia())
			JOptionPane.showMessageDialog(null, "Os dados não foram lidos!", "", JOptionPane.WARNING_MESSAGE);
	}

	// Realiza o cadastro dos dados, exceto o código do Projeto, que é
	// auto-incremento
	public void LeiaDados(boolean AUTO) {
		setDescricao(JOptionPane.showInputDialog("Descrição do Projeto"));
		if (getConsistencia())
			setDataInicio(JOptionPane.showInputDialog("Data de Início do Projeto"));
		if (getConsistencia())
			setDataFinal(JOptionPane.showInputDialog("Data de Encerramento do Projeto"));
		if (getConsistencia())
			setPercentual(Integer.parseInt(JOptionPane.showInputDialog("Percentual do Projeto")));
		if (getConsistencia())
			setSituacao(JOptionPane.showInputDialog("Situação do Projeto"));
		if (!getConsistencia())
			JOptionPane.showMessageDialog(null, "Os dados não foram lidos!", "", JOptionPane.WARNING_MESSAGE);
	}

	// Apresenta os dados cadastrados no Projeto
	public void ShowDados() {
		String Saida = "Projeto :" + getIdProjeto() + "\n Descricao :" + getDescricao() + "\n Iniciado em :"
				+ getDataInicio() + "\n Encerrado em:" + getDataFinal() + "\n Concluídos :" + getPercentual() + "%"
				+ "\n Situação :" + getSituacao();
		JOptionPane.showMessageDialog(null, Saida);
	}

	public Vector getCampos() {
		Vector Campos = new Vector();
		Campos.add("idProjetos");
		Campos.add("vDescricao");
		Campos.add("dDataInicio");
		Campos.add("dDataFinal");
		Campos.add("nPercConcluido");
		Campos.add("vSituacao");
		return Campos;
	}
}