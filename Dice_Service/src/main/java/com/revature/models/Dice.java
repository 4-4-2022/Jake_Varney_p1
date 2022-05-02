package com.revature.models;

import java.util.Objects;

public class Dice {

	private String color;
	private int cost;
	private String Description;

	public Dice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dice(String color, int cost, String description) {
		super();
		this.color = color;
		this.cost = cost;
		Description = description;
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
		return Objects.hash(Description, color, cost);
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
				&& cost == other.cost;
	}

	@Override
	public String toString() {
		return "Dice [color=" + color + ", cost=" + cost + ", Description=" + Description + "]";
	}

}
