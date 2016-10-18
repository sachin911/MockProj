package tradingApplication;


import java.util.ArrayList;

import java.util.Arrays;

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

import com.mock.project.dao.OrderDAO;
import com.mock.project.dao.OrderDAOImpl;

import com.mock.project.model.Block;
import com.mock.project.model.Order;
import com.mock.project.model.User;
import com.mock.project.service.OrderService;
import com.mock.project.service.OrderServiceImpl;
import com.mock.project.service.TraderService;


import javax.servlet.http.HttpServletRequest;



@Controller
public class TradingController {

	
	ModelAndView model = new ModelAndView("PendingOrders");
	
	@RequestMapping(value = "/views/fetchOrder5", method = RequestMethod.GET)
    public ModelAndView method5(HttpServletRequest req,HttpServletResponse httpServletResponse) {
	//String []out=req.getParameter("check");	
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();
        OrderService orderService = container.getBean(OrderService.class);
	 System.out.println("testasbasd");
	 List<Block> r=new ArrayList<Block>();
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
		r=orderService.recommend(orderId);
		for(Block b: r){
			System.out.println(b);
		}
		 
		
		model.addObject("Blocks",r);
		//container.close();
		return model;


} 
	@RequestMapping(value = "/views/fetchOrder6", method = RequestMethod.GET)
    public ModelAndView method6(HttpServletRequest req,HttpServletResponse httpServletResponse) {
	//String []out=req.getParameter("check");	
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();
        TraderService traderService = container.getBean(TraderService.class);
	 System.out.println("mango");
	int bid;
	String []blockId=(req.getParameterValues("data"));
	System.out.println("aftergetparameter");
	System.out.println(blockId[0]);
	String[] tokens=blockId[0].split(",");
	
		//String[] tokens=out[0].split(",");
		 System.out.println("testasbasd");
		 bid=Integer.parseInt(tokens[0]);
		 System.out.println(bid);
		
		
		 traderService.addToSelectedBlock(bid);
		
		
		//model.addObject("Blocks",r);
		//container.close();
		return null;


} 
	
	

		@RequestMapping(value = "/views/fetchOrder", method = RequestMethod.POST)
		    public ModelAndView method(HttpServletRequest req,HttpServletResponse httpServletResponse) {
			//String []out=req.getParameter("check");				

			// System.out.println("testasbasd");

			// System.out.println(out);
				
		        //httpServletResponse.setHeader("Location", "www.google.com"); 
				return null;


}

		
		@RequestMapping(value = "/views/fetchOrder2", method = RequestMethod.POST)
	    public ModelAndView method2(HttpServletRequest req,HttpServletResponse httpServletResponse) {
			
			AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
            container.registerShutdownHook();
            OrderService orderService = container.getBean(OrderService.class);
			System.out.println("abheejeet");
			List<Integer> orderId=new ArrayList<Integer>();
			String[] out=req.getParameterValues("data");
			List<Order> orders = new ArrayList<Order>();
			String[] tokens=out[0].split(",");
			for(String orderIdString:tokens)
			{
				orderId.add(Integer.parseInt(orderIdString));
				
			}
			for(int orders1:orderId)
			{
				//System.out.println(orders1);
				orders.add(orderService.findOrderByOrderId(orders1));
			}
		//	System.out.println("dsjkaskdasjksajsa: "+orders.size());
			TraderService traderSevice=container.getBean(TraderService.class);
			traderSevice.createBlock(orders);
			return null;
		}

		
		@RequestMapping(value = "/views/updateTable", method = RequestMethod.GET)
	    public ModelAndView methodToUpdateTable(HttpServletResponse httpServletResponse) 
	    {
	      	//System.out.println("Updating the order table with pending orders");

	      	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
            container.registerShutdownHook();
            OrderService orderService = container.getBean(OrderService.class);
	      	List<Order> p=new ArrayList<Order>();

	   

	      	//System.out.println("here2");
	      	p=orderService.displaylist();
	      	//System.out.println("here1");
	      for(Order l: p){
	    	  //System.out.println("here");
	      		//System.out.println(l);
	      	}
	    
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
		//System.out.println("teststst");
		ModelAndView view = new ModelAndView("test");
		view.addObject("name", name);
		return view;
	}

	
	
	@RequestMapping(value = "/views/PopulateBB", method = RequestMethod.GET)
    public ModelAndView populateBlockBlotter(HttpServletResponse httpServletResponse) 
    {

      
      	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();
      
        OrderService orderService = container.getBean(OrderService.class);
      
      	List<Order> block=new ArrayList<Order>();
      	block = orderService.displaylist(5);

      	ModelAndView model = new ModelAndView("BlockBlotter");
		model.addObject("Blocks",block);
		

		return model;	
    }
	
	
	@RequestMapping(value = "/views/PopulateOrders", method = RequestMethod.POST)
    public ModelAndView populateOrders(HttpServletRequest req,HttpServletResponse httpServletResponse) 
    {
      
      	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();
      
        OrderService orderService = container.getBean(OrderService.class);
        
        String arr[] = req.getParameterValues("data");
        System.out.println(arr[0]);
        System.out.println("inPopulatesadplpasdlpasd");
    	List<Order> O=new ArrayList<Order>();
      	O = orderService.displaylist(5);
      
      	ModelAndView model = new ModelAndView("BlockBlotter");
		model.addObject("Orders",O);
		

		return model;	
    }
	
	@RequestMapping(value = "/views/PopulateTraderHistory", method = RequestMethod.GET)
    public ModelAndView PopulateTraderHistory( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) 
    {
      //	System.out.println("Comes here");
      	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();
      //  System.out.println("Comes here too");
        OrderService orderService = container.getBean(OrderService.class);
    //    System.out.println("Maybe comes here too");
      	List<Order> Blocks =new ArrayList<Order>();
    	
      	
      	// User user = (User) httpServletRequest.getSession().getAttribute("user");
    	
      //	Blocks = orderService.displaylist(user.getId());
      	
      	Blocks = orderService.displaylist(5);
      
      	ModelAndView model = new ModelAndView("TradeHistoryTemp");
		model.addObject("Blocks",Blocks);
		

		return model;
		
    }
    
}
	
	




