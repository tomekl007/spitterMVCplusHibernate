package my.spitterP.mainP;

import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "spitter")
@NamedQueries({
	@NamedQuery(name="Spitter.findById", 
			    query="select distinct s from Spitter s " +
			    		" s.id = :id")
 

})
public class Spitter {
  private Long id;
  @Size(min=3, max=20, message=
	      "Username must be between 3 and 20 characters long.") //<co id="co_enforceSize"/> 
	  @Pattern(regexp="^[a-zA-Z0-9]+$",
	        message="Username must be alphanumeric with no spaces")  //<co id="co_noSpaces"/>
  private String username;
  @Size(min=6, max=20,
          message="The password must be at least 6 characters long.") //<co id="co_enforceSize"/>
  private String password;
  @Size(min=3, max=50, message=
	      "Your full name must be between 3 and 50 characters long.")    //<co id="co_enforceSize"/> 
  private String fullName;
  private List<Spittle> spittles;
  @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", 
          message="Invalid email address.") //<co id="co_emailPattern"/>
  private String email;  
  private boolean updateByEmail;

  
  
  public Spitter(){
	  System.out.println("SPitter constructor");
	  //this.fullName="fullnameeee";
  }
  @Id
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
	  System.out.println(password);
    this.password = password;
  }

  public void setFullName(String fullName) {
	  System.out.println(fullName);
    this.fullName = fullName;
  }

  public String getFullName() {
    return fullName;
  }
  
  public void setEmail(String email) {
      this.email = email;
  }
  
  public String getEmail() {
      return email;
  }
  
  public void setSpittles(List<Spittle> spittles) {
    this.spittles = spittles;
  }

  @OneToMany(mappedBy = "spitter", cascade=CascadeType.ALL, orphanRemoval=true)
  public List<Spittle> getSpittles() {
    return spittles;
  }
  
  public void setUpdateByEmail(boolean updateByEmail) {
      this.updateByEmail = updateByEmail;
  }
  
  public boolean isUpdateByEmail() {
    return updateByEmail;
  }
  
  
  @Override
  public boolean equals(Object obj) {
	  if(obj == null)
		  return false;
    Spitter other = (Spitter) obj;
    if(other.fullName==null || other.username==null || other.password==null)
    	return false;
    System.out.println(obj);
    return other.fullName.equals(fullName) && other.username.equals(username) && other.password.equals(password);
  }
  
  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }
  
  @Override
	public String toString() {
	   
		return this.fullName +  "  " + this.email + "  " + this.username + "  " + 
		this.password;
	}
}
