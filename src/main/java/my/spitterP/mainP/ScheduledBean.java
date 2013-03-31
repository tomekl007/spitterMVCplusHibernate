package my.spitterP.mainP;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledBean {

	
//	//Seconds (0-59)
//	2 Minutes (0-59)
//	3 Hours (0-23)
//	4 Day of month (1-31)
//	5 Month (1-12 or JAN-DEC)
//	6 Day of week (1-7 or SUN-SAT)
//	7 Year (1970-2099)
  @Scheduled(cron="0 0 0 * * SAT")
  public void archiveOldSpittles() {
    // ...
  }
  
  
  //@Scheduled(fixedRate=100000)
  public void scheduledMethod1(){
	  System.out.println("->in scheduled method 1");
  }
  
 // @Scheduled(fixedDelay=100000)//counted from time when method invocation ends
  public void scheduledMethod2(){
	 System.out.println("->in scheduled method 2");
     try {
		
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
  }
  
//async with returning obj
  @Async
  public Future<Long> performSomeReallyHairyMath(long input){
  
  System.out.println("calling async method");
  try {
	Thread.sleep(10000);
  } catch (InterruptedException e) {
	
	e.printStackTrace();
  }
  long result = 1l;
	  
  return new AsyncResult<Long>(result);
  }
  
  
}
