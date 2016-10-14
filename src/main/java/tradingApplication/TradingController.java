package tradingApplication;


import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.model.Order;
import com.mock.project.service.TraderService;
import com.mock.project.service.TraderServiceImpl;
import com.mock.project.service.OrderService;


@Controller
public class TradingController {


	@RequestMapping(value = "**/fetchOrder", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
		System.out.println("test");
        httpServletResponse.setHeader("Location", "www.google.com");}
        
    @RequestMapping(value = "/views//updateTable", method = RequestMethod.GET)
    public ModelAndView methodToUpdateTable(HttpServletResponse httpServletResponse) 
    {
      	System.out.println("Updating the order table with pending orders");
      	TraderService object = new TraderServiceImpl();
      	
      	List pendingOrders=object.display();
      	return new ModelAndView("redirect:views/PendingOrders.jsp","Orders",pendingOrders);
        
     } 


	private OrderService orderService;
	
	/*@RequestMapping("/views/CreateOrder")
	public ModelAndView addCreateOrder(@ModelAttribute("order") Order d){
		d.setStatus("New");
		
		System.out.println(d);
		this.orderService.addOrder(d);
		ModelAndView view = new ModelAndView("redirect:index.jsp");
		return view;
	}*/
		
	@RequestMapping("/test")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("test");
		view.addObject("name", name);
		return view;
	}
}