package beans;
// Generated Jun 3, 2017 2:01:14 PM by Hibernate Tools 4.3.1


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
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * ItemHasAddition generated by hbm2java
 */
@Entity
@Table(name="item_has_addition"
    ,catalog="arkancafe"
)
public class ItemHasAddition  implements java.io.Serializable {


     private Integer itemAdditionId;
//     @JsonManagedReference
     private Addition addition;
     @JsonBackReference
     private Item item;
//     private Long price;
//     private Integer unitId;
     @JsonBackReference
     private Set<OrderlineAddition> orderlineAdditions = new HashSet<OrderlineAddition>(0);

    public ItemHasAddition() {
    }

	
    public ItemHasAddition(Addition addition, Item item) {
        this.addition = addition;
//        this.item = item;
    }
    public ItemHasAddition(Addition addition, Item item, Long price, Integer unitId, Set<OrderlineAddition> orderlineAdditions) {
       this.addition = addition;
//       this.item = item;
//       this.price = price;
//       this.unitId = unitId;
//       this.orderlineAdditions = orderlineAdditions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="item_addition_Id", unique=true, nullable=false)
    public Integer getItemAdditionId() {
        return this.itemAdditionId;
    }
    
    public void setItemAdditionId(Integer itemAdditionId) {
        this.itemAdditionId = itemAdditionId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="addition_add_id", nullable=false)
    public Addition getAddition() {
        return this.addition;
    }
    
    public void setAddition(Addition addition) {
        this.addition = addition;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_item_id", nullable=false)
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

    
//    @Column(name="price", precision=10, scale=0)
//    public Long getPrice() {
//        return this.price;
//    }
//    
//    public void setPrice(Long price) {
//        this.price = price;
//    }

    
//    @Column(name="unit_id")
//    public Integer getUnitId() {
//        return this.unitId;
//    }
//    
//    public void setUnitId(Integer unitId) {
//        this.unitId = unitId;
//    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="itemHasAddition")
    public Set<OrderlineAddition> getOrderlineAdditions() {
        return this.orderlineAdditions;
    }
    
    public void setOrderlineAdditions(Set<OrderlineAddition> orderlineAdditions) {
        this.orderlineAdditions = orderlineAdditions;
    }




}

