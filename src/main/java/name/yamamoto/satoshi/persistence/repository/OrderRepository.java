package name.yamamoto.satoshi.persistence.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import name.yamamoto.satoshi.persistence.model.Order;

@Named
public class OrderRepository implements GenericRepository<Order, Long> {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Order find(Long id) {
		return em.find(Order.class, id);
	}

	@Override
	public List<Order> findAll() {
		return em.createQuery("select o from Order o", Order.class).getResultList();
	}

	@Override
	public void save(Order entity) {
		em.persist(entity);
		em.flush();
	}

	@Override
	public void update(Order entity) {
		if (find(entity.getId()) == null) {
			save(entity);
			return;
		}
		em.flush();
	}

	@Override
	public void delete(Order entity) {
		em.remove(entity);
		em.flush();
	}

}