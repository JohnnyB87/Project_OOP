public class Phone extends Product{
    //--------------------------
    //  ATTRIBUTES
    //--------------------------
    private String make;
    private String model;
    private int storageGB;

    //--------------------------
    //  GETTERS
    //--------------------------
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getStorageGB() {
        return storageGB;
    }
    //--------------------------
    //  SETTERS
    //--------------------------
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    //--------------------------
    //  EXTRA FUNCTIONALITY
    //--------------------------
    public String toString(){
        return String.format("%sProduct Make: %s%n" +
                        "Product Model: %s%n" +
                        "Product Storage in GB: %d%n"
                ,super.toString(), this.make, this.model, this.storageGB);
    }

    public void print(){
        System.out.println(this.toString());
    }
}
