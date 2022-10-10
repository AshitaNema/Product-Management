package com.nagarro.training.Advance_Java_Assignment_3.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDao {
    private final SessionFactory factory;
    private final Session session;

    public ProductDao() {
        this.factory = new Configuration().configure().
                addAnnotatedClass(Product.class).buildSessionFactory();
        this.session = factory.openSession();
    }

    public void addProduct(Product product) {
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public void deleteProduct(int id) {
        session.beginTransaction();

        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public void editProduct(int id, String title, String qty, String size, String image, byte[] imagesize) {
        session.beginTransaction();

        Product product = session.get(Product.class, id);
        product.setProductTitle(title);
        product.setProductQuantity(qty);
        product.setProductSize(size);
        product.setImage(imagesize);
        product.setProductImage(image);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		
		Product product = session.get(Product.class, id);
        product.getProductTitle();
        product.getProductQuantity();
        product.getProductSize();
        product.getProductImage();
		return product;
	}

}

