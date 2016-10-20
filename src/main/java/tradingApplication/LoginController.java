package tradingApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		if(completeUser == null){
			return new ModelAndView("Login", "message", "Login failed,  this username does not exist. Please try again.");
		} else if(completeUser.getName() == null && completeUser.getPassword() == null) {
			return new ModelAndView("Login", "message", "Login failed, you have entered the wrong password. Please try again.");
		}

		System.out.println("just got user in logincontroller");
		request.getSession().setAttribute("user", completeUser);
		String ourType = completeUser.getUsertype();
		System.out.println("LoginController:  completeUser: " + completeUser.toString());
		
		
		// gg & devil starts
		
					HttpSession session = request.getSession();
				    session.setAttribute("UserType", ourType);
				
		// gg completes here

		
		
		if(ourType.equals("PM")){
			request.getSession().setAttribute("currentType", "PM");
			return new ModelAndView("PMHome");
		} else if (ourType.equals("TRADER")){
			request.getSession().setAttribute("currentType", "Trader");
			return new ModelAndView("TraderHome");
		} else if (ourType.equals("PMTRADER")) {
			request.getSession().setAttribute("currentType", "PM");
			return new ModelAndView("PMHome");
		} else {
			request.getSession().setAttribute("currentType", "TYPENOTFOUNDERROR");
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
		return new ModelAndView("PopulateBB");	
	}
		
	public void manualAddUser(User u){
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		LoginService loginService = container.getBean(LoginService.class);
		loginService.addUser(u);
	}
	
	@RequestMapping("views/logout")
	public ModelAndView handleLogout(HttpServletRequest request) {
		//GET USERNAME FROM SESSION
		System.out.println("Attempted logout");
		request.getSession().setAttribute("user", null);
		return new ModelAndView("Login");
	}	
}
