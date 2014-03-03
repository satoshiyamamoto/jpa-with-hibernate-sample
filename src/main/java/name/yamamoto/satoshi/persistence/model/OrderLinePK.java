package name.yamamoto.satoshi.persistence.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderLinePK implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long orderId;
	private Long orderLineId;
	
	public OrderLinePK() {}
	
	public OrderLinePK(long orderId, long orderLineId) {
		super();
		this.orderId = orderId;
		this.orderLineId = orderLineId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((orderLineId == null) ? 0 : orderLineId.hashCode());
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
		OrderLinePK other = (OrderLinePK) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderLineId == null) {
			if (other.orderLineId != null)
				return false;
		} else if (!orderLineId.equals(other.orderLineId))
			return false;
		return true;
	}



	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}
}