package name.yamamoto.satoshi.persistence.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import name.yamamoto.satoshi.persistence.model.Tag;

@Named
public class TagRepository implements GenericRepository<Tag, Long> {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Tag find(Long id) {
		return em.find(Tag.class, id);
	}

	@Override
	public List<Tag> findAll() {
		return em.createQuery("select t from Tag t", Tag.class).getResultList();
	}

	@Override
	public void save(Tag entity) {
		em.persist(entity);
		em.flush();
	}

	@Override
	public void update(Tag entity) {
		if (find(entity.getId()) == null) {
			save(entity);
			return;
		}
		em.flush();
	}

	@Override
	public void delete(Tag entity) {
		em.remove(entity);
		em.flush();
	}

}