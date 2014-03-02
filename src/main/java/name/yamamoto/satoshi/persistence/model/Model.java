package name.yamamoto.satoshi.persistence.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Model implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract Long getId();
	
	public abstract Date getCreateAt();
	
	public abstract void setCreateAt(Date createAt);
	
	public abstract Date getUpdateAt();
	
	public abstract void setUpdateAt(Date updateAt);
	
	public abstract int hashCode();
	
	public abstract boolean equals(Object other);
}
