package tradingApplication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.model.User;
import com.mock.project.service.LoginService;
import com.mock.project.service.LoginServiceImpl;



@Controller
//@RequestMapping("views/login")
public class LoginController {
	@RequestMapping("views/hello")

	public ModelAndView sysLogin(HttpServletRequest req) {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		
		//LoginService ls = new LoginServiceImpl();
		//User user = ls.checkUser(uname, pass);
		User user = new User("amy", "bbb", "PM");
		System.out.println("just got user in logincontroller");
		
		String ourType = user.getUsertype();
		
		if(ourType == "PM"){
			return new ModelAndView("PMHome", "currentUser", user);
		} else if (ourType == "TRADER"){
			return new ModelAndView("TRADERpage", "currentUser", user);
		} else if (ourType == "PMTRADER") {
			return new ModelAndView("PMTRADERpage", "currentUser", user);
		} else {
			return new ModelAndView("type_not_found");
		}
	}
}
		/*
		if(ourType == "PM"){
			//get pm page
			windowToOpen = "PMHome";
		} else if (ourType == "TRADER"){
			//get trader page
			windowToOpen = "TraderHistory";
		} else if (ourType == "PMTRADER") {
			//popup window asking which one you want to log in as
			windowToOpen = "PMTraderPopup";
		}
		*/