package org.sid;

import java.util.Date;

import org.sid.dao.ActualiteRepository;
import org.sid.entities.Actualite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class FileActualiteApplication implements CommandLineRunner {

	@Autowired
	private ActualiteRepository actualiteRepository;
	public static void main(String[] args) {
		SpringApplication.run(FileActualiteApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*actualiteRepository.save(new Actualite("act de mr taouala", new Date(), "photo.png", "taouala", "html code 12"));
		actualiteRepository.save(new Actualite("act de mr simo", new Date(), "simo.png", "simo", "html code 12554"));
		actualiteRepository.save(new Actualite("act de mr ali", new Date(), "ali.png", "ali", "html code 554 54 45"));
		*/
		Page<Actualite> p=actualiteRepository.rechercher("", new PageRequest(0, 4));
		System.out.println("*********************************");
		System.out.println(p.getTotalElements());
		System.out.println("***********************");
		
	}
}
