package com.revature.dtos;

import java.util.Objects;

public class DiceDTO {

	private int id;
	private String color;
	private int cost;
	private String Description;
	public DiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiceDTO(int id, String color, int cost, String description) {
		super();
		this.id = id;
		this.color = color;
		this.cost = cost;
		Description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Description, color, cost, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiceDTO other = (DiceDTO) obj;
		return Objects.equals(Description, other.Description) && Objects.equals(color, other.color)
				&& cost == other.cost && id == other.id;
	}
	@Override
	public String toString() {
		return "DiceDTO [id=" + id + ", color=" + color + ", cost=" + cost + ", Description=" + Description + "]";
	}
	
	
}
