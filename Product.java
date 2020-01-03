package com.deloitte.estore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name="product_details")
public class Product {
		@Id
		@Column(name="product_id")
		//@GeneratedValue(strategy=GenerationType.AUTO)
		private int productId;
		@Column(name="product_name")
		private String productName;
		private float price;
		public Product()
		{
			
		}
		public Product(int productId, String productName, float price) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.price = price;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
		}
		
		
}
