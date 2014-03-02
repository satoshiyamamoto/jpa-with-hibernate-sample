package name.yamamoto.satoshi.persistence;

import java.util.Arrays;

import javax.transaction.Transactional;

import name.yamamoto.satoshi.persistence.model.Category;
import name.yamamoto.satoshi.persistence.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@Transactional
	public static final void main(String[] args) {

		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {

			for (Product product : Product.findAll()) {
				Category category = product.getCategory();
				String categoryName = category.getParent() == null ? category.getName()
						: category.getParent().getName() + " / " + category.getName();
				String tagName = Arrays.toString(product.getTags().toArray());
				logger.info("category: {}, name: {}, description: {}, price: {}, tags: {}", 
					categoryName, product.getName(), product.getDescription(), product.getPrice(), tagName);

			}
		}
	}

}
