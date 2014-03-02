package name.yamamoto.satoshi.persistence.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import name.yamamoto.satoshi.persistence.model.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CategoryRepositoryTest {
	@Inject
	private CategoryRepository repository;

	@Test
	@Transactional
	public void testFind_souldBeFindOne() {
		Category result = repository.find(1L);
		assertThat(result, notNullValue());
		assertThat(result.getId(), equalTo(1L));
		assertThat(result.getParentId(), nullValue());
		assertThat(result.getProducts(), notNullValue());
		assertThat(result.getProducts().isEmpty(), equalTo(false));

		result = repository.find(2L);
		assertThat(result, notNullValue());
		assertThat(result.getParent(), notNullValue());
		assertThat(result.getParent().getName(), equalTo("name1"));
	}
	
	public void testFind_SouldBeFindAll() {
		List<Category> results = repository.findAll();
		assertThat(results, notNullValue());
		assertThat(results.size(), equalTo(2));
	}
	
}
