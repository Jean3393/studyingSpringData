package br.com.btf.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "erros")
public class Erro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "codigo_erro")
	private Integer codigoErro;
	private String descricao;
	private String natureza;
	private String subconjunto;
	private String estacao;
	
	public Erro() {}
	
	public Erro(String descricao, String natureza, String subconjunto, String estacao) {
		this.descricao = descricao;
		this.natureza = natureza;
		this.subconjunto = subconjunto;
		this.estacao = estacao;
	}

	public Integer getCodigoErro() {
		return codigoErro;
	}
	public void setCodigoErro(Integer codigoErro) {
		this.codigoErro = codigoErro;
	}
	public String getDescricao() {
		return descricao;
	}
	@Override
	public String toString() {
		return "Erro [codigoErro=" + codigoErro + ", descricao=" + descricao + ", natureza=" + natureza
				+ ", subconjunto=" + subconjunto + ", estacao=" + estacao + "]";
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNatureza() {
		return natureza;
	}
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	public String getSubconjunto() {
		return subconjunto;
	}
	public void setSubconjunto(String subconjunto) {
		this.subconjunto = subconjunto;
	}
	public String getEstacao() {
		return estacao;
	}
	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	
	

}
