package com.sapient.main;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sapient.service.BrokerService;
import com.sapient.service.BrokerServiceImpl;
@Component
public class EODScheduler {
	private static final Logger log = LoggerFactory.getLogger(EODScheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Scheduled(cron = "0 0 15 * * *")
     public void cronTask(){
    
     System.out.println(new Date() + " This runs in a cron schedule");
     BrokerService bs=new BrokerServiceImpl();
    bs.expireblocks();		 
    
     }

}
