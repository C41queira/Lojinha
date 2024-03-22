package com.bigode.testecomerce.entity;

import com.bigode.testecomerce.entity.enums.CategoryEmployee;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class UserEmployee extends User {

	@Column(name = "codigoFuncionario")
	private String codEmployee; 

	@Column(name = "cargo")
	@Enumerated(EnumType.STRING)
	private CategoryEmployee jobTitle;
	
	public UserEmployee() {
		super();
	}

	public UserEmployee(Integer id, String name, String senha, String codEmployee, CategoryEmployee jobTitle) {
		super(id, name, senha);
		this.codEmployee = codEmployee; 
		this.jobTitle = jobTitle; 
	}

	public String getCodEmployee() {
		return codEmployee;
	}

	public void setCodEmployee(String codEmployee) {
		this.codEmployee = codEmployee;
	}

	public CategoryEmployee getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(CategoryEmployee jobTitle) {
		this.jobTitle = jobTitle;
	} 
	
}
