
abstract class Room {

    protected String type;
    protected int beds;
    protected int size;
    protected double price;

    public Room(String type, int beds, int size, double price){
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayDetails(){
        System.out.println("Room Type: "+type);
        System.out.println("Beds: "+beds);
        System.out.println("Size: "+size+" sq ft");
        System.out.println("Price: $"+price);
    }
}