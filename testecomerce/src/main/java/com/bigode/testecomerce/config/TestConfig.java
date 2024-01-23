package com.bigode.testecomerce.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.enums.CategoryProject;
import com.bigode.testecomerce.repository.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		
		Product pe1 = new Product(null, "Geladeira Eletrolux", CategoryProject.ELETRONICOS, 2256.06, 
				"Geladeira duas portas com regrigeração de água da ultima geração");
		Product pe2 = new Product(null, "Salrung espaço P8", CategoryProject.ELETRONICOS, 643.00
				, "Microoondas para te salvar na larica da madrugada");
		
		Product pg1 = new Product(null, "Controle dualshock 5", CategoryProject.GAMER, 250.00
				, "Controle de PS5 da mas moderna geração");
		Product pg2 = new Product(null, "Cadeira gamer Oreta black", CategoryProject.GAMER, 378.85
				, "Cadeira gamer super confortavel e retratil");
		
		Product pi1 = new Product(null, "PC de escritorio", CategoryProject.INFORMATICA, 1250.00
				, "Computador basico utilizado em escritorio");
		Product pi2 = new Product(null, "Notebook negativo", CategoryProject.INFORMATICA, 2250.00
				, "Notebook negativo slim de facil manuseio e versatibildade");
		
		Product pM1 = new Product(null, "Salrung espaço P8", CategoryProject.MOVEIS, 3050.00
				, "Celular da maiss nova geração com camera ultra realista que da para ver até a tv do vizinho");
		Product pM2 = new Product(null, "PeraPhone min 8", CategoryProject.MOVEIS, 7950.00
				, "Celular chique e caro mas cheio de defeitos e bugs, so burgués compra");
		
		
		productRepository.saveAll(Arrays.asList(pe1, pe2));
		productRepository.saveAll(Arrays.asList(pg1, pg2));
		productRepository.saveAll(Arrays.asList(pi1, pi2));
		productRepository.saveAll(Arrays.asList(pM1, pM2)); 
		
	}

}
