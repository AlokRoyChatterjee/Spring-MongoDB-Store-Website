package storeitems;

import com.springmvc.springmongodbweb.models.Product;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author didin
 */
public interface StoreItemRespository extends CrudRepository<Product, String> {
    
    @Override
    public void delete(storeitem item);
    
}
