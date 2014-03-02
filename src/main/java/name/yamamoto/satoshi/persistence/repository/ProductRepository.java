package name.yamamoto.satoshi.persistence.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import name.yamamoto.satoshi.persistence.model.Product;

@Named
public class ProductRepository implements GenericRepository<Product, Long> {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Product find(Long id) {
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public void save(Product entity) {
		em.persist(entity);
		em.flush();
	}

	@Override
	public void update(Product entity) {
		if (find(entity.getId()) == null) {
			save(entity);
			return;
		}
		em.flush();
	}

	@Override
	public void delete(Product entity) {
		em.remove(entity);
		em.flush();
	}

}