package com.sapient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapient.model.Securities;
import com.sapient.service.BrokerService;
import com.sapient.service.SecuritiesService;

public class EditSecuritiesController {

	@RequestMapping("/views/editSecurity")
	public String executionStartStop(HttpServletRequest req) {
		System.out.println("executionStartStop");
/*	System.out.println("executionStartStop");
		String stop = req.getParameter("stop");
		System.out.println("password: " + stop);*/
       Securities security=new Securities();
       String symbol=req.getParameter("ticker");
       String symbolName=req.getParameter("Symbol name");
  String last_trade_price =req.getParameter("Last traded Price");
		String max_price_spread = req.getParameter("Maximum Price Spread ");
		String max_executions =req.getParameter("Maximum Executions Per Order ");
		String max_interval =req.getParameter("Maximum Interval ");
		String prob_percent =req.getParameter("Maximum Probable Percentage");
       
       
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(
				com.sapient.config.AppConfig.class);
		container.registerShutdownHook();
		SecuritiesService securitiesService = (SecuritiesService) container.getBean("securitiesService");
		security=securitiesService.findByPrimaryKey(symbol);
		security.setLast_trade_price( Double.parseDouble(last_trade_price));
		security.setMax_executions( Integer.parseInt(max_executions));
		security.setMax_interval( Integer.parseInt(max_interval));
		security.setMax_price_spread(Double.parseDouble(max_price_spread));
		security.setSecurity_name(symbolName);
		security.setProb_percent(Double.parseDouble(prob_percent));
		securitiesService.savesecurities(security);
	
		
		return "redirect:ConfigureSecurities.jsp";
		
}
}
