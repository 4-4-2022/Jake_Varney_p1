package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "book_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "book_id_seq")
	private int id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "cost", nullable = false)
	private int cost;
	@Column(name = "quantity", nullable = false)
	private int quant;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, String description, int cost, int quant) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.quant = quant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		if(cost<0) {
			this.cost = 0;
		}else {
			this.cost = cost;
		}
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		if(quant<0) {
			this.quant = 0;
		}else {
			this.quant = quant;
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(cost, description, id, name, quant);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return cost == other.cost && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(name, other.name) && quant == other.quant;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", cost=" + cost + ", quant="
				+ quant + "]";
	}

	

	

}
