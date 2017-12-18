package com.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.entity.Order;
import com.entity.Product;
import com.entity.User;

@Repository
public class AdminDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public List adminUserdao(){
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from User");
		List l =  q.list();
		
		return l;
	}
	
	public void adminDeleteUserDao(HttpSession session,String address){
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		User user1 = s.get(User.class,address);
		s.delete(user1);
		tx.commit();
		
		Session s1 = sessionFactory.getCurrentSession();
		Query q = s1.createQuery("from User");
		List l = q.list();
		session.setAttribute("userlist", l);
	}
	
	public List adminOrderDao(){
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Order");
		List l =  q.list();
		
		return l;
	}
	
	public void adminDeleteOrderDao(HttpSession session,int id){
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		Order order1 = s.get(Order.class,id);
		s.delete(order1);
		tx.commit();
		
		Session s1 = sessionFactory.getCurrentSession();
		Query q = s1.createQuery("from Order");
		List l = q.list();
		session.setAttribute("orderlist", l);
	}
	
	public List adminProdao(){
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from Product");
		List l =  q.list();
		
		return l;
	}
	
	public void adminDeleteProDao(HttpSession session,int id){
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		Product pro = s.get(Product.class,id);
		s.delete(pro);
		tx.commit();
		
		Session s1 = sessionFactory.getCurrentSession();
		Query q = s1.createQuery("from Product");
		List l = q.list();
		session.setAttribute("prolist", l);
	}
	
	public void adminAddProDao(HttpSession session,String name,float price){
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		
		s.save(p);
		tx.commit();
		
		Session s1 = sessionFactory.getCurrentSession();
		Query q = s1.createQuery("from Product");
		List l = q.list();
		session.setAttribute("prolist", l);
	}
}
