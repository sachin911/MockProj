package tradingApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.config.AppConfig;
import com.mock.project.model.Order;
import com.mock.project.model.User;
import com.mock.project.service.OrderService;
import com.mock.project.service.PMServices;

@Controller
public class PMController {

	@RequestMapping("/views/CreateOrder")
	public ModelAndView addCreateOrder(@ModelAttribute("order") Order d, HttpServletRequest request) {

		User u = (User) request.getSession().getAttribute("user");
		System.out.println("ADD CREATE ORDER, I AM CHECKING SESSIONS USER PERSISTENCE: " + u.toString());
		String traderName = null;
		String portfolioName = null;
		traderName = request.getParameter("traderName");
		portfolioName = request.getParameter("portfolioName");
		d.setStatus("New");

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = (PMServices) container.getBean("PMService");
		Long traderId;
		Long portfolioId;
		traderId = pmservice.getTraderId(traderName);
		portfolioId = pmservice.getPortfolioId(portfolioName);
		d.setTraderId(traderId);

		d.setPortfolioId(portfolioId);
		OrderService orderService = container.getBean(OrderService.class);		

		d.setPmId(u.getId());
		orderService.addOrder(d);
		container.close();
		ModelAndView view = new ModelAndView("redirect:CreateTrade.jsp");
		return view;
	}
	//to get the complete order to be edited
	@RequestMapping(value = "views/EditOrderPMc", method = RequestMethod.POST)
	public String editorder(HttpServletRequest req) {

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = container.getBean(PMServices.class);
		String out = req.getParameter("message");
		System.out.println("out:" + out);
		Long idl = Long.parseLong(out);
		System.out.println("edit controller" + idl);
		Order order = pmservice.getOrderById(idl);
		ModelAndView view = new ModelAndView("redirect:EditOrderPM.jsp");
		System.out.println("in editorderpm");
		view.addObject("Orders", order);
		container.close();
		req.getSession().setAttribute("Orders", order);
		return "redirect:EditOrderPM.jsp";
	}

	@RequestMapping(value = "views/AmendOrderPMc", method = RequestMethod.POST)
	public String amendorder(HttpServletRequest req) {

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = container.getBean(PMServices.class);
		String out = req.getParameter("message");
		System.out.println("Inside AmendOrderPMc, GOT THIS MESSAGE FROM REQUEST: " + out);
		out = out.trim();
		Long idl = Long.parseLong(out);
		System.out.println("Parsed string to long: " + idl);
		Order order = pmservice.getOrderById(idl);
		ModelAndView view = new ModelAndView("redirect:AmendOrder.jsp");
		view.addObject("Orders", order);
		container.close();
		req.getSession().setAttribute("Orders", order);
		return "redirect:AmendOrder.jsp";
	}
	
	//to update the order once its edited
	@RequestMapping(value = "views/EditOrder", method = RequestMethod.POST)
	public ModelAndView EditOrderUpdate(HttpServletRequest req) {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = container.getBean(PMServices.class);	
		String orderId = req.getParameter("orderId1");
		String symbol = req.getParameter("symbol1");
		String side = req.getParameter("side1");
		String orderType = req.getParameter("orderType1");
		String orderqual = req.getParameter("orderqual1");
		String acctype = req.getParameter("acctype1");
		String qtyPlaced = req.getParameter("qtyPlaced1");
		String trader = req.getParameter("trader1");
		String portfolio = req.getParameter("portfolio1");
		String stop = req.getParameter("stop1");
		String limit = req.getParameter("limit1");
		int qty = Integer.parseInt(qtyPlaced);
		Long idl = Long.parseLong(orderId);		
		double stopd = Double.parseDouble(stop);
		double limitd = Double.parseDouble(limit);
		Long port = Long.parseLong(portfolio);
		Long tradeId = Long.parseLong(trader);		
		Order o = new Order(idl,symbol,side,orderType,orderqual,acctype,qty,tradeId,port,stopd,limitd);		
		pmservice.UpdateOrderById(o);
		ModelAndView view = new ModelAndView("PMHome");
		container.close();
		return view;
	}

