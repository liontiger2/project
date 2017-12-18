package com.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminControllerImpl {
	@Resource
	private AdminServiceImpl adminserviceimpl;
	
	@RequestMapping(value="users")
	public String adminUserController(HttpSession session){
		List userlist = adminserviceimpl.adminUserService();
		session.setAttribute("userlist", userlist);
		
		return "adminuser";
	}
	
	@RequestMapping(value="/deleteuser")
	public String adminDeleteUserController(HttpSession session,@RequestParam(value="address")String address){
		adminserviceimpl.adminDeleteUserService(session, address);
		return "adminuser";
	}
	
	@RequestMapping(value="orders")
	public String adminOrderController(HttpSession session){
		List orderlist = adminserviceimpl.adminOrderService();
		session.setAttribute("orderlist",orderlist);
		
		return "adminorder";
	}
	
	@RequestMapping(value="/deleteorder")
	public String adminDeleteOrderController(HttpSession session,@RequestParam(value="id")String strid){
		int id = Integer.parseInt(strid);
		adminserviceimpl.adminDeleteOrderService(session, id);
		return "adminorder";
	}
	
	@RequestMapping(value="pros")
	public String adminProController(HttpSession session){
		List prolist = adminserviceimpl.adminProService();
		session.setAttribute("prolist", prolist);
		
		return "adminpro";
	}
	
	@RequestMapping(value="/deletepro")
	public String adminDeleteProController(HttpSession session,@RequestParam(value="id")String strid){
		int id = Integer.parseInt(strid);
		adminserviceimpl.adminDeleteProService(session, id);
		return "adminpro";
	}
	
	@RequestMapping(value="/addpro")
	public String adminAddProController(HttpSession session,@RequestParam(value="name")String name,@RequestParam(value="price")float price){
		
		adminserviceimpl.adminAddProService(session,name, price);
		return "adminpro";
	}
}
