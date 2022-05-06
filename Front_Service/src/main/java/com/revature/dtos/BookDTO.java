package com.revature.dtos;

import java.util.Objects;

public class BookDTO {
	private int id;
	private String name;
	private String description;
	private int cost;

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(int id, String name, String description, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
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
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, description, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDTO other = (BookDTO) obj;
		return cost == other.cost && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", description=" + description + ", cost=" + cost + "]";
	}

}
