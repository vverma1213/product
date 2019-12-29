package com.product.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String brand;
	private Integer price;
	private String color;
	private int size;
	private String sku;
	private String product;
	private String seller;
	
	public Product() {
		
	}
	
	
	
	public Product(Long id,String brand, String product,Integer price, String color, int size, String sku, String seller) {
		this.id=id;
		this.brand = brand;
		this.product=product;
		this.price = price;
		this.color = color;
		this.size = size;
		this.sku = sku;
		this.seller=seller;
	}

	public String getSeller() {
		return seller;
	}
	
	public void setSeller(String seller) {
		this.seller=seller;
	}
	
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		this.product=product;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}

	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}



	@Override
	public String toString() {
		return "ID:"+id+", brand:"+brand+ ", product:"+", price:"+price +", color:"+color +", size:" +size+", sku:"+sku;
	}

}
