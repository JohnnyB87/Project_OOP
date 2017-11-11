public class TV extends Product{
    //--------------------------
    //  ATTRIBUTES
    //--------------------------
    private String make;
    private int screenSize;
    private String type;
    private boolean is3DCapable;

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

    public void setType(String type) {
        this.type = type;
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
