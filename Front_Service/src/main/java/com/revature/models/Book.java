package com.revature.models;

import java.util.Objects;

public class Book {

	private int id;
	private String name;
	private String description;
	private int cost;
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
