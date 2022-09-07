package br.com.btf.spring.data.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.btf.spring.data.orm.Erro;
import br.com.btf.spring.data.orm.Gestao;
import br.com.btf.spring.data.orm.Registro;
import br.com.btf.spring.data.repository.ErroRepository;
import br.com.btf.spring.data.repository.GestaoRepository;
import br.com.btf.spring.data.repository.RegistroRepository;

@Service
public class CrudRegistroService {
	
	private RegistroRepository registroRepository;
	private GestaoRepository gestaoRepository;
	private ErroRepository erroRepository;

	private Boolean system = true;
	
	public CrudRegistroService(RegistroRepository registroRepository, GestaoRepository gestaoRepository, ErroRepository erroRepository) {
		this.registroRepository = registroRepository;
		this.gestaoRepository = gestaoRepository;
		this.erroRepository = erroRepository;
	}
	
	public void iniciar(Scanner scanner) {
		while(system) {
			System.out.println("Registro de ocorrencias AMI");
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
				listar();
//				registro.forEach(r -> System.out.println(r));
				break;
			}
			default:
				System.out.println("Unexpected value: " + action + ". Try again.");
			}
			
		}
		
	}
	
	public void salvar(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite a data da ocorrencia");
		String data = scanner.nextLine();
		LocalDate localDate = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("Digite o modelo da escada:");
		String modelo = scanner.nextLine();
		
		System.out.println("Digite o tempo de parada:");
		String time = scanner.nextLine();
		Time tempo = Time.valueOf(time);
		
		System.out.println("Digite o código de erro:");
		Integer e = scanner.nextInt();
		Erro erro = erroRepository.findById(e).get();
		scanner.nextLine();
		
		System.out.println("Digite as observações da parada:");
		String obs = scanner.nextLine();
		
		System.out.println("Digite o líder do turno:");
		String l = scanner.nextLine();
		Gestao lider = gestaoRepository.findByLider(l).get(0);
		
		Registro reg = new Registro(localDate, modelo, tempo, erro, obs, lider);
		registroRepository.save(reg);
		
	}
	
	public void atualizar(Scanner scanner) {
		
	}
	public void deletar(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Digite a ocorrencia da parada");
		Integer id = scanner.nextInt();
		registroRepository.deleteById(id);
	}
	public void listar(){
		Iterable<Registro> registros = registroRepository.findAll();
		registros.forEach(r -> System.out.println(r));
		
	}

}
