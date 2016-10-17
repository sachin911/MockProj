package tradingApplication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.model.Order;
import com.mock.project.service.PMSendToTrader;
import com.mock.project.service.PMSendToTraderImpl;

@Controller
public class PmSendToTraderController {

		private PMSendToTrader pMSendToTrader;
		
//		@Autowired(required=true)
//		@Qualifier(value="pmService")
//		public void setPMService(PMSendToTrader ps){
//			this.pMSendToTrader = ps;
//		}
		
		 @RequestMapping(value="views/PmSend", method=RequestMethod.POST)
		 
		public ModelAndView UpdateOrder(@ModelAttribute("functionList")List<Order> orders){
			
			System.out.println("we r here!!");
			String status="new";
			List<Order> p=new ArrayList<Order>();
			
			PMSendToTraderImpl pMSendToTraderImpl=new PMSendToTraderImpl();
			
			pMSendToTraderImpl.updateStatus(p, status);
			
			 return new ModelAndView("redirect:OrderBlotter1.jsp","Orders",p);
		 }
			//@ResponseBody
//			public String SendMsg(){
//				return "OrderBlotter1"; 
//			//pMSendToTraderImpl.updateStatus(order_id, status);
//		}
//		
		
}
