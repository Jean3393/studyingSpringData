package br.com.btf.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.btf.spring.data.orm.Gestao;
import br.com.btf.spring.data.repository.GestaoRepository;

@Service
public class CrudGestaoService {
	
	private GestaoRepository gestaoRepository;
	private Boolean system = true;
	
	public CrudGestaoService(GestaoRepository gestaoRepository) {
		this.gestaoRepository = gestaoRepository;
	}
	
	public void iniciar(Scanner scanner) {
		while(system) {
			System.out.println("Gestao AMI");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Deletar");
			System.out.println("4 - Listar");
			
			Integer action = scanner.nextInt();
			switch (action) {
			case 0: {
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
			case 3: {
				deletar(scanner);
				break;
			}
			case 4: {
				Iterable<Gestao> gestao = listar(scanner);
				gestao.forEach(g -> System.out.println(g));
				break;
			}
			default:
				System.out.println("Unexpected value: " + action + ". Try again.");
			}
			
		}
		
	}
	
	public void salvar(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite");
	}
	
	public void atualizar(Scanner scanner) {
		
	}
	public void deletar(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite o id do lider do turno");
		Integer id = scanner.nextInt();
		gestaoRepository.deleteById(id);
	}
	public Iterable<Gestao> listar(Scanner scanner){
		return gestaoRepository.findAll();
	}
	

}
