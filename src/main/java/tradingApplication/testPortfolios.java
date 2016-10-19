package tradingApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mock.project.config.AppConfig;
import com.mock.project.model.Portfolio;
import com.mock.project.service.OrderService;
import com.mock.project.service.PMServices;

public class testPortfolios {
	
	@PersistenceContext
	private static EntityManager em;

	public static void main(String[] args) {

		Portfolio p1 = new Portfolio("Aluminium");
		Portfolio p2 = new Portfolio("Transportation");
//		Portfolio p3 = new Portfolio("Automobile");
//		Portfolio p4 = new Portfolio("Energy");
		
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		container.registerShutdownHook();
		PMServices portcreate = (PMServices) container.getBean("PMService");
		portcreate.addPort(p1);
		portcreate.addPort(p2);
//		portcreate.addPort(p3);
//		portcreate.addPort(p4);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());

		/*em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
*/
		
//		d.setPmId(u.getId());
//		orderService.addOrder(d);

		container.close();

	}
}
