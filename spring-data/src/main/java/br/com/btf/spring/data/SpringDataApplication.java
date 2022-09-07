package br.com.btf.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.btf.spring.data.service.CrudRegistroService;
import br.com.btf.spring.data.service.RelatoriosService;
import br.com.btf.spring.data.repository.GestaoRepository;
import br.com.btf.spring.data.repository.RegistroRepository;
import br.com.btf.spring.data.service.CrudErroService;
import br.com.btf.spring.data.service.CrudGestaoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudRegistroService registroService;
	private final CrudGestaoService gestaoService;
	private final CrudErroService erroService;
	private final RelatoriosService relatoriosService;
	private Boolean system = true;
	
	public SpringDataApplication(CrudRegistroService registroService, CrudGestaoService gestaoService, 
			CrudErroService erroService, RelatoriosService relatoriosService) {
		this.registroService = registroService;
		this.gestaoService = gestaoService;
		this.erroService = erroService;
		this.relatoriosService = relatoriosService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Ações da aplicação");
			System.out.println("0 - Sair");
			System.out.println("1 - Registros");
			System.out.println("2 - Gestão");
			System.out.println("3 - Erro");
			System.out.println("4 - Relatórios");
			
			Integer action = scanner.nextInt();
			switch (action) {
			case 0: {
				system = false;
				break;
			}
			case 1: {
				registroService.iniciar(scanner);
				break;
			}
			case 2: {
				gestaoService.iniciar(scanner);
				break;
			}
			case 3: {
				erroService.iniciar(scanner);
				break;
			}
			case 4: {
				relatoriosService.iniciar(scanner);
				break;
			}
			default:
				System.out.println("Unexpected value: " + action + ". Try again.");
			}
			
		}
		
	}

}
