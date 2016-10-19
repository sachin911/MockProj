package com.sapient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapient.model.Securities;
import com.sapient.service.SecuritiesService;

@Controller
public class AddSecurityController {
	@RequestMapping("/views/addsecurity")
	public String add_security(HttpServletRequest req) {
		System.out.println("inside add controller");
		
		 //System.out.println("executionStartStop"); String stop =
		// * req.getParameter("stop"); System.out.println("password: " + stop);
		 
		Securities security = new Securities();
		String symbol = req.getParameter("Ticker2");
		String symbolName = req.getParameter("SymbolName");
		String last_trade_price = req.getParameter("LastTradedPrice");
		String max_price_spread = req.getParameter("MaximumPriceSpread");
		String max_executions = req.getParameter("MaximumExecutionsPerOrder");
		String max_interval = req.getParameter("MaximumInterval");
		String prob_percent = req.getParameter("MaximumProbablePercentage");

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(
				com.sapient.config.AppConfig.class);
		container.registerShutdownHook();
		SecuritiesService securitiesService = (SecuritiesService) container.getBean("securitiesService");
		System.out.println(symbol);
		System.out.println("symbolName"+symbolName);
		System.out.println("max_executions"+max_executions);
		
		//security = securitiesService.findByPrimaryKey(symbol);
		security.setSecurity_symbol(symbol);
		security.setSecurity_name(symbolName);
		security.setLast_trade_price(Double.parseDouble(last_trade_price));
		security.setMax_executions(Integer.parseInt(max_executions));
		security.setMax_interval(Integer.parseInt(max_interval));
		security.setMax_price_spread(Double.parseDouble(max_price_spread));
		security.setProb_percent(Double.parseDouble(prob_percent));
		securitiesService.savesecurities(security);

		return "redirect:ConfigureSecurity.jsp";


	}
}
