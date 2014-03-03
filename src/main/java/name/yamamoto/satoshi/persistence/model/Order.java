package name.yamamoto.satoshi.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import name.yamamoto.satoshi.persistence.repository.OrderRepository;

@Entity
@Table(name="orders")
public class Order extends Model {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	private Date purchaseOrderdate;
	private Double totalAmount;
	@OneToMany(mappedBy="order", fetch=FetchType.EAGER)
	private List<OrderLine> orderLines;
	private Date createAt;
	private Date updateAt;
	static transient OrderRepository repository;
	
// -- persistence methods --
	
	public static Order find(long id) {
		return repository.find(id);
	}
	
	public static List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order update() {
		repository.update(this);
		return this;
	}
	
	public Order save() {
		repository.save(this);
		return this;
	}
	
// -- basic methods --
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	

// -- field accesor --
	
	public Long getId() {
		return orderId;
	}
	public void setId(Long id) {
		this.orderId = id;
	}
	public Date getPurchaseOrderdate() {
		return purchaseOrderdate;
	}
	public void setPurchaseOrderdate(Date purchaseOrderdate) {
		this.purchaseOrderdate = purchaseOrderdate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
}
