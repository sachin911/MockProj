package tradingApplication;
import org.springframework.stereotype.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.config.AppConfig;
import com.mock.project.model.Order;
import com.mock.project.model.User;
import com.mock.project.service.OrderService;
import com.mock.project.service.PMServices;

@Controller
public class DisplayPortfolioController {

	@RequestMapping("views/Mining")
	public ModelAndView displayPortfolioMining(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Mining", request);
		return mav;
	}

	@RequestMapping("views/Banking")
	public ModelAndView displayPortfolioBanking(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Banking", request);
		return mav;
	}
	
	@RequestMapping("views/Automobile")
	public ModelAndView displayPortfolioAutomobile(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Automobile", request);
		return mav;
	}
	
	@RequestMapping("views/Energy")
	public ModelAndView displayPortfolioEnergy(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Energy", request);
		return mav;
	}
	
	@RequestMapping("views/Pharma")
	public ModelAndView displayPortfolioPharma(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Pharma", request);
		return mav;
	}
	
	@RequestMapping("views/Textile")
	public ModelAndView displayPortfolioTextile(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Textile", request);
		return mav;
	}
	
	@RequestMapping("views/FMCG")
	public ModelAndView displayPortfolioFMCG(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("FMCG", request);
		return mav;
	}
	
	@RequestMapping("views/Cement")
	public ModelAndView displayPortfolioCement(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Cement", request);
		return mav;
	}
	
	@RequestMapping("views/Aluminium")
	public ModelAndView displayPortfolioAluminium(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Aluminium", request);
		return mav;
	}
	
	@RequestMapping("views/Transport")
	public ModelAndView displayPortfolioTransport(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Transportation", request);
		return mav;
	}
	
	@RequestMapping("views/GeneralView")
	public ModelAndView displayPortfolioGeneral(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrdersGeneral(request);
		return mav;
	}

	
	public ModelAndView getPortfolioOrders(String name, HttpServletRequest request){
		String portfolio_name = name;
		User u = (User)request.getSession().getAttribute("user");
		Long pmID = u.getId();
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmService = container.getBean(PMServices.class);
		List<Order> ordersInPortfolio = pmService.findAllOrdersInPortfolio(portfolio_name, pmID);
				container.close();

		String messageToSend = "";
		//CONSTRUCT HTML MESSAGE HERE
		for(int i=0; i < ordersInPortfolio.size(); i++) {
			//GET TRADER'S NAME INSTEAD OF ID TO DISPLAY
			String traderIDtoDisplay = pmService.getUserName(ordersInPortfolio.get(i).getTraderId());

			messageToSend += "<div class='row'>";
			//messageToSend += "<div class='col col-sm-1'> <label>" + ordersInPortfolio.get(i).getOrderId() + "</label> </div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getSymbol() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getSide() + "</div>";
			messageToSend += "<div class='col col-sm-2 col-centered'>" + ordersInPortfolio.get(i).getOrderType() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getQualifier() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + traderIDtoDisplay + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getQtyPlaced() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getStopPrice() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getLimitPrice() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getStatus() + "</div>";
			//messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getPortfolioId() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getAccountType() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getOrderDate() + "</div>";	
			messageToSend += "</div>";			
		}

		System.out.println("IN DISPLAY PORTFOLIO, HERE'S THE HTML MESSAGE:  " + messageToSend);
		ModelAndView view = new ModelAndView("PMHistory", "message", messageToSend);
		view.addObject("specialPortfolio", true);
		return view;
	}
	
	public ModelAndView getPortfolioOrdersGeneral(HttpServletRequest request){
		User u = (User)request.getSession().getAttribute("user");
		Long pmID = u.getId();
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmService = container.getBean(PMServices.class);
		List<Order> ordersInPortfolio = pmService.findAllOrdersInPortfolio(pmID);
		container.close();

		String messageToSend = "";
		//CONSTRUCT HTML MESSAGE HERE
		for(int i=0; i < ordersInPortfolio.size(); i++) {
			messageToSend += "<div class='row'>";
			//messageToSend += "<div class='col col-sm-1'> <label>" + ordersInPortfolio.get(i).getOrderId() + "</label> </div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getSymbol() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getSide() + "</div>";
			messageToSend += "<div class='col col-sm-2 col-centered'>" + ordersInPortfolio.get(i).getOrderType() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getQualifier() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getTraderId() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getQtyPlaced() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getStopPrice() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getLimitPrice() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getStatus() + "</div>";
			//messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getPortfolioId() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getAccountType() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getOrderDate() + "</div>";	
			messageToSend += "</div>";			
		}

		
		
		System.out.println("IN DISPLAY PORTFOLIO, HERE'S THE HTML MESSAGE:  " + messageToSend);
		ModelAndView view = new ModelAndView("PMHistory", "message", messageToSend);
		view.addObject("specialPortfolio", false);
		return view;
	}
	

}
