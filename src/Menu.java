import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

        private Scanner in = new Scanner(System.in);
        private ProductDB db = new ProductDB();
        private ProductDB db2 = new ProductDB();
        private ArrayList<Customer> orders = new ArrayList<>();

        private void printMenu(){
            System.out.println("\n-------------MENU----------------\n" +
                    "1. Create a Phone.\n" +
                    "2. Search for a product by supplying the productid.\n" +
                    "3. Display all products.\n" +
                    "4. Order Products.\n" +
                    "5. Display all orders.\n" +
                    "6. Quit\n");
            System.out.print("Choice: ");
        }

        public void runMenu(){
            int choice = 0;
            do{
                boolean isValid = false;
                do{
                    printMenu();
                    if(in.hasNextInt()){
                        choice = in.nextInt();
                        isValid = true;
                    }
                    in.nextLine();
                }while(!isValid);

                switch(choice){
                    case 1:
                        Phone p = createPhone();
                        db.add(p);
                        break;
                    case 2:
                        Product pr = getProduct();
                        System.out.println(pr);
                        break;
                    case 3:
                        displayAllProducts();
                        break;
                    case 4:
                        orderProducts();
                        break;
                    case 5:
                        displayOrdders();
                        break;
                    case 6: System.out.println("You decided to quit.");
                        break;
                    default: System.out.println("Invalid choice");
                        break;
                }
            }while(choice != 6);
        }

        private Phone createPhone(){
            System.out.print("Enter phone name: ");
            String name = getValidInput("name");

            System.out.print("Enter description: ");
            String description = getValidInput("description");

            System.out.print("Enter price: ");
            double price = getValidInput();

            System.out.print("Enter make: ");
            String make = getValidInput("make");

            System.out.print("Enter model: ");
            String model = getValidInput("model");

            System.out.print("Enter Storage size in GB: ");
            int storage = (int)getValidInput();

            return new Phone(name, description, price, make, model, storage);
        }

        private Product getProduct(){
            System.out.println("Enter a Product by ID number.");
            int choice = (int)getValidInput();
            return db.find(choice);
        }

        private void displayAllProducts(){
            System.out.println(db.getItems().toString());
        }

        private void orderProducts(){
            System.out.print("Enter customer name: ");
            String name = getValidInput("customer name");
            Customer c = null;
            for(Customer x : this.orders)
                if(x.getName().equalsIgnoreCase(name))
                    c = x;

            if(c == null) {
                c = new Customer();
                c.setName(name);
                this.orders.add(c);
            }

            int choice = 0;
            Order o = new Order();
            while(choice != -1){
                System.out.println("Enter a product id and a quantity. Enter -1 to finish");
                System.out.print("Enter id: ");
                choice = (int)getValidInput();
                if(choice != -1) {
                    System.out.print("Enter quantity: ");
                    int quantity = (int) getValidInput();
                    Product p = db.find(choice);
                    o.add(p,quantity);

                    System.out.printf("You ordered: %d %s%n" ,quantity, p.getName());
                }
            }
            c.add(o);
        }

        private void displayOrdders(){
            System.out.print("Enter customer name: ");
            String name = getValidInput("customer name");
            for(Customer c : this.orders){
                if(c.getName().equalsIgnoreCase(name)){
                    c.print();
                }
            }
        }

        private String getValidInput(String name){
            String str = "";
            boolean isValid;
            do{
                isValid = true;
                str = this.in.nextLine();
                if(str.length()==0 || !Character.isAlphabetic(str.charAt(0))) {
                    System.out.println("ERROR: Invalid Input.");
                    System.out.printf("Enter %s: ",name);
                    isValid = false;
                }
            }while(!isValid);
            return str;
        }

        private double getValidInput(){
            boolean isValid;
            double value = 0;
            do{
                isValid = false;
                if(this.in.hasNextDouble()) {
                    value = this.in.nextDouble();
                    isValid = true;
                }
                else
                    System.out.print("Enter a number: ");
                this.in.nextLine();
            }while(!isValid);
            return value;
        }

        public void addToDB(Product p){
            this.db.add(p);
        }
}
