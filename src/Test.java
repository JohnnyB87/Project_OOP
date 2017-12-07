import java.util.Scanner;

public class Test {

    private static Scanner in = new Scanner(System.in);

    public static void main(String [] args){
        Phone p = Test.createPhone();
        TV t = Test.createTV();

        ProductDB db1 = new ProductDB();
        db1.add(p);
        db1.add(t);
        db1.add(t);


        //-------------- Test print()-------------------

        System.out.print("\n-------------- Test print()-------------------\n");

        System.out.println(db1.getItems().toString());
        db1.remove(t);
        System.out.println(db1.getItems().toString());
//        p.print();
//        t.print();


        System.out.print("\n-------------- Test find()-------------------\n");
        System.out.println(db1.find(1));
        System.out.println(db1.find(10));


        System.out.print("\n-------------- Test Customer-------------------\n");

        Order o = new Order();
        o.add(p,3);
        o.add(p,5);


        Order o2 = new Order();
        o2.add(p,6);
        o2.add(t,5);

        Customer joe = new Customer();
        joe.setName("Joe");
        joe.setAddress("Cork");
        joe.add(o);
        joe.add(o2);
        joe.print();


        o.add(t,3);

        Customer alice = new Customer();
        alice.setName("Alice");
        alice.setAddress("Dublin");
        alice.add(o);

        joe.print();
        alice.print();




        in.close();
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
        t.setType();
        t.setIs3DCapable(false);
        return t;
    }
}
