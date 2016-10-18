package com.sapient.controller;

import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.config.AppConfig;
import com.sapient.main.Login;
import com.sapient.model.User;
import com.sapient.service.UserService;

@Controller
public class LoginController {

	@RequestMapping("/views/hello")

	public ModelAndView sysLogin(HttpServletRequest req) {
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
		if (vm.equals("Valid user"))
			return new ModelAndView("redirect:BrokerMainScreen.jsp", "message", vm);
		else
			return new ModelAndView("redirect:Login.jsp", "message", vm);

	}
}