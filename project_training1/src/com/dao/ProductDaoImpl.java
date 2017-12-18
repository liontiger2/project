package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Order;
import com.entity.Product;

@Repository
public class ProductDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Product productdao(int id){
		
		
		//Product product= sessionFactory.getCurrentSession().get(Product.class,new Integer(id));
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Product p = session.get(Product.class, new Integer(id));
		
		t.commit();
		
		return p;
	}
	
	public Product addToCartDao(int id){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Product p = session.get(Product.class, new Integer(id));
		
		tx.commit();
		
		return p;
	}
	
	public void placeOrder(HttpSession hsession,String tel,String address){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Order o = new Order();
		String useraddress = (String) hsession.getAttribute("useraddress");
		System.out.println(useraddress);
		String productid = "";
		List<CartItem> list = (List) hsession.getAttribute("cartlist");
		for(CartItem c:list){
			String pid = c.getProduct().getId() + ",";
			productid += pid;
		}
		o.setTel(tel); 
		o.setAddress(address);
		o.setUseraddress(useraddress);
		o.setProductId(productid);
		
		session.save(o);
		tx.commit();
	}
}



