package tradingApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TraderToBrokerController {

	@RequestMapping(value = "/views/saveBlock", method = RequestMethod.POST)
	public ModelAndView saveblock(){
		
		System.out.println("saveblocks");
		
		ModelAndView view = new ModelAndView("BlockBlotter");
		
		return view;
	}
	
}
