package edu.unsw.comp9321;

import java.io.Serializable;
import java.util.*;
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Record> items;
	public ShoppingCart(){
		this.items = new LinkedList<Record>();
	}
	
	public void addItem(Record b){
		this.items.add(b);
	}

	public List<Record> getItems() {
		return items;
	}

	public void setItems(List<Record> items) {
		this.items = items;
	}

	public int getItemsSize(){
		return this.items.size();
	}
	
}
