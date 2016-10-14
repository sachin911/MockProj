package tradingApplication;

import java.util.List;



import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.model.Order;
import com.mock.project.service.TraderService;
import com.mock.project.service.TraderServiceImpl;

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

}