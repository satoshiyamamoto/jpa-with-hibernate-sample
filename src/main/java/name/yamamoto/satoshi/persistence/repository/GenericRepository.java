package name.yamamoto.satoshi.persistence.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, PK extends Serializable> {
	
	public T find(PK id);
	
	public List<T> findAll();
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);

}
