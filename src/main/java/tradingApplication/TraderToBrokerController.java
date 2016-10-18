package tradingApplication;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.config.AppConfig;
import com.mock.project.jms.MarshallAndSend;
import com.mock.project.model.Block;
import com.mock.project.model.Order;
import com.mock.project.service.OrderService;

@Controller
public class TraderToBrokerController {

	@RequestMapping(value = "/views/saveBlock", method = RequestMethod.POST)
	public ModelAndView saveblock(HttpServletRequest req,HttpServletResponse httpServletResponse) throws URISyntaxException, JAXBException, Exception{
		
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        container.registerShutdownHook();
        OrderService orderService = container.getBean(OrderService.class);
		List<Integer> blockId=new ArrayList<Integer>();
		System.out.println("saveblocks");
		String[] out=req.getParameterValues("data");
		List<Block> blocks = new ArrayList<Block>();
		//System.out.println(blocks);
		//ModelAndView view = new ModelAndView("BlockBlotter");
		String[] tokens=out[0].split(",");
		for(String orderIdString:tokens)
		{
			blockId.add(Integer.parseInt(orderIdString));
			
		}
		
		
//		for(int orders1:blockId)
//		{
//			System.out.println(orders1);
//			blocks = (orderService.findBlockByBlockId(orders1));
//		}
		
		blocks = (orderService.findBlockByBlockId(1160));
		
		MarshallAndSend msobj = new MarshallAndSend();
		msobj.sendExecutedBlock(blocks);
		
		
		System.out.println(blocks);
		return null;
	}
	
}
