package beans;
// Generated May 12, 2017 3:22:27 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GameLine generated by hbm2java
 */
@Entity
@Table(name="game_line"
    ,catalog="arkancafe"
)
public class GameLine  implements java.io.Serializable {


     private Integer gameLineId;
     private Game game;
     private Order order;
     private BigDecimal price;
     private Date date;

    public GameLine() {
    }

    public GameLine(Game game, Order order, BigDecimal price, Date date) {
       this.game = game;
       this.order = order;
       this.price = price;
       this.date = date;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="gameLine_id", unique=true, nullable=false)
    public Integer getGameLineId() {
        return this.gameLineId;
    }
    
    public void setGameLineId(Integer gameLineId) {
        this.gameLineId = gameLineId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="service_id", nullable=false)
    public Game getGame() {
        return this.game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false)
    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }

    
    @Column(name="price", nullable=false, precision=10, scale=3)
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date", nullable=false, length=19)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}


