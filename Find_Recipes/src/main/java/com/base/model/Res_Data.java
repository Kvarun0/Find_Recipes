package com.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rec_data")
public class Res_Data {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="a_id")
	private int id;
	
	@Column(name="item_name")
	private String item_name;
	
	@Column(name="item_ingredients")
	private String item_ingredients;
	
	@Column(name="item_recipe")
	private String item_recipe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_ingredients() {
		return item_ingredients;
	}

	public void setItem_ingredients(String item_ingredients) {
		this.item_ingredients = item_ingredients;
	}

	public String getItem_recipe() {
		return item_recipe;
	}

	public void setItem_recipe(String item_recipe) {
		this.item_recipe = item_recipe;
	}

	@Override
	public String toString() {
		return "Rec_Data [id=" + id + ", item_name=" + item_name + ", item_ingredients=" + item_ingredients
				+ ", item_recipe=" + item_recipe + "]";
	}
	
	
	
}