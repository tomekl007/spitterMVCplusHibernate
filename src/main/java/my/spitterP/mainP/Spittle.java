package my.spitterP.mainP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import my.spitterP.mainP.Spitter;

//@Table(name = "spittle")
@Entity

public class Spittle implements Serializable {
  private Long id;
  private Spitter spitter;
  
  public Spitter getSpitter() {
	return spitter;
}
public void setSpitter(Spitter spitter) {
	this.spitter = spitter;
}

private String text;
  public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}

private Date when;

  public Date getWhen() {
	return when;
}
public void setWhen(Date when) {
	this.when = when;
}
public Spittle() {
    this.spitter = new Spitter();  // HARD-CODED FOR NOW
    this.spitter.setId((long)1);
  }
  @Id
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getSpittleText() {
    return this.text;
  }
  
  public void setSpittleText(String text) {
    this.text = text;
  }
  
  public Date getPostedTime() {
    return this.when;
  }

  public void setPostedTime(Date when) {
    this.when = when;
  }

  @ManyToOne
 @JoinColumn(name = "SPITTER_ID")
  public Spitter getSpitter_id() {
    return this.spitter;
  }

  public void setSpitter_id(Spitter spitter) {
    this.spitter = spitter;
  }
  
  @Override
	public String toString() {
		
		return text;
	}
}
