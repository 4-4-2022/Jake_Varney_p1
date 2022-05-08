package com.revature.models;

import java.util.Objects;

public class Dice {

	private int id;
	private String color;
	private int cost;
	private String Description;
	private int quant;
	public Dice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dice(int id, String color, int cost, String description, int quant) {
		super();
		this.id = id;
		this.color = color;
		this.cost = cost;
		Description = description;
		this.quant = quant;
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
		if(cost<0) {
			this.cost = 0;
		}else {
			this.cost = cost;
		}
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
		return Objects.hash(Description, color, cost, id, quant);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dice other = (Dice) obj;
		return Objects.equals(Description, other.Description) && Objects.equals(color, other.color)
				&& cost == other.cost && id == other.id && quant == other.quant;
	}
	@Override
	public String toString() {
		return "Dice [id=" + id + ", color=" + color + ", cost=" + cost + ", Description=" + Description + ", quant="
				+ quant + "]";
	}
}
