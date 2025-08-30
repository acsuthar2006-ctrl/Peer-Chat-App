// Subsystems
class SmartphoneRepair {
    void fixScreen() { System.out.println("Fixing smartphone screen..."); }
    void fixBattery() { System.out.println("Replacing smartphone battery..."); }
}

class DigitalWatchRepair {
    void fixStrap() { System.out.println("Fixing digital watch strap..."); }
    void fixBattery() { System.out.println("Replacing digital watch battery..."); }
}

// Facade
class RepairShopFacade {
    private SmartphoneRepair smartphoneRepair;
    private DigitalWatchRepair watchRepair;

    public RepairShopFacade() {
        this.smartphoneRepair = new SmartphoneRepair();
        this.watchRepair = new DigitalWatchRepair();
    }

    public void repairSmartphone() {
        System.out.println("Repairing smartphone:");
        smartphoneRepair.fixScreen();
        smartphoneRepair.fixBattery();
        System.out.println("Smartphone repaired!\n");
    }

    public void repairDigitalWatch() {
        System.out.println("Repairing digital watch:");
        watchRepair.fixStrap();
        watchRepair.fixBattery();
        System.out.println("Digital watch repaired!\n");
    }
}

// Client
public class RepairClient {
    public static void main(String[] args) {
        RepairShopFacade shop = new RepairShopFacade();

        shop.repairSmartphone();      // Simple method call for smartphone repair
        shop.repairDigitalWatch();    // Simple method call for watch repair
    }
}