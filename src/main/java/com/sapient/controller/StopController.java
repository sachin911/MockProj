package com.sapient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StopController {
@RequestMapping("/views/stopexecution")
public String execution_stop(HttpServletRequest req) {
	System.out.println("inside stop controller");
	return "redirect:Login.jsp";
	
}
}