	@RequestMapping(value = "views/AmendOrder", method = RequestMethod.POST)
	public ModelAndView amendorderform(HttpServletRequest req) {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = container.getBean(PMServices.class);
		String orderId = req.getParameter("orderId1");
		String symbol = req.getParameter("symbol1");
		String side = req.getParameter("side1");
		String orderType = req.getParameter("orderType1");
		String orderqual = req.getParameter("orderqual1");
		String acctype = req.getParameter("acctype1");
		String qtyPlaced = req.getParameter("qtyPlaced1");
		String trader = req.getParameter("trader1");
		String portfolio = req.getParameter("portfolio1");
		String stop = req.getParameter("stop1");
		String limit = req.getParameter("limit1");
		int qty = Integer.parseInt(qtyPlaced);
		Long idl = Long.parseLong(orderId);		
		double stopd = Double.parseDouble(stop);
		double limitd = Double.parseDouble(limit);
		Long port = Long.parseLong(portfolio);
		Long tradeId = Long.parseLong(trader);		
		Order o = new Order(idl,symbol,side,orderType,orderqual,acctype,qty,tradeId,port,stopd,limitd);
		pmservice.UpdateOrderById(o);
		ModelAndView view = new ModelAndView("PMHome");
		container.close();
		return view;
	}

	@RequestMapping(value = "views/DeleteOrder", method = RequestMethod.POST)
	public ModelAndView deleteorder(HttpServletRequest req) {

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = container.getBean(PMServices.class);
		String out = req.getParameter("message").trim();
		Long idl = Long.parseLong(out);
		pmservice.findOrderForUpdate(idl);
		ModelAndView view = new ModelAndView("PendingOrder");
		container.close();
		return view;
	}

	@RequestMapping(value = "/ViewHistory", method = RequestMethod.POST)
	public ModelAndView viewhistory(@ModelAttribute("order") Order d) {
		// view history code
		return new ModelAndView("Error");
	}

	@RequestMapping(value = "/ViewSpecificTrade", method = RequestMethod.POST)
	public ModelAndView viewspecifictrade(@ModelAttribute("order") Order d) {

		// view specific trade code
		return new ModelAndView("Error");
	}

	@RequestMapping(value = "views/ViewOrderBlotter", method = RequestMethod.GET)
	public ModelAndView UpdateOrder(HttpServletRequest req) {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmsendtotrader = (PMServices) container.getBean("PMService");
		List<Order> p = new ArrayList<Order>();
		User user = (User) req.getSession().getAttribute("user");
		Long pmId = user.getId();
		p = pmsendtotrader.displayForPMAfterSend(pmId);
		for (Order l : p) {
		}
		ModelAndView model = new ModelAndView("OrderBlotter");
		model.addObject("Orders", p);
		container.close();
		return model;
	}

	@RequestMapping(value = "views/SendToTrader", method = RequestMethod.POST)
	public ModelAndView UpdateStatus(HttpServletRequest req) {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = (PMServices) container.getBean("PMService");
		List<Long> orderId = new ArrayList<Long>();
		List<String> orderStatus = new ArrayList<String>();
		String[] out = req.getParameterValues("data");
		String[] ids = out[0].split(",");
		for (String order : ids) {
			orderId.add(Long.parseLong(order));
		}
		for (Long order : orderId) {
			System.out.println(order);
		}

		pmservice.updateStatus(orderId);

		List<Order> p = new ArrayList<Order>();

		User user = (User) req.getSession().getAttribute("user");
		Long pmId = user.getId();
		p = pmservice.displayForPMAfterSend(pmId);
		for (Order l : p) {
			System.out.println(l);
		}
		ModelAndView model = new ModelAndView("OrderBlotter");
		model.addObject("Orders", p);
		container.close();
		return model;

	}

	@RequestMapping(value = "views/ViewPendingOrder", method = RequestMethod.GET)
	public ModelAndView viewpendingorder(@ModelAttribute("order") Order d, HttpServletRequest req) {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmsendtotrader = (PMServices) container.getBean("PMService");
		List<Order> p = new ArrayList<Order>();
		User user = (User) req.getSession().getAttribute("user");
		Long pmId = user.getId();
		p = pmsendtotrader.displayPendingForPM(pmId);
		System.out.println("p:" + p);
		List<Order> q = new ArrayList<Order>();
		for (Order l : p) {
			String stat = l.getStatus();
			if (stat.equalsIgnoreCase("OPEN"))
				q.add(l);

		}
		ModelAndView model = new ModelAndView("PendingOrder");
		model.addObject("Orders", q);
		return model;
	}

	@RequestMapping(value = "views/fetchTraderList", method = RequestMethod.POST)
	public void getTraderList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmservice = (PMServices) container.getBean("PMService");
		List<String> traderNameList = new ArrayList<String>();
		traderNameList = pmservice.getTraderNameList();
		String toSend = "";
		for (String t : traderNameList) {
			toSend += t;
			toSend += ",";
		}
		PrintWriter out = response.getWriter();
		out.print(toSend);
		out.close();
	}

}