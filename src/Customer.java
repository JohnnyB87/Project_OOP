import java.util.ArrayList;

public class Customer {
    private String name;
    private String address;
    private ArrayList<Order> order;

    //-----------------------------
    //      CONSTRUCTORS
    //-----------------------------
    public Customer(){
        this.order = new ArrayList<>();
    }
    //-----------------------------
    //      GETTERS
    //-----------------------------
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<Order> getOrder() {
        return this.order;
    }

    //-----------------------------
    //      SETTERS
    //-----------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrder(ArrayList<Order> order) {
//        for(Order o : order){
//            Order newO = new Order();
//            newO = o;
//            this.order.add(newO);
//        }
        this.order = order;
    }

    //-----------------------------
    //      METHODS
    //-----------------------------
    public void add(Order o){
        int size = o.getOd().size();
        for(int i=0; i<size; i++){
            OrderDetails od = new OrderDetails(o.get(i).getProduct(),o.get(i).getQuantity());
            Order newO = new Order();
            newO.add(od.getProduct(), od.getQuantity());
            this.order.add(newO);
        }
    }

    public String toString(){
        String str = String.format("Name: %s%nAddress: %s%n",this.name,this.address);
        for(Order o : this.order)
            str += o.toString();
        return str;
    }

    public void print(){
        System.out.println(this.toString());
    }
}
