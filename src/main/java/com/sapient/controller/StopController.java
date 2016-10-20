package com.sapient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapient.jms.ActiveMQControl;

@Controller
public class StopController {
	
	//boolean flag=true;
@RequestMapping("/views/stopexecution")
public String execution_stop(HttpServletRequest req) {
	System.out.println("inside stop controller");
	//setFlag(false);
	ActiveMQControl bro = ActiveMQControl.getInstance();
	try {
		bro.stopBroker();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "redirect:BrokerMainScreen.jsp";
	
}
	/*
	 * public boolean getFlag() { return flag; } public void setFlag(boolean
	 * flag) { this.flag = flag; }
	 */}
