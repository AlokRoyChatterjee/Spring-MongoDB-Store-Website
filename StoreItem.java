package storeitems;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class StoreItem {
    @Id
    String id;
    String itemname;
    String infoitem;
    Double itemamount;
    String item;
   public StoreItem(String itemname, String infoitem, Double itemamount, String item) {
        this.itemname = itemname;
        this.infoitem = infoitem;
        this.itemamount = itemamount;
        this.item = item;
    }

    public String getId() {
        return id;
    }
    public void setitemname(String itemname) {
        this.itemname = itemname;
    }
    public String getitem() {
        return item;
    }

    public void setitem(String item) {
        this.item = item;
    }

    public String getinfoitem() {
        return prodDesc;
    }

    public void setiteminfo(String infoitem) {
        this.infoitem = infoitem;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getitemname() {
        return itemname;
    }

    public Double getitemamount() {
        return itemamount;
    }

    public void setitemamount(Double itemamount) {
        this.itemamount = itemamount;
    }

   
    
}
