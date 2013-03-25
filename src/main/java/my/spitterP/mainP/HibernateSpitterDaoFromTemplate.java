package my.spitterP.mainP;

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
    // TODO Auto-generated method stub
    return null;
  }
  

  public Spitter getSpitterByUsername(String username) {
    // TODO Auto-generated method stub
    return null;
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
