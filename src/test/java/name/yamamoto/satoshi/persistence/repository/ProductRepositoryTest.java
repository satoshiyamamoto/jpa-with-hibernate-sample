package name.yamamoto.satoshi.persistence.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.inject.Inject;

import name.yamamoto.satoshi.persistence.model.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ProductRepositoryTest {
	@Inject
	private ProductRepository repository;

	@Test
	public void testFindOne_souldBeFindOne() {
		Product result = repository.find(1L);
		assertThat(result, notNullValue());
		assertThat(result.getId(), equalTo(1L));
		assertThat(result.getCategory(), notNullValue());
	}
	
	@Test
	public void testFind_SouldBeFindAll() {
		List<Product> results = repository.findAll();
		assertThat(results, notNullValue());
		assertThat(results.size(), equalTo(2));
	}
	
	
}
