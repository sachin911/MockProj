package tradingApplication;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.model.Order;
import com.mock.project.service.OrderService;
import com.mock.project.service.OrderServiceImpl;
import javax.servlet.http.HttpServletRequest;
@Controller
public class TradingController {
		@RequestMapping(value = "/views/fetchOrder", method = RequestMethod.POST)
		    public ModelAndView method(HttpServletRequest req,HttpServletResponse httpServletResponse) {
			//String []out=req.getParameter("check");				
			 System.out.println("test");
			// System.out.println(out);
				
		        //httpServletResponse.setHeader("Location", "www.google.com"); 
				return null;

}
		@RequestMapping(value = "/views/updateTable", method = RequestMethod.GET)
	    public ModelAndView methodToUpdateTable(HttpServletResponse httpServletResponse) 
	    {
	      	System.out.println("Updating the order table with pending orders");
	      	OrderService object = new OrderServiceImpl();
	      	
	      	List<Order> p=new ArrayList<Order>();
	      	System.out.println("here2");
	      	p=object.display();
	      	
	      	System.out.println("here1");
	      for(Order l: p){
	    	  System.out.println("here");
	      		System.out.println(l);
	      	}
	      	return new ModelAndView("redirect:views/PendingOrders.jsp","Orders",p);
	      // httpServletResponse.setHeader("Location", "www.google.com");
			
	    
	    }  
}