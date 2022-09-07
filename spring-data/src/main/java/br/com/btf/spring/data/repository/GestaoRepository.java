package br.com.btf.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.btf.spring.data.orm.Gestao;

@Repository
public interface GestaoRepository extends CrudRepository<Gestao, Integer> {
	List<Gestao> findByLider(String lider);

}
