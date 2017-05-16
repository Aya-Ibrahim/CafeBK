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
 * Order generated by hbm2java
 */
@Entity
@Table(name="order"
    ,catalog="arkancafe"
)
public class Order  implements java.io.Serializable {


     private Integer orderId;
     private CafeTable cafeTable;
     private User user;
     private String voucherNumber;
     private Date orderDate;
     private boolean isClosed;
     private Date closedDate;
     private Set<Orderline> orderlines = new HashSet<Orderline>(0);
     private Set<GameLine> gameLines = new HashSet<GameLine>(0);
     private Set<Transaction> transactions = new HashSet<Transaction>(0);

    public Order() {
    }

	
    public Order(CafeTable cafeTable, User user, String voucherNumber, Date orderDate, boolean isClosed, Date closedDate) {
        this.cafeTable = cafeTable;
        this.user = user;
        this.voucherNumber = voucherNumber;
        this.orderDate = orderDate;
        this.isClosed = isClosed;
        this.closedDate = closedDate;
    }
    public Order(CafeTable cafeTable, User user, String voucherNumber, Date orderDate, boolean isClosed, Date closedDate, Set<Orderline> orderlines, Set<GameLine> gameLines, Set<Transaction> transactions) {
       this.cafeTable = cafeTable;
       this.user = user;
       this.voucherNumber = voucherNumber;
       this.orderDate = orderDate;
       this.isClosed = isClosed;
       this.closedDate = closedDate;
       this.orderlines = orderlines;
       this.gameLines = gameLines;
       this.transactions = transactions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="order_id", unique=true, nullable=false)
    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="table_id", nullable=false)
    public CafeTable getCafeTable() {
        return this.cafeTable;
    }
    
    public void setCafeTable(CafeTable cafeTable) {
        this.cafeTable = cafeTable;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cashier_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="voucher_number", nullable=false, length=25)
    public String getVoucherNumber() {
        return this.voucherNumber;
    }
    
    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="order_Date", nullable=false, length=19)
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    
    @Column(name="is_closed", nullable=false)
    public boolean isIsClosed() {
        return this.isClosed;
    }
    
    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="closedDate", nullable=false, length=19)
    public Date getClosedDate() {
        return this.closedDate;
    }
    
    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="order")
    public Set<Orderline> getOrderlines() {
        return this.orderlines;
    }
    
    public void setOrderlines(Set<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="order")
    public Set<GameLine> getGameLines() {
        return this.gameLines;
    }
    
    public void setGameLines(Set<GameLine> gameLines) {
        this.gameLines = gameLines;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="order")
    public Set<Transaction> getTransactions() {
        return this.transactions;
    }
    
    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }




}


