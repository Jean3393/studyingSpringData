package br.com.btf.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.btf.spring.data.orm.Registro;
import br.com.btf.spring.data.orm.RegistroProjection;

@Repository
public interface RegistroRepository extends CrudRepository<Registro, Integer> {
	@Query("SELECT r FROM Registro r WHERE r.turno.lider = :lider")
	List<Registro> findByNameLider(String lider);
	
	@Query(value="SELECT r.data_ocorrencia, r.tempo_de_parada r.codigo_erro FROM registros r WHERE r.modelo = :modelo", nativeQuery=true)
	List<RegistroProjection> findRegistro(String modelo);
}
