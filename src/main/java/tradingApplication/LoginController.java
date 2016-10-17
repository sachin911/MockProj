package tradingApplication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.config.AppConfig;
import com.mock.project.model.Order;
import com.mock.project.model.User;
import com.mock.project.service.LoginService;
import com.mock.project.service.LoginServiceImpl;
import com.mock.project.service.OrderService;



@Controller
public class LoginController {
	@RequestMapping("views/handleLogin")
	public ModelAndView sysLogin(@ModelAttribute("user") User u, HttpServletRequest request) {

		String usern = request.getParameter("username");
		u.setName(usern);
		System.out.println("Received user:" + u.toString());
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		LoginService loginService = container.getBean(LoginService.class);
		User completeUser = loginService.checkUser(usern, u.getPassword());
		container.close();
		if(completeUser == null)	{
			return new ModelAndView("LoginFailed", "message", "Login failed, wrong username or password combination.");
		}

		System.out.println("just got user in logincontroller");
		request.getSession().setAttribute("user", completeUser);
		String ourType = completeUser.getUsertype();
		System.out.println("LoginController:  completeUser: " + completeUser.toString());
		
		if(ourType.equals("PM")){
			return new ModelAndView("PMHome");
		} else if (ourType.equals("TRADER")){
			return new ModelAndView("BlockBlotter");
		} else if (ourType.equals("PMTRADER")) {
			return new ModelAndView("PMTraderSelector");
		} else {
			return new ModelAndView("type_not_found");
		}
	}
	
	@RequestMapping("views/selectPM")
	public ModelAndView selectPM(@ModelAttribute("user") User u, HttpServletRequest request) {
		request.getSession().setAttribute("currentType", "PM");
		return new ModelAndView("PMHome");	
	}
	
	@RequestMapping("views/selectTrader")
	public ModelAndView selectTrader(HttpServletRequest request) {
		request.getSession().setAttribute("currentType", "Trader");
		return new ModelAndView("BlockBlotter");	
	}
		
	public void manualAddUser(User u){
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		LoginService loginService = container.getBean(LoginService.class);
		loginService.addUser(u);
	}


}
