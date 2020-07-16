package com.springjpql.jpql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int price;
	private String description;
	private boolean stock = true;
}
