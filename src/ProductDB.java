import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    //--------------------------
    //  ATTRIBUTES
    //--------------------------
    private List<Product> items;

    //--------------------------
    //  CONSTRUCTORS
    //--------------------------
    public ProductDB(){
        this.items = new ArrayList<>();
    }
    //--------------------------
    //  GETTERS
    //--------------------------
    public List<Product> getItems() {
        return this.items;
    }

    //--------------------------
    //  METHODS
    //--------------------------
    public void add(Product p){
        this.items.add(p);
    }

    public void remove(Product p){
        int size = this.items.size();
        if(size == 0)
            System.out.println("ERROR: List is empty.");
        else
            this.items.remove(p);
    }

    //--------------------------
    //  EXTRA FUNCTIONALITY
    //--------------------------
    
}
