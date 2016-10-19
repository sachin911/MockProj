package com.sapient.controller;

import java.net.URISyntaxException;

import javax.persistence.Persistence;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.jms.ActiveMQControl;
import com.sapient.main.Login;
import com.sapient.model.User;

@Controller
public class LoginController {
	
	
	@RequestMapping("/views/hello")

	public ModelAndView sysLogin(HttpServletRequest req) throws URISyntaxException, Exception {
		ActiveMQControl bro = ActiveMQControl.getInstance();
		String uname = req.getParameter("username");
		System.out.println("username: " + uname);
		System.out.println("Controller");
		String pass = req.getParameter("password");

		System.out.println("password: " + pass);
		User user = new User();
		user.setUser_name(uname);
		user.setPassword(pass);
		Login l = new Login();

		String vm = l.checkuser(user);

		req.getSession().setAttribute("message", vm);
		if (vm.equals("Valid user")) {
			bro.startBroker();
			return new ModelAndView("redirect:BrokerMainScreen.jsp", "message", vm);
		} else {
			return new ModelAndView("redirect:Login.jsp", "message", vm);

		}

	}

	@RequestMapping("/views/changepassword")
	public ModelAndView changepass(HttpServletRequest req) {
		String uname = req.getParameter("username");
		String skey = req.getParameter("secret_key");
		String npass = req.getParameter("newpass");
		String cpass = req.getParameter("confirmpass");
		User user = new User();
		Login l = new Login();
		if (npass.equalsIgnoreCase(cpass)) {
			user.setUser_name(uname);
			user.setSecret_key(skey);
			user.setPassword(npass);
			l.updatepass(user);
			String vm = "updated";
			return new ModelAndView("redirect:Login.jsp", "message", vm);
		} else {
			String message = "password dont match";
			return new ModelAndView("redirect:ForgetPassword.jsp", "message", message);
		}

	}

	@RequestMapping("/views/logout")
	public String logout(HttpServletRequest req) throws Exception {
		System.out.println("logging out");
		ActiveMQControl bro = ActiveMQControl.getInstance();
		bro.stopBroker();
		req.getSession().invalidate();
		return "redirect:Login.jsp";
	}

}