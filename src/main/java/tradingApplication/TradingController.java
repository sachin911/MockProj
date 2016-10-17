package tradingApplication;


import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletResponse;
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
import com.mock.project.service.OrderService;
import com.mock.project.service.OrderServiceImpl;
import javax.servlet.http.HttpServletRequest;



@Controller
public class TradingController {
	TraderService traderService=new TraderService();
	@RequestMapping(value = "/views/fetchOrder5", method = RequestMethod.POST)
    public ModelAndView method5(HttpServletRequest req,HttpServletResponse httpServletResponse) {
	//String []out=req.getParameter("check");	
		
	 System.out.println("testasbasd");
	 List<Integer> orderId=new ArrayList<Integer>();
		String[] out=req.getParameterValues("data");
	
		String[] tokens=out[0].split(",");
		 System.out.println("testasbasd");
		for(String order:tokens)
		{
			orderId.add(Integer.parseInt(order));
			
		}
		for(int order:orderId)
		{
			System.out.println(order);
			
		}
		return traderService.recommend(orderId); 


} 
	
	
		@RequestMapping(value = "/views/fetchOrder", method = RequestMethod.POST)
		    public ModelAndView method(HttpServletRequest req,HttpServletResponse httpServletResponse) {
			 String[] selectedUserIdParameter = req.getParameterValues("data");
			 System.out.println("yup1"+ selectedUserIdParameter[0]);
			for(int i=0;i<selectedUserIdParameter.length;i++){
				 System.out.println(selectedUserIdParameter[i]);
			}
						
			 System.out.println("yup");
			// System.out.println(out);
				
		        //httpServletResponse.setHeader("Location", "www.google.com"); 
			// ModelAndView model = new ModelAndView("PendingOrders");
				

				return null;


}
		@RequestMapping(value = "/views/updateTable", method = RequestMethod.GET)
	    public ModelAndView methodToUpdateTable(HttpServletResponse httpServletResponse) 
	    {
	      	System.out.println("Updating the order table with pending orders");
	      	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
            container.registerShutdownHook();
            OrderService orderService = container.getBean(OrderService.class);
	      	List<Order> p=new ArrayList<Order>();
	      	System.out.println("here2");
	      	p=orderService.displaylist();
	      	System.out.println("here1");
	      for(Order l: p){
	    	  System.out.println("here");
	      		System.out.println(l);
	      	}
	      ModelAndView model = new ModelAndView("PendingOrders");
			model.addObject("Orders",p);

			return model;
	      	
	      // httpServletResponse.setHeader("Location", "www.google.com");
			
	    
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