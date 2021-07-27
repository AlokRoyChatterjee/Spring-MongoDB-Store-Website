package storeitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.springmvc.springmongodbweb.repositories")
public class StoreProductsWebsite {

	public static void main(String[] args) {
		SpringApplication.run(StoreproductsWebsite.class, args);
	}
}
