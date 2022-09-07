package br.com.btf.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gestao")
public class Gestao {
	
	@Override
	public String toString() {
		return "Gestao [id=" + id + ", lider=" + lider + ", turno=" + turno + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String lider;
	private String turno;
	
	public Gestao() {}

	public Gestao(String lider, String turno) {
		this.lider = lider;
		this.turno = turno;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}
	
}
