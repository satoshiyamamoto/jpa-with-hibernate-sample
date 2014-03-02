package name.yamamoto.satoshi.persistence.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import name.yamamoto.satoshi.persistence.model.Tag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TagRepositoryTest {
	@Inject
	private TagRepository repository;

	@Test
	@Transactional
	public void testFind_souldBeFindOne() {
		Tag result = repository.find(1L);
		assertThat(result, notNullValue());
		assertThat(result.getId(), equalTo(1L));
	}
	
	@Test
	public void testFind_SouldBeFindAll() {
		List<Tag> results = repository.findAll();
		assertThat(results, notNullValue());
		assertThat(results.size(), equalTo(2));
	}
	
}
