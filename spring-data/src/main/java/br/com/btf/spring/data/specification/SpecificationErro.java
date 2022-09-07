package br.com.btf.spring.data.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.btf.spring.data.orm.Erro;

public class SpecificationErro {
	
	public static Specification<Erro> descricao(String descricao){
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("descricao"), "%" + descricao + "%");
	}

}
