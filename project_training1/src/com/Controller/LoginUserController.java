package com.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.User;
import com.service.LoginUserServiceImpl;

@Controller
@RequestMapping("/loginuser")
public class LoginUserController {

	@Resource
	private LoginUserServiceImpl loginUserService;
	                        
	//@RequestMapping(value="/login",method=RequestMethod.POST)
	public String LoginUser(HttpSession session,User user){
		
		System.out.println("�����ǵ�¼�û���Controller�㡣");
		System.out.println(user.getName());
		if(loginUserService.LoginUser(user)){
			//JOptionPane.showMessageDialog(null, "��¼�ɹ���");
			session.setAttribute("user", user);
			return "index";
		}else{
			//JOptionPane.showMessageDialog(null, "�˻���������󣬵�¼ʧ�ܣ������ԡ�");
			return "login";
		}
	}
}
