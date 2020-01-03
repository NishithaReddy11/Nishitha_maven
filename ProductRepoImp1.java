package com.deloitte.estore.repo;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deloitte.estore.model.Product;

public class ProductRepoImp1 implements ProductRepo{

	
	@Override
	public boolean addProduct(Product product) throws Exception {
		//Connection conn=getDbConnection();
		//PreparedStatement ps=conn.prepareStatement("insert into product values(?,?,?)");
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		Session ssn=sf.openSession();
		Transaction tx=ssn.beginTransaction();
		Product p=new Product();
		p.setProductId(product.getProductId());
		p.setProductName(product.getProductName());
		p.setPrice(product.getPrice());
		ssn.save(p);
		tx.commit();
		ssn.close();
		return true;
	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		//Connection con=getDbConnection();
		//PreparedStatement ps1=con.prepareStatement("delete from product where product_id=?");
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		Session ssn=sf.openSession();
		Transaction tx=ssn.beginTransaction();
		Product p=new Product();
		p.setProductId(product.getProductId());
		
		ssn.delete(p);
		tx.commit();
		ssn.close();
		return true;
	}

	@Override
	public boolean updateProduct(Product product) throws Exception{
		//Connection con=getDbConnection();
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		Session ssn=sf.openSession();
		Transaction tx=ssn.beginTransaction();
		Product p=new Product();
		p=ssn.get(Product.class,product.getProductId());
		p.setPrice(product.getPrice());
		ssn.update(p);
		tx.commit();
		ssn.close();
		return true;
	}

	@Override
	public Product getProductById(int productId) throws Exception{
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		Session ssn=sf.openSession();
		Transaction tx=ssn.beginTransaction();
		Product p=new Product();
		p=ssn.get(Product.class,productId);
		
		tx.commit();
		ssn.close();
		return p;
	}

	@Override
	public List<Product> getAllProducts() throws Exception{
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		Session ssn=sf.openSession();
		Transaction tx=ssn.beginTransaction();
		//Product p=new Product();
		Query q=ssn.createQuery("from Product");
		List<Product> products=q.getResultList();
		tx.commit();
		ssn.close();
		return products;
	}

	@Override
	public Connection getDbConnection() throws Exception{
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		return conn;
	}

	
	
}
