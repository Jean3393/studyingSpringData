package br.com.btf.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.btf.spring.data.orm.Erro;
import br.com.btf.spring.data.orm.Registro;
import br.com.btf.spring.data.repository.ErroRepository;
import br.com.btf.spring.data.repository.RegistroRepository;

@Service
public class RelatoriosService {
	
	private ErroRepository erroRepository;
	private RegistroRepository registroRepository;
	private Boolean system = true;
	
	public RelatoriosService(ErroRepository erroRepository, RegistroRepository registroRepository) {
		this.erroRepository = erroRepository;
		this.registroRepository = registroRepository;
	}
	
	public void iniciar(Scanner scanner) {
		while(system) {
			System.out.println("Relatórios de busca");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca erro por natureza");
			System.out.println("2 - Busca registro por lider");
			
			Integer action = scanner.nextInt();
			switch (action) {
			case 0: {
				system = false;
				break;
			}
			case 1: {
				erroPorNatureza(scanner);
				break;
			}
			case 2: {
				registroPorLider(scanner);
				break;
			}
			default:
				System.out.println("Unexpected value: " + action + ". Try again.");
			}
			
		}
	}
	
	private void erroPorNatureza(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite a natureza do erro");
		String natureza = scanner.nextLine();
		Pageable page = PageRequest.of(1, 5);
		
		List<Erro> lista = erroRepository.findByNatureza(natureza, page);
		lista.forEach(System.out::println);
	}
	
	private void registroPorLider(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite o nome do lider:");
		String lider = scanner.nextLine();
		
		List<Registro> lista = registroRepository.findByNameLider(lider);
		lista.forEach(System.out::println);
	}

}
