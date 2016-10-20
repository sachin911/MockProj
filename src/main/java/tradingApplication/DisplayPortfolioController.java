package tradingApplication;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.mock.project.model.Holding;
import com.mock.project.model.Order;
import com.mock.project.model.User;
import com.mock.project.service.OrderService;
import com.mock.project.service.PMServices;

@Controller
public class DisplayPortfolioController {

	@RequestMapping("views/Mining")
	public ModelAndView displayPortfolioMining(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Mining", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Mining");

		return mav;
	}

	@RequestMapping("views/Banking")
	public ModelAndView displayPortfolioBanking(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Banking", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Banking");

		return mav;
	}

	@RequestMapping("views/Automobile")
	public ModelAndView displayPortfolioAutomobile(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Automobile", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Automobile");

		return mav;
	}

	@RequestMapping("views/Energy")
	public ModelAndView displayPortfolioEnergy(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Energy", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Energy");

		return mav;
	}

	@RequestMapping("views/Pharma")
	public ModelAndView displayPortfolioPharma(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Pharma", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Pharma");

		return mav;
	}

	@RequestMapping("views/Textile")
	public ModelAndView displayPortfolioTextile(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Textile", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Textile");

		return mav;
	}

	@RequestMapping("views/FMCG")
	public ModelAndView displayPortfolioFMCG(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("FMCG", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "FMCG");

		return mav;
	}

	@RequestMapping("views/Cement")
	public ModelAndView displayPortfolioCement(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Cement", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Cement");

		return mav;
	}

	@RequestMapping("views/Aluminium")
	public ModelAndView displayPortfolioAluminium(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Aluminium", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Aluminium");

		return mav;
	}

	@RequestMapping("views/Transport")
	public ModelAndView displayPortfolioTransport(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Transportation", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Transportation");

		return mav;
	}

		@RequestMapping("views/ShowAllPortfolios")
	public ModelAndView displayAllPortfolios(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("All Portfolios" ,request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "All Portfolios");
		return mav;
	}

	@RequestMapping("views/Other")
	public ModelAndView displayPortfolioOther(HttpServletRequest request){
		ModelAndView mav = getPortfolioOrders("Other", request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Other Portfolios");

		return mav;
	}

	public ModelAndView getPortfolioOrders(String name, HttpServletRequest request){
		boolean showAll = false;
		List<Order> ordersInPortfolio = new ArrayList<Order>();
		User u = (User)request.getSession().getAttribute("user");
		Long pmID = u.getId();
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmService = container.getBean(PMServices.class);

		if(name.equals("All Portfolios")){
			showAll = true;
			ordersInPortfolio = pmService.findAllHoldings(pmID);

		}

		if(showAll == false) {
			String portfolio_name = name;
			ordersInPortfolio = pmService.findAllHoldingsInPortfolio(portfolio_name, pmID);
		}

		List<String> holdingNames = new ArrayList<String>();
		List<Integer> holdingQuantity = new ArrayList<Integer>();
		for(Order o : ordersInPortfolio){
			if(holdingNames.contains(o.getSymbol())){
				int indexOfSymbol = holdingNames.indexOf(o.getSymbol());
				int currentQty= holdingQuantity.get(indexOfSymbol);
				holdingQuantity.set(indexOfSymbol,  currentQty + o.getQtyExecuted());
				System.out.println("EXISTING HOLDING! ADDING TO " + o.getSymbol() + " " + o.getQtyExecuted() + " MORE SHARES."  );
			} else {
				holdingNames.add(o.getSymbol());
				holdingQuantity.add(o.getQtyExecuted());
				System.out.println("NEW HOLDING! ADDING TO " + o.getSymbol() + " " + o.getQtyExecuted() + " SHARES."  );
			}

		}

		String messageToSend = "";
		//CONSTRUCT HTML MESSAGE HERE
		for(int i=0; i < holdingNames.size(); i++) {
			messageToSend += "<div class='row'>";
			messageToSend += "<div class='col col-sm-1'>" + holdingNames.get(i) + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + holdingQuantity.get(i) + "</div>";
			messageToSend += "</div>";			
		}

		container.close();
		System.out.println("IN DISPLAY PORTFOLIO, HERE'S THE HTML MESSAGE:  " + messageToSend);
		ModelAndView view = new ModelAndView("PortfolioHolding", "message", messageToSend);
		view.addObject("specialPortfolio", true);
		return view;
	}

	
	
	@RequestMapping("views/GeneralView")
	public ModelAndView displayHistoryGeneral(HttpServletRequest request){
		ModelAndView mav = getHistoryOrders(request);
		HttpSession session = request.getSession();
		session.setAttribute("PortfolioType", "Order History");

		return mav;
	}
	
	
	public ModelAndView getHistoryOrders(HttpServletRequest request){
		User u = (User)request.getSession().getAttribute("user");
		Long pmID = u.getId();
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices pmService = container.getBean(PMServices.class);
		List<Order> ordersInPortfolio = pmService.findAllOrdersInPortfolio(pmID);

		String messageToSend = "";
		//CONSTRUCT HTML MESSAGE HERE
		for(int i=0; i < ordersInPortfolio.size(); i++) {
			String tradeNametoDisplay = pmService.getUserName(ordersInPortfolio.get(i).getTraderId());
			messageToSend += "<div class='row'>";
			//messageToSend += "<div class='col col-sm-1'> <label>" + ordersInPortfolio.get(i).getOrderId() + "</label> </div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getSymbol() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getSide() + "</div>";
			messageToSend += "<div class='col col-sm-2 col-centered'>" + ordersInPortfolio.get(i).getOrderType() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getQualifier() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + tradeNametoDisplay + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getQtyPlaced() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getStopPrice() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getLimitPrice() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getStatus() + "</div>";
			//messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getPortfolioId() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getAccountType() + "</div>";
			messageToSend += "<div class='col col-sm-1'>" + ordersInPortfolio.get(i).getOrderDate() + "</div>";	
			messageToSend += "</div>";			
		}

		container.close();	
		System.out.println("IN DISPLAY PORTFOLIO, HERE'S THE HTML MESSAGE:  " + messageToSend);
		ModelAndView view = new ModelAndView("PMHistory", "message", messageToSend);
		return view;
	}	
}