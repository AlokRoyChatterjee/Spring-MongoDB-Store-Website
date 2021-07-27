
package storeproducts;

import com.springmvc.springmongodbweb.models.Product;
import com.springmvc.springmongodbweb.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author didin
 */
@Controller
public class StoreProductController {

    @Autowired
    StoreItemRepository itemrepository;

    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("products", itemrepository.findAll());
        return "storeproduct";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "addstoreproduct";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
        StoreItem product = new StoreIem();
        product.setProdName(prodName);
        product.setProdDesc(prodDesc);
        product.setProdPrice(prodPrice);
        product.setProdImage(prodImage);
        productRepository.save(product);

        return "redirect:/show/" + product.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("product", itemrepository.findById(id).get());
        return "storeproductsdisplay";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Optional<Product> product = itemrepository.findById(id);
        itemrepository.delete(product.get());

        return "redirect:/product";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product", itemrepository.findById(id).get());
        return "changestoreproduct";
    }
    
    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
        Optional<StoreItem> product = itemrepository.findById(id);
        product.get().setProdName(prodName);
        product.get().setProdDesc(prodDesc);
        product.get().setProdPrice(prodPrice);
        product.get().setProdImage(prodImage);
        productRepository.save(product.get());

        return "redirect:/show/" + product.get().getId();
    }
}
