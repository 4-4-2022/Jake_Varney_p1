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
@Table(name = "orderHistory")
public class Order {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "order_id_seq")
	private int id;
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "book_quantity")
	private int bookQuantity;
	@Column(name = "dice_id")
	private int diceId;
	@Column(name = "dice_quantity")
	private int diceQuantity;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, int bookId, int bookQuantity, int diceId, int diceQuantity) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.bookQuantity = bookQuantity;
		this.diceId = diceId;
		this.diceQuantity = diceQuantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		if(bookId<0) {
			this.bookId = 0;
		}else {
			this.bookId = bookId;
		}
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		if(bookQuantity<0) {
			this.bookQuantity = 0;
		}else {
			this.bookQuantity = bookQuantity;
		}
		
	}
	public int getDiceId() {
		return diceId;
	}
	public void setDiceId(int diceId) {
		if(diceId<0) {
			this.diceId = 0;
		}else {
			this.diceId = diceId;
		}
		
	}
	public int getDiceQuantity() {
		return diceQuantity;
	}
	public void setDiceQuantity(int diceQuantity) {
		if(diceQuantity<0) {
			this.diceQuantity = 0;
		}else {
			this.diceQuantity = diceQuantity;
		}	
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookId, bookQuantity, diceId, diceQuantity, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return bookId == other.bookId && bookQuantity == other.bookQuantity && diceId == other.diceId
				&& diceQuantity == other.diceQuantity && id == other.id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", bookId=" + bookId + ", bookQuantity=" + bookQuantity + ", diceId=" + diceId
				+ ", diceQuantity=" + diceQuantity + "]";
	}
	
	
	
	
}
