package br.com.alura.sfmusic;

import br.com.alura.sfmusic.principal.Principal;
import br.com.alura.sfmusic.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfmusicApplication implements CommandLineRunner {
	@Autowired
	private ArtistaRepository repositorio;


	public static void main(String[] args) {
		SpringApplication.run(SfmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibirMenu();
	}
}
