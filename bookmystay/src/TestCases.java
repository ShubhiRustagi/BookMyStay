
import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor - initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        int updated = current + change;

        if (updated >= 0) {
            inventory.put(roomType, updated);
        } else {
            System.out.println("Invalid update! Cannot have negative rooms.");
        }
    }

    public void displayInventory() {
        System.out.println("===== Current Room Inventory =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("==================================");
    }
}

public class TestCases {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        System.out.println("\nBooking 1 Single Room...");
        inventory.updateAvailability("Single Room", -1);

        System.out.println("Adding 2 Double Rooms...");
        inventory.updateAvailability("Double Room", +2);

        // Display updated state
        System.out.println();
        inventory.displayInventory();

        // Check specific availability
        System.out.println("\nAvailable Suite Rooms: " +
                inventory.getAvailability("Suite Room"));
    }
}