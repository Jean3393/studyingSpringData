package br.com.btf.spring.data.orm;

import java.sql.Time;
import java.time.LocalDate;

public interface RegistroProjection {
	
	LocalDate getDataOcorrencia();
	Time getTempoDeParada();
	Erro getCodigoErro();

}
