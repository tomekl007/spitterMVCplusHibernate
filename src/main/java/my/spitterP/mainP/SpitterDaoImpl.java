package my.spitterP.mainP;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import my.spitterP.mainP.Spitter;


@Repository("SpitterDao")
@Transactional
public class SpitterDaoImpl implements SpitterDao {
	
	private Log log = LogFactory.getLog(SpitterDaoImpl.class);
	
	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//inject sessionFactory
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void addSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		
	}

	public void saveSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		
	}

	public Spitter getSpitterById(long id) {
		return (Spitter) sessionFactory.getCurrentSession().
				getNamedQuery("Spitter.findById").setParameter("id", id).uniqueResult();
		
	}

	public List<Spittle> getRecentSpittle() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveSpittle(Spittle spittle) {
		// TODO Auto-generated method stub
		
	}

	public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Spitter getSpitterByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteSpittle(long id) {
		// TODO Auto-generated method stub
		
	}

	public Spittle getSpittleById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Spitter> findAllSpitters() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
