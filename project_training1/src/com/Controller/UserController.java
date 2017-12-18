package com.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;
import com.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userservice;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginUserController(HttpSession session,User user){
		System.out.println("这里是登录用户的Controller层。");
		System.out.println(user.getName());
		User user1 = (User) userservice.loginUserService(user);
		if(user1.getName().equals("admin") && user1.getPassword().equals("123")){
			session.setAttribute("user", user);
			return "admin";
		}else if(user1.getAddress().equals(user.getAddress())&&user1.getPassword().equals(user.getPassword())){
			//JOptionPane.showMessageDialog(null, "登录成功。");
			session.setAttribute("user", user);
			session.setAttribute("username", user.getName());
			session.setAttribute("useraddress", user.getAddress());
			String useraddress = (String) session.getAttribute("useraddress");
			System.out.println(useraddress);
			return "index";
		}else{
			//JOptionPane.showMessageDialog(null, "账户或密码错误，登录失败，请重试。");
			return "login";
		}
	}
	
	@RequestMapping("/save")
	public String saveUser(User user){
		System.out.println(1111111);
		System.out.println(user.getName());
		userservice.saveuser(user);
		return "index";
	}
	
	@RequestMapping(value="/repassword",method=RequestMethod.POST)
	public String rePasswordController(@RequestParam(value="address")String address,@RequestParam(value="name")String name,@RequestParam(value="password")String password){
		User user =new User();
		user.setAddress(address);
		user.setName(name);
		user.setPassword(password);
		if(userservice.rePasswordService(user)){
			return "setnewpassword";
		}else{
			return "repassword";
		}
	}
	
	@RequestMapping(value="/setnewpassword",method=RequestMethod.POST)
	public String setNewPasswordController(@RequestParam(value="newpassword")String newpwd,@RequestParam(value="name")String name,@RequestParam(value="address")String address){
		User user =new User();
		user.setAddress(address);
		user.setName(name);
		user.setPassword(newpwd);
		userservice.setNewPasswordService(user);
		return "login";
	}
}
