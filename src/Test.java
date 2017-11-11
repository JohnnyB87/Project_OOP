public class Test {

    public static void main(String [] args){

        Phone p = Test.createPhone();
        TV t = Test.createTV();

        ProductDB db = new ProductDB();
        db.add(p);
        db.add(t);
        db.add(t);

        //-------------- Test print()-------------------

        System.out.print("\n-------------- Test print()-------------------\n");

        System.out.println(db.getItems().toString());
        db.remove(t);
        System.out.println(db.getItems().toString());
        p.print();
        t.print();
    }

    private static Phone createPhone(){
        Phone p = new Phone();
        p.setName("Samsung");
        p.setDescription("Phone");
        p.setPrice(600);
        //p.setProductID(123);
        p.setMake("Samsung");
        p.setModel("S7");
        p.setStorageGB(32);
        return p;
    }

    private static TV createTV(){
        TV t = new TV();
        t.setName("Sony");
        t.setDescription("TV");
        t.setPrice(600);
       // t.setProductID(123);
        t.setMake("Sony");
        t.setScreenSize(32);
        t.setType("LED");
        t.setIs3DCapable(false);
        return t;
    }
}
