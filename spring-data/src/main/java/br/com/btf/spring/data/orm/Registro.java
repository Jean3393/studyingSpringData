package br.com.btf.spring.data.orm;


import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="registros")
public class Registro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ocorrencia;
	@JoinColumn(name = "data_ocorrencia")
	private LocalDate dataOcorrencia;
	private String modelo;
	@JoinColumn(name = "tempo_de_parada")
	private Time tempoDeParada;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="codigo_erro")
	private Erro codigoErro;
	private String observacoes;
	@ManyToOne(fetch = FetchType.LAZY)
	private Gestao turno;
	
	public Registro() {}

	public Registro(LocalDate dataOcorrencia, String modelo, Time tempoDeParada, Erro codigoErro, String observacoes,
			Gestao turno) {
		this.dataOcorrencia = dataOcorrencia;
		this.modelo = modelo;
		this.tempoDeParada = tempoDeParada;
		this.codigoErro = codigoErro;
		this.observacoes = observacoes;
		this.turno = turno;
	}

	public Registro(LocalDate dataOcorrencia, String modelo, Time tempoDeParada, Erro codigoErro, Gestao turno) {
		this.dataOcorrencia = dataOcorrencia;
		this.modelo = modelo;
		this.tempoDeParada = tempoDeParada;
		this.codigoErro = codigoErro;
		this.turno = turno;
	}
	
	@Override
	public String toString() {
		return "Registro [ocorrencia=" + ocorrencia + ", dataOcorrencia=" + dataOcorrencia + ", modelo=" + modelo
				+ ", tempoDeParada=" + tempoDeParada + ", codigoErro=" + codigoErro.getCodigoErro() + ", observacoes=" + observacoes
				+ ", turno=" + turno.getId() + "]";
	}

	public Integer getOcorrencia() {
		return ocorrencia;
	}

	public LocalDate getDataOcorrencia() {
		return dataOcorrencia;
	}

	public String getModelo() {
		return modelo;
	}

	public Time getTempoDeParada() {
		return tempoDeParada;
	}

	public Integer getCodigoErro() {
		return codigoErro.getCodigoErro();
	}

	public String getObservacoes() {
		return observacoes;
	}

	public String getTurno() {
		return turno.getLider();
	}

}
