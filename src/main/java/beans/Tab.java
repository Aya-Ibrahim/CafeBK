package beans;
// Generated May 12, 2017 3:22:27 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tab generated by hbm2java
 */
@Entity
@Table(name="tab"
    ,catalog="arkancafe"
)
public class Tab  implements java.io.Serializable {


     private Integer tabId;
     private String tabName;
     private Set<Service> services = new HashSet<Service>(0);
     private Set<Game> games = new HashSet<Game>(0);

    public Tab() {
    }

	
    public Tab(String tabName) {
        this.tabName = tabName;
    }
    public Tab(String tabName, Set<Service> services, Set<Game> games) {
       this.tabName = tabName;
       this.services = services;
       this.games = games;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="tab_id", unique=true, nullable=false)
    public Integer getTabId() {
        return this.tabId;
    }
    
    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    
    @Column(name="tab_name", nullable=false, length=50)
    public String getTabName() {
        return this.tabName;
    }
    
    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tab")
    public Set<Service> getServices() {
        return this.services;
    }
    
    public void setServices(Set<Service> services) {
        this.services = services;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tab")
    public Set<Game> getGames() {
        return this.games;
    }
    
    public void setGames(Set<Game> games) {
        this.games = games;
    }




}


