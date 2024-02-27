package com.bigode.testecomerce.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bigode.testecomerce.dto.CartDTO;
import com.bigode.testecomerce.entity.Cart;
import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.User;
import com.bigode.testecomerce.entity.UserClient;
import com.bigode.testecomerce.entity.UserEmployee;
import com.bigode.testecomerce.entity.enums.CategoryEmployee;
import com.bigode.testecomerce.entity.enums.CategoryProduct;
import com.bigode.testecomerce.repository.ProductRepository;
import com.bigode.testecomerce.repository.UserRepository;
import com.bigode.testecomerce.service.CartService;
import com.bigode.testecomerce.service.ProductService;
import com.bigode.testecomerce.service.UserService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository; 
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private CartService cartService; 
	
	@Override
	public void run(String... args) throws Exception {
		
		/* ------------ Products --------------*/
		
		Product pe1 = new Product(null, "Geladeira Eletrolux", CategoryProduct.ELETRONICOS, 2256.06,
				"Geladeira duas portas com regrigeração de água da ultima geração");
		Product pe2 = new Product(null, "Microondas lux a brilhar", CategoryProduct.ELETRONICOS, 643.00
				,"Microoondas para te salvar na larica da madrugada");
		Product pe3 = new Product(null, "Fogão embutido bonzão", CategoryProduct.ELETRONICOS, 1343.00
				,"Microoondas para te salvar na larica da madrugada");
		Product pe4 = new Product(null, "Maquina de lavar chique", CategoryProduct.ELETRONICOS, 2199.90
				,"Microoondas para te salvar na larica da madrugada");
		Product pe5 = new Product(null, "Cervejeira 80 litros", CategoryProduct.ELETRONICOS, 2643.00
				,"Microoondas para te salvar na larica da madrugada");
		
		Product pg1 = new Product(null, "Controle dualshock 5", CategoryProduct.GAMER, 250.00
				, "Controle de PS5 da mas moderna geração");
		Product pg2 = new Product(null, "Cadeira gamer Oreta black", CategoryProduct.GAMER, 378.85
				, "Cadeira gamer super confortavel e retratil");
		Product pg3 = new Product(null, "Controle gamer falso", CategoryProduct.GAMER, 178.85
				, "Cadeira gamer super confortavel e retratil");
		Product pg4 = new Product(null, "Fone que pisca", CategoryProduct.GAMER, 228.05
				, "Cadeira gamer super confortavel e retratil");
		Product pg5 = new Product(null, "Placa de video TRY 4060", CategoryProduct.GAMER, 3864.99
				, "Cadeira gamer super confortavel e retratil");
		
		Product pi1 = new Product(null, "PC de escritorio", CategoryProduct.INFORMATICA, 1250.00
				, "Computador basico utilizado em escritorio");
		Product pi2 = new Product(null, "Notebook negativo", CategoryProduct.INFORMATICA, 2250.00
				, "Notebook negativo slim de facil manuseio e versatibildade");
		Product pi3 = new Product(null, "Mouse mikael", CategoryProduct.INFORMATICA, 60.00
						, "Notebook negativo slim de facil manuseio e versatibildade");
		Product pi4 = new Product(null, "Touch pad estilosos", CategoryProduct.INFORMATICA, 150.00
						, "Notebook negativo slim de facil manuseio e versatibildade");
		Product pi5 = new Product(null, "Caixinha de som para pc veio", CategoryProduct.INFORMATICA, 50.00
						, "Notebook negativo slim de facil manuseio e versatibildade");
		
		Product pM1 = new Product(null, "Salrung espaço P8", CategoryProduct.MOVEIS, 3050.00
				, "Celular da maiss nova geração com camera ultra realista que da para ver até a tv do vizinho");
		Product pM2 = new Product(null, "PeraPhone min 8", CategoryProduct.MOVEIS, 7950.00
				, "Celular chique e caro mas cheio de defeitos e bugs, so burgués compra");
		Product pM3 = new Product(null, "China homi XXR8", CategoryProduct.MOVEIS, 2950.00
				, "Celular chique e caro mas cheio de defeitos e bugs, so burgués compra");
		Product pM4 = new Product(null, "Saumung lactia 65", CategoryProduct.MOVEIS, 350.00
				, "Celular chique e caro mas cheio de defeitos e bugs, so burgués compra");
		Product pM5 = new Product(null, "Motor Rola? x9", CategoryProduct.MOVEIS, 1650.00
				, "Celular chique e caro mas cheio de defeitos e bugs, so burgués compra");
		
		
		
		productRepository.saveAll(Arrays.asList(pe1, pe2, pe3, pe4, pe5));
		productRepository.saveAll(Arrays.asList(pg1, pg2, pg3, pg4, pg5));
		productRepository.saveAll(Arrays.asList(pi1, pi2, pi3, pi4, pi5));
		productRepository.saveAll(Arrays.asList(pM1, pM2, pM3, pM4, pM5)); 
		

		/* ------------ User --------------*/
		
		UserClient uc1 = new UserClient(null, "Rafaela Dias", "Mem4CoM3uboo", "rafaelaalmeidadias@cuvox.de", 
				"(62) 9980-7037", "430.782.091-64");
		User uc2 = new UserClient(null, "Nicole Gomes", "Oovei5ophi", "nicolecunhagomes@rhyta.com", 
				"(16) 4916-6146", "897.774.890-99");
		User uc3 = new UserClient(null, "Rebeca Alves", "dai3Xu6shu", "rebecacorreiaalves@dayrep.com", 
				"(48) 2034-4399", "414.423.871-73");
		User uc4 = new UserClient(null, "Giovanna Costa", "ies4ohMeeVae", "giovannaferreiracosta@fleckens.hu", 
				"(61) 7448-2760", "393.331.209-47");
		User uc5 = new UserClient(null, "Isabelle Carvalho", "ahquubaep7V", "isabelleribeirocarvalho@fleckens.hu", 
				"(67) 2152-2251", "744.573.997-10");
		
		
		User ue1 = new UserEmployee(null, "Vitór Melo", "ocahChee9oe", "E-193", CategoryEmployee.ESTAGIARIO);
		User ue2 = new UserEmployee(null, "Manuela Cardoso", "Aech3mo6ueS", "J-085", CategoryEmployee.JUNIOR);
		User ue3 = new UserEmployee(null, "Pedro Goncalves", "iqueis3Eide", "J-193", CategoryEmployee.JUNIOR);
		User ue4 = new UserEmployee(null, "Tânia Correia", "AiVupoa1hah", "I-776", CategoryEmployee.INTERMEDION);
		User ue5 = new UserEmployee(null, "Lavinia Souza", "uagh9sheQu", "S-883", CategoryEmployee.SENIOR);
		
		userService.saveAll(Arrays.asList(uc1, uc2, uc3, uc4, uc5));
		userService.saveAll(Arrays.asList(ue1, ue2, ue3, ue4, ue5)); 
		
		
		
		/* ------------ Card -------------- */
		
		List<Product> listCart1 = new ArrayList<Product>();
		
		CartDTO cartDTO = new CartDTO(null, uc1, listCart1);
		
		cartService.insert(cartDTO);
		
		Cart cart = cartService.findById(1);
		Product productCart1 = productService.findById(1);
		Product productCart2 = productService.findById(12);
		Product productCart3 = productService.findById(6);
		
		cartService.addOnCart(cart.getId(), productCart1.getId());
		cartService.addOnCart(cart.getId(), productCart2.getId());
		cartService.addOnCart(cart.getId(), productCart3.getId());
		
	}

}
