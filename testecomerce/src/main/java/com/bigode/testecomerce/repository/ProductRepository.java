package com.bigode.testecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bigode.testecomerce.entity.Product;
import com.bigode.testecomerce.entity.enums.CategoryProduct;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT o FROM Product o WHERE o.categoryProduct = 'ELETRONICOS' ")
	public List<Product> findByCategoriEletronicos();
	
	@Query("SELECT o FROM Product o WHERE o.categoryProduct = 'MOVEIS' ")
	public List<Product> findByCategoriMoveis();
	
	@Query("SELECT o FROM Product o WHERE o.categoryProduct = 'INFORMATICA' ")
	public List<Product> findByCategoriInformatica();
	
	@Query("SELECT o FROM Product o WHERE o.categoryProduct = 'GAMER' ")
	public List<Product> findByCategoriGamer();
	
	
	@Query("SELECT p FROM Product p WHERE p.categoryProduct = :categoria AND p.price >= :valorMinimo AND p.price <= :valorMaximo ")
	public List<Product> findByPriceBetween(CategoryProduct categoria ,Double valorMinimo, Double valorMaximo); 
	
	//@Query("SELECT p FROM Product p WHERE p.name = :search")
	public List<Product> findByNameContainingIgnoreCase(String search);
}
