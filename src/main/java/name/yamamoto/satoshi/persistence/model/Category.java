package name.yamamoto.satoshi.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category extends Model {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	private String name;
	private Long parentId;
	@ManyToOne @JoinColumn(name="categoryId",referencedColumnName="parentId", insertable=false, updatable=false)
	private Category parent;
	@OneToMany(mappedBy="parent")
	private List<Category> children;
	@OneToMany(mappedBy="category")
	private List<Product> products;
	private Date createAt;
	private Date updateAt;

// ---basic methods --
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
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
		Category other = (Category) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		return true;
	}
	
// -- field accesor --

	@Override
	public Long getId() {
		return this.categoryId;
	}

	@Override
	public Date getCreateAt() {
		return createAt;
	}

	@Override
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;		
	}

	@Override
	public Date getUpdateAt() {
		return updateAt;
	}

	@Override
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
