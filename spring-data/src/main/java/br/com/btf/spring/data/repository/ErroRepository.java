package br.com.btf.spring.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.btf.spring.data.orm.Erro;

@Repository
public interface ErroRepository extends PagingAndSortingRepository<Erro, Integer>, JpaSpecificationExecutor<Erro> {
	List<Erro> findByNatureza(String natureza, Pageable page);
	
	
}
