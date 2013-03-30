package my.spitterP.mainP;

import java.util.List;

import javax.inject.Inject;

import my.spitterP.mainP.alerts.AlertMessageReceiver;
import my.spitterP.mainP.alerts.AlertService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/account")
public class AccountController {
	
	AlertService alertService;
	@Inject
	public void setAlertService(AlertService alertService) {
		this.alertService = alertService;
	}
	
	AlertMessageReceiver alertMessageReceiver;
	@Inject
	public void setAlertMessageReceiver(AlertMessageReceiver alertMessageReceiver) {
		this.alertMessageReceiver = alertMessageReceiver;
	}



	
	
	 @RequestMapping(value="/resend_password", 
	          method=RequestMethod.GET)
	  	public String resendPassword() {
		 	System.out.println("resending ");
		 	//something not accordance with name of function
		 	Spittle s = new Spittle();
		 	s.setSpittleText("wyslany spittle");
		 	alertService.sendSpittleAlert(s);
		 	return "/";

	}
	 
	 
	 @RequestMapping(value="/retrive_password", 
	          method=RequestMethod.GET)
	  	public String retrivePassword() {
		 	System.out.println("resending ");
		 	//something not accordance with name of function
		 	System.out.println("receive alert " +  alertMessageReceiver.getAlert());
		 	return "/";

	}


	

}
