package my.spitterP.mainP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;



@Component
public class HibernateSpitterDaoFromTemplate implements SpitterDao {
 
	
	@Autowired
  private HibernateTemplate template;
  
 // public HibernateTemplate getTemplate() {
//	return template;
//}

//public void setTemplate(HibernateTemplate template) {
//	this.template = template;
//}

public void addSpitter(Spitter spitter) {
    template.saveOrUpdate(spitter);
  }

  public Spitter getSpitterById(long id) {
	  System.out.println("getting spitter for id : "  + id );
    return template.get(Spitter.class, id);
  }

  public void saveSpitter(Spitter spitter) {
    template.update(spitter);
  }

  public List<Spittle> getRecentSpittle() {
	  System.out.println("load all spittle");
    return template.loadAll(Spittle.class); // this isn't right...just a placeholder for now
  }

  public void saveSpittle(Spittle spittle) {
    template.save(spittle);
  }

  public List<Spittle> getSpittlesForSpitter(
          Spitter spitter) {
  
	  String queryAll = "SELECT s FROM Spittle s  ";

	 ArrayList<Spittle> s = (ArrayList<Spittle>) template.find(queryAll);
	  System.out.println("find spittles : "  + s.toString());
	  
	  
	  //---
	 // String queryString = "SELECT s FROM Spittle s WHERE s.spitter.id = 1 ";
	 // String queryString2 = "SELECT s FROM Spittle s JOIN s.spitter";
	 
	  
	  
	//  ArrayList<Spittle> s2 = (ArrayList<Spittle>) template.find(queryString2,spitter.getId());
	//  System.out.println("find spittles : "  + s2.toString());
	  
	  
	  System.out.println("spitter id = "  + spitter.getId());
	  String queryString3 = "SELECT distinct s FROM Spitter s ";
	  Spitter sp2  = template.get(Spitter.class, spitter.getId());
	  System.out.println(sp2.getSpittles());
	  ArrayList<Spitter> s3 = (ArrayList<Spitter>) template.find(queryString3);
	  System.out.println(s3.toString());
	  System.out.println(s3.get(0).getSpittles());
	
	  
	  return s;
	  
  }
  

  public Spitter getSpitterByUsername(String username) {
	  
    ArrayList<Spitter> s = (ArrayList)template.find("SELECT distinct s FROM Spitter s WHERE s.username=?", username);
	System.out.println("find s by user Name : " + s.toString());
	  return s.get(0);
	  
  }

  public void deleteSpittle(long id) {
    template.delete(getSpittleById(id));
  }

  public Spittle getSpittleById(long id) {
    return template.get(Spittle.class, id);
  }
  
  public List<Spitter> findAllSpitters() {
	  return template.loadAll(Spitter.class); // this isn't right...just a placeholder for now
 
  }
}
