package br.com.btf.spring.data.service;

import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.btf.spring.data.orm.Erro;
import br.com.btf.spring.data.repository.ErroRepository;

@Service
public class CrudErroService {
	
	private final ErroRepository erroRepository;
	private boolean system = true;
	
	public CrudErroService(ErroRepository erroRepository) {
		this.erroRepository = erroRepository;
	}
	
	public void iniciar(Scanner scanner) {
		while(system) {
			System.out.println("Erros de máquina");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Deletar");
			System.out.println("4 - Listar");
			
			Integer action = scanner.nextInt();
			
			switch (action) {
			
				case 0:	{
					system = false;
					break;
				}
			
				case 1: {
					salvar(scanner);
					break;
				}
				case 2: {
					atualizar(scanner);
					break;
				}
				case 3:{
					deletar(scanner);
					break;
				}
				case 4: {
					listar(scanner);
					break;
				}
				default:
					System.out.println("Unexpected value: " + action + ". Try again.");
			}
		}
			
	}
	
	private void salvar(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite a descricao do erro:");
		String descricao = scanner.nextLine();
		System.out.println("Digite a natureza do erro:");
		String natureza = scanner.nextLine();
		System.out.println("Digite o subconjunto do erro:");
		String subconjunto = scanner.nextLine();
		System.out.println("Digite a estacao do erro:");
		String estacao = scanner.nextLine();
		
		Erro erro = new Erro(descricao, natureza, subconjunto, estacao);
		this.erroRepository.save(erro);
		System.out.println("Salvo");
	}

	public void atualizar(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite o codigo do erro:");
		Integer codigo = scanner.nextInt();
		scanner.nextLine();
		Erro erro = erroRepository.findById(codigo).get();
		System.out.println(erro);
		System.out.println("Atualizar a descricao");
		String descricao = scanner.nextLine();
		erro.setDescricao(descricao);
		erroRepository.save(erro);
		System.out.println("Atualizado");
		
	}
	
	public void deletar(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite o codigo do erro:");
		Integer codigo = scanner.nextInt();
		erroRepository.deleteById(codigo);
		System.out.println("Deletado");
	}
	
	public void listar(Scanner scanner) {
		System.out.println("Qual pagina deseja visualizar: ");
		Integer pagina = scanner.nextInt();
		
		Pageable page = PageRequest.of(pagina-1, 10, Sort.unsorted());
		Page<Erro> erros = erroRepository.findAll(page);
		
		erros.forEach(e -> System.out.println(e));
		System.out.println("Page " + (page.getPageNumber()+1) + " out of "+erros.getTotalPages());
	}

}
