import java.util.Scanner;

public class TV extends Product{
    //--------------------------
    //  ATTRIBUTES
    //--------------------------
    private String make;
    private int screenSize;
    private String type;
    private boolean is3DCapable;
    private final String[] TVTYPES = {"LED","Plasma","LCD"};

    //--------------------------
    //  GETTERS
    //--------------------------

    public String getMake() {
        return make;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getType() {
        return type;
    }

    public boolean isIs3DCapable() {
        return is3DCapable;
    }

    //--------------------------
    //  SETTERS
    //--------------------------

    public void setMake(String make) {
        this.make = make;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setType() {
        Scanner in = new Scanner(System.in);
        int size = this.TVTYPES.length;
        String menu = "Choose the TV type.";

        for(int i=0; i<size; i++)
            menu += String.format("%d.%s%n", i+1, this.TVTYPES[i]);

        int choice;
        boolean isValid;

        do{
            System.out.println(menu);
            choice = -1;
            if(in.hasNextInt())
                choice = in.nextInt() - 1;
            isValid = choice >= 0 && choice < size;
            if(!isValid)
                System.out.println("Enter a valid entry.");
        }while(!isValid);

        this.type = this.TVTYPES[choice];
    }

    public void setIs3DCapable(boolean is3DCapable) {
        this.is3DCapable = is3DCapable;
    }

    //--------------------------
    //  EXTRA FUNCTIONALITY
    //--------------------------
    public String toString(){
        return String.format("%sProduct Make: %s%n" +
                        "Product Screen Size: %d%n" +
                        "Product Type: %s%n" +
                        "Product is 3D capable: %b%n"
                ,super.toString(), this.make, this.screenSize, this.type,this.is3DCapable);
    }

    public void print(){
        System.out.println(this.toString());
    }
}
