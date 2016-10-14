package tradingApplication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.model.User;
import com.mock.project.service.LoginService;
import com.mock.project.service.LoginServiceImpl;



@Controller
public class LoginController {
	@RequestMapping("views/handleLogin")
	public ModelAndView sysLogin(HttpServletRequest req) {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		
		//LoginService ls = new LoginServiceImpl();
		//User user = ls.checkUser(uname, pass);
		User user = new User("amy", "bbb", "PMTRADER");
		System.out.println("just got user in logincontroller");
		
		String ourType = user.getUsertype();
		
		if(ourType == "PM"){
			return new ModelAndView("PMHome", "currentUser", user);
		} else if (ourType == "TRADER"){
			return new ModelAndView("BlockBlotter", "currentUser", user);
		} else if (ourType == "PMTRADER") {
			return new ModelAndView("PMTraderSelector", "currentUser", user);
		} else {
			return new ModelAndView("type_not_found");
		}
	}
	
	@RequestMapping("views/selectPM")
	public ModelAndView selectPMLogin(HttpServletRequest req) {
		//GET USERNAME FROM SESSION
		User user = new User("amy", "bbb", "PM");
		System.out.println("just got PM in pm-trader-select");
		
		return new ModelAndView("PMHome", "currentUser", user);
	}
	
	@RequestMapping("views/selectTrader")
	public ModelAndView selectTraderLogin(HttpServletRequest req) {
		//GET USERNAME FROM SESSION
		User user = new User("bob", "bbb", "Trader");
		System.out.println("just got Trader in pm-trader-select");
		
		return new ModelAndView("BlockBlotter", "currentUser", user);
	}
	
	
}
