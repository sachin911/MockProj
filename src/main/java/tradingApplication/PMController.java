package tradingApplication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.mock.project.service.PMServices;


@Controller
public class PMController {
   
@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
   public ModelAndView order(@ModelAttribute("order") Order d) {
	    d.setStatus("New");
      //  System.out.println(d);
      PMServices pmservice = null;
     // pmservice.saveOrder(d);
      ModelAndView view = new ModelAndView("redirect:PMHome.jsp");
      return view;
   }

@RequestMapping(value = "/editOrder", method = RequestMethod.POST)
public ModelAndView editorder(@ModelAttribute("order") Order d) {
	    
	//Edit order code
	
	   return new ModelAndView("Error");
}

@RequestMapping(value = "/AmmendOrder", method = RequestMethod.POST)
public ModelAndView ammendorder(@ModelAttribute("order") Order d) {

	//Ammend order code
	return new ModelAndView("Error");
}

@RequestMapping(value = "/DeleteOrder", method = RequestMethod.POST)
public ModelAndView deleteorder(@ModelAttribute("order") Order d) {

	//Delete order code
	
   return new ModelAndView("Error");
}

@RequestMapping(value = "/ViewHistory", method = RequestMethod.POST)
public ModelAndView viewhistory(@ModelAttribute("order") Order d) {
	//view history code
	return new ModelAndView("Error");
}

@RequestMapping(value = "/ViewSpecificTrade", method = RequestMethod.POST)
public ModelAndView viewspecifictrade(@ModelAttribute("order") Order d) {

	//view specific trade code
	return new ModelAndView("Error");
}


@RequestMapping(value="views/ViewOrderBlotter", method=RequestMethod.GET)

public ModelAndView UpdateOrder(HttpServletRequest req){
	
	System.out.println("we r here!!");
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
container.registerShutdownHook();
    PMServices pmsendtotrader = (PMServices) container.getBean("PMService");
  	List<Order> p=new ArrayList<Order>();
  	System.out.println("here2");
  	//User user = (User) req.getSession().getAttribute("user");
  	//Long pmId =user.getId();
  	p=pmsendtotrader.displayForPM((long) 11);
  	System.out.println("here1");
  for(Order l: p){
	  System.out.println("here");
  		System.out.println(l);
  	}
  ModelAndView model = new ModelAndView("OrderBlotter1");
	model.addObject("Orders",p);
container.close();
	return model;
  	
}




}