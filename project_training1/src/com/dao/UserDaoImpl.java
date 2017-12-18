package com.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory; 
	
	public User loginUser(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user1 = session.get(User.class,user.getAddress());
		tx.commit();
		session.close();
		
		return user1;
	}
	
	public void saveuser(User user){
		 Session session = sessionFactory.openSession();
	     Transaction tx = session.beginTransaction();
	     
	     session.save(user);
	     tx.commit();
	}
	
	public boolean rePasswordDao(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user1 = session.get(User.class, user.getAddress());
		tx.commit();
		if(user1.getAddress().equals(user.getAddress())&&user1.getPassword().equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
	}
	
	public void setNewPasswordDao(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user1 = session.get(User.class, user.getAddress());
		user1.setPassword(user.getPassword());
		
		session.save(user1);
		tx.commit();
	}
}
