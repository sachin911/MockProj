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


	public TradingController() {
	super();
	} 
	

	private OrderService orderService;

	ModelAndView model = new ModelAndView("PendingOrders1");
	
	
	
	
	@RequestMapping(value = "/views/recommendBlock", method = RequestMethod.GET)
	public ModelAndView recommendBlock(HttpServletRequest req,HttpServletResponse httpServletResponse) {
		//String []out=req.getParameter("check");	
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		OrderService orderService = container.getBean(OrderService.class);
		List<Block> r=new ArrayList<Block>();
		List<Integer> orderId=new ArrayList<Integer>();
		String[] out=req.getParameterValues("data");

		String[] tokens=out[0].split(",");
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
	@RequestMapping(value = "/views/addToBlock", method = RequestMethod.GET)
	public ModelAndView addToBlock(HttpServletRequest req,HttpServletResponse httpServletResponse) {
		//String []out=req.getParameter("check");	
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		TraderService traderService = container.getBean(TraderService.class);
		int bid;
		String[] blockId=(req.getParameterValues("data"));
		System.out.println(blockId[0]);
		String[] tokens=blockId[0].split(",");

		//String[] tokens=out[0].split(",");
		bid=Integer.parseInt(tokens[0]);
		System.out.println(bid);


		traderService.addToSelectedBlock(bid);


		//model.addObject("Blocks",r);
		//container.close();
		return null;


	} 


	@RequestMapping(value = "/views/createBlock", method = RequestMethod.POST)
	public ModelAndView createBlock(HttpServletRequest req,HttpServletResponse httpServletResponse) {
		
		
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		OrderService orderService = container.getBean(OrderService.class);
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
		TraderService traderSevice=container.getBean(TraderService.class);
		traderSevice.createBlock(orders);
		return null;
	}


	@RequestMapping(value = "/views/updateTable", method = RequestMethod.GET)
	public ModelAndView methodToUpdateTable(HttpServletResponse httpServletResponse) 
	{
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		OrderService orderService = container.getBean(OrderService.class);
		List<Order> p=new ArrayList<Order>();


		p=orderService.displaylist();
		

		model.addObject("Orders",p);

		return model;
	}  


	
	@RequestMapping("/test")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {
		// Name of your jsp file as parameter
		//System.out.println("teststst");
		ModelAndView view = new ModelAndView("test");
		view.addObject("name", name);
		return view;
	}



	@RequestMapping(value = "/views/PopulateBB", method = RequestMethod.GET)

    public ModelAndView populateBlockBlotter(HttpServletRequest req) 
    {

      
      	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();
      
        OrderService orderService = container.getBean(OrderService.class);
      
      	User user = (User) req.getSession().getAttribute("user");
      	int trader_id = (int) user.getId();
      	
        
        List<Block> Blocks =new ArrayList<Block>();
      	Blocks = orderService.displayBlock(trader_id);

      	ModelAndView model = new ModelAndView("BlockBlotter");

		model.addObject("Blocks",Blocks);


		return model;	
	}


	@RequestMapping(value = "/views/removeBlock", method = RequestMethod.GET)
	public ModelAndView removeBlock(HttpServletRequest req,HttpServletResponse httpServletResponse) 
	{


		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();  
		OrderService orderService = container.getBean(OrderService.class);
		List<Integer> blockId=new ArrayList<Integer>();
		List<Block> blocks=new ArrayList<Block>();
		System.out.println("remove block");
		String[] out=req.getParameterValues("data");
		String[] tokens=out[0].split(",");
		for(String blockIdString:tokens){
			blockId.add(Integer.parseInt(blockIdString));	
		}
		for(int block1:blockId){
			blocks.add(orderService.findBlockByBlockId(block1));
		}
		for(Block b:blocks){
			orderService.removeBlock(b);
		}
		return null;	
	}


	@RequestMapping(value = "/views/PopulateOrders", method = RequestMethod.POST)
	public ModelAndView populateOrders(HttpServletRequest req,HttpServletResponse httpServletResponse) 
	{

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();

		OrderService orderService = container.getBean(OrderService.class);

		String arr[] = req.getParameterValues("data");
		// System.out.println(arr[0]);
		//  System.out.println("inPopulatesadplpasdlpasd");
		/*	List<Order> O=new ArrayList<Order>();
      	O = orderService.displaylist(blockId);*/

		ModelAndView model = new ModelAndView("BlockBlotter");
		//model.addObject("Orders",O);


		return model;	
	}

	@RequestMapping(value = "/views/PopulateTraderHistory", method = RequestMethod.GET)
	public ModelAndView populateTraderHistory(HttpServletResponse httpServletResponse) 
	{
		//	System.out.println("Comes here");
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		//  System.out.println("Comes here too");
		OrderService orderService = container.getBean(OrderService.class);
		//    System.out.println("Maybe comes here too");
		List<Block> Blocks =new ArrayList<Block>();
		Blocks = orderService.displayBlockHistory(5);

		ModelAndView model = new ModelAndView("TradeHistoryTemp");
		model.addObject("Blocks",Blocks);


		return model;
		// httpServletResponse.setHeader("Location", "www.google.com");

	}

	@RequestMapping(value = "/views/fetchOrderInBlock", method = RequestMethod.GET)
	public ModelAndView fetchOrderInBlock(HttpServletRequest req,HttpServletResponse httpServletResponse) 
	{

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();   
		OrderService orderService = container.getBean(OrderService.class); 
		List<Order> Orders =new ArrayList<Order>();
		String[] out=req.getParameterValues("data");
		//System.out.println(out[0]);
		int BlockId = Integer.parseInt(out[0]);
		Orders = orderService.findOrdersInBlock(BlockId);
		//System.out.println(Orders);
		ModelAndView model = new ModelAndView("TradeHistoryTemp");
		model.addObject("Orders",Orders);	
		return model;

	}


}





