package name.yamamoto.satoshi.persistence;

import java.util.Arrays;
import java.util.Stack;

import javax.transaction.Transactional;

import name.yamamoto.satoshi.persistence.model.Category;
import name.yamamoto.satoshi.persistence.model.Order;
import name.yamamoto.satoshi.persistence.model.OrderLine;
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

			// product details
			for (Product product : Product.findAll()) {
				String tagName = Arrays.toString(product.getTags().toArray());
				String categoryName = formatCategory(product.getCategory());
				String log = String.format(
						"%n-----------------------------------------------------" +
						"%n%-12s: %s" + 
						"%n%-12s: %s" + 
						"%n%-12s: %s" + 
						"%n%-12s: %s" + 
						"%n%-12s: %s" + 
						"%n%-12s: %.2f" + 
						"%n-----------------------------------------------------",
						"ID", product.getId(),
						"Category", categoryName,
						"Tags", tagName,
						"Product", product.getName(),
						"Description", product.getDescription(),
						"Price", product.getPrice()
				); 
				logger.info(log);
			}
			
			// order details
			for (Order order : Order.findAll()) {
				String log = String.format(
						"%n-----------------------------------------------------" +
						"%n%-18s: %s" + 
						"%n%-18s: %s" +
						"%n", 
						"Order No", order.getId(),
						"Puchase orderdate", order.getPurchaseOrderdate()
				); 
				
				for (OrderLine orderLine :order.getOrderLines()) {
					String logline = String.format(
						"%n  %d: %-36s %d x %.2f",
						orderLine.getPk().getOrderLineId(),
						orderLine.getProduct().getName(),
						orderLine.getQuantity(),
						orderLine.getAmount()
					);
					log += logline;
				}
				log += String.format(
						"%n" + 
						"%n%-18s: %s" + 
						"%n-----------------------------------------------------",
						"Total amount", order.getTotalAmount());
				logger.info(log);
			}
			
		}
	}
	
	private static String formatCategory(Category c) {
		Stack<String> stack = new Stack<>();
		stack.push(c.getName());
		while (c.getParent() != null) {
			c = c.getParent();
			stack.push(c.getName());
		}
		StringBuilder sb = new StringBuilder(stack.pop());
		while (!stack.empty()) {
			sb.append(" / ").append(stack.pop());
		}
		return sb.toString();
	}

}
