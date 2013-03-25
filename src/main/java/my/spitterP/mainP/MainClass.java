package my.spitterP.mainP;



import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/conf.xml");
		ctx.refresh();
		
		SpitterDao spitterDao = ctx.getBean("databaseFacade", SpitterDao.class);
		
		Spitter s = spitterDao.getSpitterById(1);
		System.out.println(s.getFullName());
		List<Spitter> lS = spitterDao.findAllSpitters();
		System.out.println(lS);
		
		//List<Spittle> lS2 = spitterDao.getRecentSpittle();
		//System.out.println(lS2);
		
		
		Spittle spittle = spitterDao.getSpittleById(1);
		System.out.println(spittle.getSpittleText());
		SpitterService spitterService = ctx.getBean("spitterServiceDecl", SpitterService.class);
		
		Spitter s2 = new Spitter();
	    //s2.setId((long)6);
	    s2.setUsername("matWA");
	    s2.setPassword("222");
	    s2.setUpdateByEmail(true);
	    s2.setFullName("Mateusz Waclaw");
	    s2.setEmail("email@email");
	    
		spitterService.saveSpitter(s2);
		s2.setFullName("modify");
		spitterService.saveSpitter(s2);
		
		List<Spitter> lS2 = spitterDao.findAllSpitters();
		System.out.println(lS2);
		
		System.out.println(spitterService.getRecentSpittles(10));
		System.out.println(spittle.getSpitter().getUsername());
		
		System.out.println(spitterDao.getSpitterById(1));
		
		
		Spitter spitter1 = spitterDao.getSpitterByUsername("habuma");
		System.out.println(spitter1.getSpittles());
		System.out.println( spitterDao.getSpittlesForSpitter(spitter1));
		
		
	}

}
