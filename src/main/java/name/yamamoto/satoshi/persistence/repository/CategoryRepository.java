package name.yamamoto.satoshi.persistence.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import name.yamamoto.satoshi.persistence.model.Category;

@Named
public class CategoryRepository implements GenericRepository<Category, Long> {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Category find(Long id) {
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> findAll() {
		return em.createQuery("select p from Product p", Category.class).getResultList();
	}

	@Override
	public void save(Category entity) {
		em.persist(entity);
		em.flush();
	}

	@Override
	public void update(Category entity) {
		if (find(entity.getId()) == null) {
			save(entity);
			return;
		}
		em.flush();
	}

	@Override
	public void delete(Category entity) {
		em.remove(entity);
		em.flush();
	}

}