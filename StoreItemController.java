
package storeitems;
import com.springmvc.springmongodbweb.models.Product;
import com.springmvc.springmongodbweb.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StoreProductController {
    @Autowired
    StoreItemRepository itemrepository;
     @RequestMapping("/save")
    public String save(@RequestParam String itemname, @RequestParam String infoitem, @RequestParam Double itemamount, @RequestParam String item) {
        StoreItem item = new StoreIem();
        item.setitemanme(itemname);
        item.setiteminfo(infoitem);
        item.setitemamount(prodPrice);
        item.setitem(item);
        itemrepository.save(item);

        return "redirect:/show/" + product.getId();
    }

    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("products", itemrepository.findAll());
        return "StoreItem";
    }

   
      @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product", itemrepository.findById(id).get());
        return "ChangeStoreItem";
    }
      @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String itemname, @RequestParam String infoitem, @RequestParam Double itemamount, @RequestParam String item) {
        Optional<StoreItem> item = itemrepository.findById(id);
        item.get().setitemname(itemname);
        item.get().setiteminfo(infoitem);
        item.get().setitemamount(itemamount);
        item.get().setitem(item);
        itemRepository.save(item.get());

        return "redirect:/show/" + item.get().getId();
    }
   
     @RequestMapping("/create")
    public String create(Model model) {
        return "addstoreproduct";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Optional<StoreItem> item = itemrepository.findById(id);
        itemrepository.delete(item.get());
        return "redirect:/product";
    }
    
       @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("product", itemrepository.findById(id).get());
        return "storeproductsdisplay";
    }
    
  
}
