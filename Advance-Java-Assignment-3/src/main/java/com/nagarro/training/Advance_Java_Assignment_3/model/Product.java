package com.nagarro.training.Advance_Java_Assignment_3.model;

import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productTitle;
    private String productQuantity;
    private String productSize;
    private String productImage;
    
    @Lob
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product() {
    }

    public Product(String productTitle, String productQuantity, String productSize, String productImage) {
        this.productTitle = productTitle;
        this.productQuantity = productQuantity;
        this.productSize = productSize;
        this.productImage = productImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }
    public String getProductImage() {
    	productImage = Base64.getEncoder().encodeToString(this.image);
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
    
}

