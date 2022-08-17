package com.filter.projeto.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="tb_product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double price;
	
	//@Column(name = "qty_stk")
	@Column(nullable = false)
	private Integer quantity; //qtyStk
	
	//@Column(name = "creation_date")
	//Estava dando erro nas versoes mais recentes/atualizadas @Temporal(TemporalType.DATE) //Date Time TimeStamp
	@Column(nullable = false)
	private Date criacao;
	
	@Column(columnDefinition = "text")
	private String description;
	 
	//Muitos produtos pra uma categoria
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	//Muitos produtos pra um fornecedor
	//NÃO está trabalhando com muitos produtos para muitos fornecedores
	//Aqui somente varios produtos vão ter um fornecedor
	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;
	
}
