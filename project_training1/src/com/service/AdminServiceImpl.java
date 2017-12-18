package com.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.dao.AdminDaoImpl;

@Service
public class AdminServiceImpl {
	@Resource
	private AdminDaoImpl admindaoimpl;
	
	public List adminUserService(){
		return admindaoimpl.adminUserdao();
	}
	
	public void adminDeleteUserService(HttpSession session,String address){
		admindaoimpl.adminDeleteUserDao(session, address);
	}
	
	public List adminOrderService(){
		return admindaoimpl.adminOrderDao();
	}
	
	public void adminDeleteOrderService(HttpSession session,int id){
		admindaoimpl.adminDeleteOrderDao(session,id);
	}
	
	public List adminProService(){
		return admindaoimpl.adminProdao();
	}
	
	public void adminDeleteProService(HttpSession session,int id){
		admindaoimpl.adminDeleteProDao(session,id);
	}
	
	public void adminAddProService(HttpSession session,String name,float price){
		admindaoimpl.adminAddProDao(session,name, price);
	}
}
