package beans;
// Generated May 12, 2017 3:22:27 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Orderline generated by hbm2java
 */
@Entity
@Table(name="orderline"
    ,catalog="arkancafe"
)
public class Orderline  implements java.io.Serializable {


     private Integer orderlineId;
     private Item item;
     private Order order;
     private Date date;
     private String status;
     private long price;
     private int quantity;
     private Set<OrderlineAddition> orderlineAdditions = new HashSet<OrderlineAddition>(0);

    public Orderline() {
    }

	
    public Orderline(Item item, Order order, Date date, String status, long price, int quantity) {
        this.item = item;
        this.order = order;
        this.date = date;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
    }
    public Orderline(Item item, Order order, Date date, String status, long price, int quantity, Set<OrderlineAddition> orderlineAdditions) {
       this.item = item;
       this.order = order;
       this.date = date;
       this.status = status;
       this.price = price;
       this.quantity = quantity;
       this.orderlineAdditions = orderlineAdditions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="orderline_Id", unique=true, nullable=false)
    public Integer getOrderlineId() {
        return this.orderlineId;
    }
    
    public void setOrderlineId(Integer orderlineId) {
        this.orderlineId = orderlineId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_id", nullable=false)
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false)
    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Date", nullable=false, length=19)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    
    @Column(name="status", nullable=false, length=25)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="price", nullable=false, precision=10, scale=0)
    public long getPrice() {
        return this.price;
    }
    
    public void setPrice(long price) {
        this.price = price;
    }

    
    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="orderline")
    public Set<OrderlineAddition> getOrderlineAdditions() {
        return this.orderlineAdditions;
    }
    
    public void setOrderlineAdditions(Set<OrderlineAddition> orderlineAdditions) {
        this.orderlineAdditions = orderlineAdditions;
    }




}


