package my.spitterP.mainP;

import static java.lang.Math.*;
import static java.util.Collections.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Component("spitterService")
@Transactional(propagation=Propagation.REQUIRED)
public class SpitterServiceImplDeclarative implements SpitterService {

	//@Secured("ROLE_SPITTER","ROLE_ADMIN)
  //<start id="java_addSpittle" /> 
  public void saveSpittle(Spittle spittle) {   
	
    spitterDao.saveSpittle(spittle);
  }
  //<end id="java_addSpittle" />

  @Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
  public List<Spittle> getRecentSpittles(int count) {
    List<Spittle> recentSpittles = 
        spitterDao.getRecentSpittle();
    
    reverse(recentSpittles);
    
    return recentSpittles.subList(0, 
            min(49, recentSpittles.size()));
  }
  
  public void saveSpitter(Spitter spitter) {
    if(spitter.getId() == null) {
      spitterDao.addSpitter(spitter);
    } else {
      spitterDao.saveSpitter(spitter);
    }
  }
  
  //@Autowired
  SpitterDao spitterDao;
  public void setSpitterDao(SpitterDao spitterDao) {
	  System.out.println("spitterDao set to : " + spitterDao);
	    this.spitterDao = spitterDao;
	  }

  public Spitter getSpitter(long id) {
    System.out.println("-->getSpitter");
    return spitterDao.getSpitterById(id);
  }

  public void startFollowing(Spitter follower, Spitter followee) {
    // TODO Auto-generated method stub
    
  }
  
  public Spitter getSpitter(String username) {
    return spitterDao.getSpitterByUsername(username);
  }

  public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
	
    return spitterDao.getSpittlesForSpitter(spitter);
  }

  public List<Spittle> getSpittlesForSpitter(String username) {
    Spitter spitter = spitterDao.getSpitterByUsername(username);
    return getSpittlesForSpitter(spitter);
  }
  
  public List<Spitter> getAllSpitters() {
    return spitterDao.findAllSpitters();
  }

  public void deleteSpittle(long id) {
    spitterDao.deleteSpittle(id);
  }

  
  //@PostAuthorize("returnObject.spitter.username==principal.username")
  public Spittle getSpittleById(long id) {
    return spitterDao.getSpittleById(id);
  }
}
