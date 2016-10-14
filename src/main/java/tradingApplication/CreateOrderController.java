package tradingApplication;
import org.springframework.stereotype.Controller;


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

@Controller
public class CreateOrderController {

                
                
                @RequestMapping("/views/CreateOrder")
                public ModelAndView addCreateOrder(@ModelAttribute("order") Order d){
                                
                                d.setStatus("New");
                                
                                System.out.println(d);
                                AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
                                container.registerShutdownHook();
                                OrderService orderService = container.getBean(OrderService.class);
                                orderService.addOrder(d);
                                
                                container.close();

                                ModelAndView view = new ModelAndView("redirect:CreateTrade.jsp");
                                return view;
                }
}
